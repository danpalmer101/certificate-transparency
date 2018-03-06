package io.danpalmer101.certificatetransparency.security;

import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/**
 * TrustManager implementation that is a composite of a list of other TrustManagers.
 * If any one of the list of TrustManagers accepts the request, then so does this composite.
 */
public class CompositeTrustManager implements X509TrustManager {

    private final List<X509TrustManager> trustManagers;

    public CompositeTrustManager() {
        try {
            TrustManagerFactory factory =
                    TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            factory.init((KeyStore) null);

            // Find all X509TrustManager implementations
            this.trustManagers = new ArrayList<>();
            for (TrustManager tm : Arrays.asList(factory.getTrustManagers())) {
                if (tm instanceof X509TrustManager) {
                    this.trustManagers.add((X509TrustManager)tm);
                }
            }
        } catch (NoSuchAlgorithmException | KeyStoreException e) {
            throw new RuntimeException("Unable to load TrustManagers", e);
        }
    }

    public CompositeTrustManager(List<X509TrustManager> trustManagers) {
        this.trustManagers = trustManagers;
    }

    @Override
    public void checkServerTrusted(X509Certificate[] x509Certificates, String authType)
            throws CertificateException {
        // Check each trust manager
        for (X509TrustManager tm : this.trustManagers) {
            try {
                tm.checkServerTrusted(x509Certificates, authType);
                return;
            } catch (CertificateException e) {
                // Ignore, the next trust manager will be tried
            }
        }

        // No trust managers passed, fail
        throw new CertificateException("This certificate chain is not trusted by any TrustManager");
    }

    @Override
    public void checkClientTrusted(X509Certificate[] x509Certificates, String authType)
            throws CertificateException {
        // Check each trust manager
        for (X509TrustManager tm : this.trustManagers) {
            try {
                tm.checkClientTrusted(x509Certificates, authType);
                return;
            } catch (CertificateException e) {
                // Ignore, the next trust manager will be tried
            }
        }

        // No trust managers passed, fail
        throw new CertificateException("This certificate chain is not trusted by any TrustManager");
    }

    @Override
    public X509Certificate[] getAcceptedIssuers() {
        List<X509Certificate> certificates = new ArrayList<>();

        for (X509TrustManager tm : this.trustManagers) {
            Collections.addAll(certificates, tm.getAcceptedIssuers());
        }

        return certificates.toArray(new X509Certificate[0]);
    }

}
