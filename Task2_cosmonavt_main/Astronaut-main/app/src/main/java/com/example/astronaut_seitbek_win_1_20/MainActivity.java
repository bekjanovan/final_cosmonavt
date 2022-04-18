package com.example.astronaut_seitbek_win_1_20;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText wishes;
    Button sendWishes1;
    Button sendWishes2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        wishes = (EditText) findViewById(R.id.et_my_wishes_to_astronavt);
        sendWishes1 = (Button) findViewById(R.id.btn_send);
        sendWishes2 = (Button) findViewById(R.id.btn_send2);
        System.out.println("asd");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @SuppressLint("IntentReset")
    protected void sendEmail() {
        Log.i("Send email", "");
//        String[] TO = {""};
//        String[] CC = {""};
        Intent emailIntent = new Intent(Intent.ACTION_SEND);

        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
//        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
//        emailIntent.putExtra(Intent.EXTRA_CC, CC);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Hi!");
        emailIntent.putExtra(Intent.EXTRA_TEXT, wishes.getText().toString());
        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            finish();
            Log.i("Finish", "");
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(MainActivity.this, "There is no email client installed.",
                    Toast.LENGTH_SHORT).show();
        }
    }

    public void onClick1(View view) {
        wishes = (EditText) findViewById(R.id.et_my_wishes_to_astronavt);
        sendWishes1 = (Button) findViewById(R.id.btn_send);
        sendWishes2 = (Button) findViewById(R.id.btn_send2);

        sendWishes1.setVisibility(View.INVISIBLE);
        wishes.setVisibility(View.VISIBLE);
        wishes.setCursorVisible(true);
        sendWishes2.setVisibility(View.VISIBLE);
    }

    public void onClick2(View view) {
        sendEmail();
    }
}