package com.example.testapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.download_pdf)
    Button download_pdf;
    @BindView(R.id.view_pdf)
    Button view_pdf;

    int READ_EXTERNAL_PERMISSION = 110;
    int WRITE_EXTERNAL_PERMISSION = 120;
    int READ_WRITE_PERMISSION = 130;

    String fileName;
    String fileUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
//        fileUrl = "https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf";
        fileUrl = "http://www.africau.edu/images/default/sample.pdf";

        fileName = "Ticket.pdf";
        download_pdf.setOnClickListener(view -> {
            checkReadWritePermission();
        });
        view_pdf.setOnClickListener(view -> {
            viewPdf();
        });
    }


    private void viewPdf() {
        Intent intent = new Intent(this,ViewPdf.class);
        intent.putExtra("pdfUrl",fileUrl);
        intent.putExtra("fileName",fileName);
        startActivity(intent);
    }

    private void downloadPDF() {
        new TransactionReceiptDownload().execute(fileUrl, fileName);
    }

    private void checkReadWritePermission() {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED
                    && ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                downloadPDF();
            } else {
                requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.WRITE_EXTERNAL_STORAGE},READ_WRITE_PERMISSION);
            }
        } else {
            downloadPDF();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == READ_WRITE_PERMISSION
                && grantResults[0] == PackageManager.PERMISSION_GRANTED
                && grantResults[1] == PackageManager.PERMISSION_GRANTED) {
            downloadPDF();
        } else {
            Toast.makeText(this, "Permission Request: Please Grant the permissions", Toast.LENGTH_SHORT).show();
        }
    }

    public void showPop() {
        Toast.makeText(this, "Download Complete", Toast.LENGTH_SHORT).show();
    }
}