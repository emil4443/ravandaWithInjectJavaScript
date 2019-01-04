package com.example.admin.ravanda;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    WebView wb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        wb = (WebView) findViewById(R.id.webview);
        wb.setWebViewClient(new WebViewClient());
        wb.getSettings().setJavaScriptEnabled(true);
        wb.loadUrl("http://ravanda.ru/i-exam/p/Химия");
        String que = wb.getUrl();
        wb.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);

                            view.loadUrl(
                                    "javascript:$(function() {$('.adsbygoogle').remove();" +
                                    "$('body').css('padding', '0');"+
                                    "$('#google_pedestal_container').remove();"  +
                                    "});");


            }

        });

        wb.loadUrl(que);

    }

    @Override
    public void onBackPressed(){
        if(wb.canGoBack()){
            wb.goBack();
        }else{
            if (doubleBackToExitPressedOnce) {
                return;
            }

            this.doubleBackToExitPressedOnce = true;
            Toast.makeText(this, "Чтобы выйти нужно нажать кнопку HOME", Toast.LENGTH_SHORT).show();

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    doubleBackToExitPressedOnce=false;
                }
            }, 2000);
        }
    }


    boolean doubleBackToExitPressedOnce = false;



}
