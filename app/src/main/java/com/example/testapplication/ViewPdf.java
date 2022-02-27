package com.example.testapplication;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ViewPdf extends AppCompatActivity {

    @BindView(R.id.pdf_web_view)
    WebView pdfWebView;
    @BindView(R.id.back_btn)
    TextView backBtn;
    @BindView(R.id.close)
    TextView closeBtn;
    @BindView(R.id.title)
    TextView title;

    String _mPdfUrl = "";
    String _mFileName = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview_activity);
        ButterKnife.bind(this);
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading Data...");
        progressDialog.setCancelable(false);
        _mPdfUrl = "https://docs.google.com/gview?embedded=true&url=" + getIntent().getStringExtra("pdfUrl");
        _mFileName = getIntent().getStringExtra("fileName");

        title.setText(_mFileName);
        backBtn.setOnClickListener(v -> {
            onBackPressed();
        });
        closeBtn.setOnClickListener(v -> {
            onBackPressed();
        });

        pdfWebView.requestFocus();
        pdfWebView.getSettings().setJavaScriptEnabled(true);

//        pdfWebView.setWebViewClient(new WebViewClient());
//        pdfWebView.getSettings().setSupportZoom(true);
        pdfWebView.loadUrl(_mPdfUrl);
        pdfWebView.reload();
        pdfWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
//        pdfWebView.setWebChromeClient(new WebChromeClient() {
//            public void onProgressChanged(WebView view, int progress) {
//                Log.d("Progress",String.valueOf(progress));
//                if (progress < 100) {
//                    progressDialog.show();
//                }
//                if (progress == 100) {
//                    progressDialog.dismiss();
//                }
//            }
//        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        pdfWebView.invalidate();
        pdfWebView.clearCache(true);
        finish();
    }
}
