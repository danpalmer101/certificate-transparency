package io.danpalmer101.certificatetransparency;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.IOException;
import java.security.GeneralSecurityException;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import io.danpalmer101.certificatetransparency.security.CTTrustManager;
import io.danpalmer101.certificatetransparency.security.CompositeTrustManager;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Test valid and invalid URLs
        testConnection("https://sha256.badssl.com", true);
        testConnection("https://invalid-expected-sct.badssl.com", false);
    }

    private void testConnection(final String url, final boolean expectedSuccess) {
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

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                if (expectedSuccess) {
                    Log.e("HTTP", "Connection to " + url + " failed when we expected success", e);
                } else {
                    Log.d("HTTP", "Connection to " + url + " failed as expected");
                }
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (!expectedSuccess) {
                    Log.e("HTTP", "Connection to " + url + " succeeded whe we expected failure");
                } else {
                    Log.d("HTTP", "Connection to " + url + " succeeded as expected");
                }
            }
        });
    }


}
