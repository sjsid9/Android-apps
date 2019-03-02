package com.infisoln.siddhant.browser;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        final WebView webView =findViewById(R.id.webView);
        webView.loadUrl("https://www.google.com");
        webView.setWebViewClient(new WebViewClient());
        WebSettings webSettings =webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        final EditText editText = (EditText) findViewById(R.id.etUrl);

        Button btnSubmit = findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String url= editText.getText().toString();
                Toast.makeText(MainActivity.this,url, Toast.LENGTH_SHORT).show();
                webView.loadUrl("https://"+url);
            }
        });

        Intent intent = getIntent();

        if(intent.getData()!=null){
            Uri uri = intent.getData();
            webView.loadUrl(uri.toString());
        }

    }
}
