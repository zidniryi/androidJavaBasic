package com.dicodi.me;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DataActivity extends AppCompatActivity {
    public static final String EXTRA_AGE = "extra_age";
    public static final String EXTRA_NAME = "extra_name";
    public static final String EXTRA_BIO = "extra_bio";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
        TextView tvDataReceived = findViewById(R.id.tv_data_received);

        String name = getIntent().getStringExtra(EXTRA_NAME);
        String bio = getIntent().getStringExtra(EXTRA_BIO);
        int age =  getIntent().getIntExtra(EXTRA_AGE, 0);

        String data = "Nama :" + name + "\nUmur :" + age + "\nBio :" + bio;
        tvDataReceived.setText(data);

    }
}
