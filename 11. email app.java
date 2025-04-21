package com.example.admin.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get the button reference
        Button startBtn = findViewById(R.id.sendbttn);
        
        // Set the onClick listener for the button
        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendEmail();
            }
        });
    }

    protected void sendEmail() {
        Log.i("Send email", "");

        // Get the email and message content from EditText
        EditText recipientEditText = findViewById(R.id.editText);
        EditText subjectEditText = findViewById(R.id.editText2);
        EditText messageEditText = findViewById(R.id.editText3);

        String recipient = recipientEditText.getText().toString();
        String subject = subjectEditText.getText().toString();
        String message = messageEditText.getText().toString();

        // Create email intent
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:")); 
        emailIntent.setType("text/plain");

        // Pass email details
        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{recipient});
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
        emailIntent.putExtra(Intent.EXTRA_TEXT, message);

        // Add CC if needed
        String[] cc = {"ramdurai25@gmail.com"};
        emailIntent.putExtra(Intent.EXTRA_CC, cc);

        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            finish(); 
            Log.i("Finished sending email...", "");
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(MainActivity.this, "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }
    }
}
