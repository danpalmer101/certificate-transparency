package io.danpalmer101.certificatetransparency.security;

import org.conscrypt.ct.CTLogStore;
import org.conscrypt.ct.CTLogStoreImpl;
import org.conscrypt.ct.CTPolicy;
import org.conscrypt.ct.CTPolicyImpl;
import org.conscrypt.ct.CTVerificationResult;
import org.conscrypt.ct.CTVerifier;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Arrays;

import javax.net.ssl.X509TrustManager;

/**
 * TrustManager implementation which adds Certificate Transparency checks
 * to the existing TrustManager (delegate)
 */
public class CTTrustManager implements X509TrustManager {

    private final X509TrustManager delegateTrustManager;

    private final CTVerifier verifier;
    private final CTPolicy policy;

    public CTTrustManager(X509TrustManager delegateTrustManager, int minimumLogCount) {
        this.delegateTrustManager = delegateTrustManager;

        CTLogStore store = new CTLogStoreImpl();
        this.verifier = new CTVerifier(store);
        this.policy = new CTPolicyImpl(store, minimumLogCount);
    }

    @Override
    public void checkServerTrusted(X509Certificate[] x509Certificates, String authType)
            throws CertificateException {
        // Check the delegate
        this.delegateTrustManager.checkServerTrusted(x509Certificates, authType);

        // check Certificate Transparency
        checkCertificateTransparency(x509Certificates);
    }

    @Override
    public void checkClientTrusted(X509Certificate[] x509Certificates, String authType)
            throws CertificateException {
        // Check the delegate
        this.delegateTrustManager.checkClientTrusted(x509Certificates, authType);

        // check Certificate Transparency
        checkCertificateTransparency(x509Certificates);
    }

    @Override
    public X509Certificate[] getAcceptedIssuers() {
        return this.delegateTrustManager.getAcceptedIssuers();
    }

    private void checkCertificateTransparency(X509Certificate[] x509Certificates)
            throws CertificateException {
        CTVerificationResult cvr = this.verifier.verifySignedCertificateTimestamps(
                Arrays.asList(x509Certificates), null, null);

        if (!this.policy.doesResultConformToPolicy(cvr, null, x509Certificates)) {
            throw new CertificateException("Certificate Transparency checks failed."
                    + " valid SCTs = " + cvr.getValidSCTs().size()
                    + ", invalid SCTs = " + cvr.getInvalidSCTs().size());
        }
    }

}
