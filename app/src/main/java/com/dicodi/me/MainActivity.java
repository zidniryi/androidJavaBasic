package com.dicodi.me;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.style.LineHeightSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText edtWidth, edtHeight, edtLength;
    private Button btnCalculate;
    private TextView tvResult;
    String bio = "Selalu ada jalan untuk melakukan hal lebih baik, temukan itu";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button buttonMove =  findViewById(R.id.button_move);
        Button buttonData = findViewById(R.id.button_data);
        Button buttonDial = findViewById(R.id.button_dial);
        Button buttonLayout = findViewById(R.id.button_layout);
        Button buttonProduk = findViewById(R.id.button_produk);

        edtWidth = findViewById(R.id.edt_width);
        edtHeight = findViewById(R.id.edt_height);
        edtLength = findViewById(R.id.edt_length);
        btnCalculate = findViewById(R.id.btn_calculate);
        tvResult = findViewById(R.id.tv_result);

        btnCalculate.setOnClickListener(this);

        buttonMove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moveIntent = new Intent(MainActivity.this, MoveActivity.class);
                startActivity(moveIntent);
            }
        });
        buttonData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moveData = new Intent(MainActivity.this, DataActivity.class);
                moveData.putExtra(DataActivity.EXTRA_NAME, "Zidniryi");
                moveData.putExtra(DataActivity.EXTRA_AGE, 19);
                moveData.putExtra(DataActivity.EXTRA_BIO, bio);
                startActivity(moveData);
            }
        });
        buttonDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phonNumber = "083844164133";
                Intent dial = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phonNumber));
                startActivity(dial);
            }
        });
        buttonProduk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moveLayout = new Intent(MainActivity.this, MainLayout.class);
                startActivity(moveLayout);

            }
        });

        buttonLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moveProduk =  new Intent(MainActivity.this, Produk.class);
                startActivity(moveProduk);
            }
        });
    }
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_calculate) {
            String inputLength = edtLength.getText().toString().trim();
            String inputWidth = edtWidth.getText().toString().trim();
            String inputHeight = edtHeight.getText().toString().trim();

            boolean isEmptyFields = false;
            boolean isInvalidDouble = false;

            if (TextUtils.isEmpty(inputLength)) {
                isEmptyFields = true;
                edtLength.setError("Ini Tidak Boleh Kosong");
            }

            if (TextUtils.isEmpty(inputWidth)) {
                isEmptyFields = true;
                edtWidth.setError("Ini Tidak Boleh Kosong Juga");
            }

            if (TextUtils.isEmpty(inputHeight)) {
                isEmptyFields = true;
                edtHeight.setError("Apalagi Ini");
            }

            Double length = toDouble(inputLength);
            Double width = toDouble(inputWidth);
            Double height = toDouble(inputHeight);

            if (length == null) {
                isInvalidDouble = true;
                edtLength.setError("Jangan Ngawur Inputnya");
            }

            if (width == null) {
                isInvalidDouble = true;
                edtWidth.setError("Ini Juga Jangan Ngawur");
            }

            if (height == null) {
                isInvalidDouble = true;
                edtHeight.setError("Udah Dibilangin Jangan Ngawur");
            }

            if (!isEmptyFields && !isInvalidDouble) {
                double volume = length * width * height;
                tvResult.setText(String.valueOf(volume));
            }
        }
    }


    private Double toDouble(String str) {
        try {
            return Double.valueOf(str);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}