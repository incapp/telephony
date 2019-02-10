package com.incapp.telephony;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ContactDetailActivity extends AppCompatActivity {

    private TextView textviewDiplayname;
    private ImageView imageviewCall;
    private ImageView imageviewPhone;
    private TextView textviewPhoneno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_detail);
        textviewDiplayname = findViewById(R.id.textview_diplayname);
        imageviewCall = findViewById(R.id.imageview_call);
        imageviewPhone = findViewById(R.id.imageview_phone);
        textviewPhoneno = findViewById(R.id.textview_phoneno);

        final Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        final String number = intent.getStringExtra("number");

        textviewDiplayname.setText(name);
        textviewPhoneno.setText(number);

        imageviewCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent1 = new Intent(Intent.ACTION_CALL,
                        Uri.parse("tel:" +number));
                startActivity(intent1);
            }
        });

        imageviewPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent1 = new Intent(Intent.ACTION_DIAL,
                        Uri.parse("tel:" +number));
                startActivity(intent1);
            }
        });
    }
}
