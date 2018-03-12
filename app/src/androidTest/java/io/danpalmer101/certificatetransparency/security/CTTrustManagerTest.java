package io.danpalmer101.certificatetransparency.security;

import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.security.GeneralSecurityException;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class CTTrustManagerTest {

    @Test
    public void testValid() {
        testConnection("https://sha256.badssl.com", null);
    }

    @Test
    public void testInvalidExpectedSct() {
        testConnection("https://invalid-expected-sct.badssl.com", SSLHandshakeException.class);
    }

    @Test
    public void testInvalidExpired() {
        testConnection("https://expired.badssl.com", SSLHandshakeException.class);
    }

    @Test
    public void testInvalidSelfSigned() {
        testConnection("https://self-signed.badssl.com", SSLHandshakeException.class);
    }

    private void testConnection(final String url, final Class expectedException) {
        X509TrustManager trustManager;
        SSLSocketFactory sslSocketFactory;
        try {
            trustManager = new CTTrustManager(new CompositeTrustManager(), 2);
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, new TrustManager[] { trustManager }, null);
            sslSocketFactory = sslContext.getSocketFactory();
        } catch (GeneralSecurityException e) {
            throw new RuntimeException(e);
        }

        OkHttpClient client = new OkHttpClient.Builder()
                .sslSocketFactory(sslSocketFactory, trustManager)
                .build();

        Request request = new Request.Builder()
                .url(url)
                .build();

        try {
            Response response = client.newCall(request).execute();

            assertEquals("Incorrect response", expectedException, null);
            assertTrue("Expected successful response", response.isSuccessful());
        } catch (IOException e) {
            assertEquals("Unexpected exception", expectedException, e.getClass());
        }
    }

}
