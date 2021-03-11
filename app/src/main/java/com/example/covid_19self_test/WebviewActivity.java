package com.example.covid_19self_test;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;

public class WebviewActivity extends AppCompatActivity {
    WebView webView;
    @Override
    public void onBackPressed() {
        if (webView.canGoBack()){
            webView.goBack();
        }else{

            AlertDialog.Builder builder = new AlertDialog.Builder(WebviewActivity.this);
            builder.setMessage("Are you sure you want to Exit?")
                    .setNegativeButton("No",null)
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                            finishAffinity();
                        }
                    }).show();
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
         webView= findViewById(R.id.webView);
        final FrameLayout dialog = findViewById(R.id.progressDialog);

        webView.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                dialog.setVisibility(View.VISIBLE);
                if (newProgress ==100) {
                    dialog.setVisibility(View.GONE);
                }
                super.onProgressChanged(view, newProgress);
            }
        });
        webView.loadUrl("https://www.google.com");
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url) {
                dialog.setVisibility(View.INVISIBLE);
                super.onPageFinished(view, url);
            }
        });


    }
}