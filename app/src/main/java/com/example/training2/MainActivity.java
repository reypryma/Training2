package com.example.training2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


//implements View.OnClickListener
public class MainActivity extends AppCompatActivity {

    public static final String KEY_MESSAGE = "MESSAGE";
    public static final String LOG_TAG = "myLogs";
    public static int REQUEST_CODE = 696;
    private TextView textViewReply;
    private EditText editTextMessage;
    private Button buttonSendReply;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Reply Activity Satu");
        textViewReply = findViewById(R.id.textViewReply);
        editTextMessage = findViewById(R.id.createReply);
        buttonSendReply = findViewById(R.id.buttonSendReply);

        buttonSendReply.setOnClickListener(//this
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent secondIntent = new Intent(MainActivity.this, MainActivity2.class);
                        //menyisipkan
                        secondIntent.putExtra(KEY_MESSAGE, editTextMessage.getText().toString());
                        startActivityForResult(secondIntent, REQUEST_CODE);
                    }
                }
        );


        Log.d(LOG_TAG, "-------");
        Log.d(LOG_TAG, "onCreate");
    }

    @Override
    public void onStart(){
        super.onStart();
        Log.d(LOG_TAG, "onStart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LOG_TAG, "onPause");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(LOG_TAG, "onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LOG_TAG, "onResume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(LOG_TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG, "onDestroy");
    }
/*
    public void buttonSendMessageClick(View view) {

    }
*/

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK){
            String message = data.getStringExtra(MainActivity.KEY_MESSAGE);
            textViewReply.setText(message);
        }
    }

    //auto menjadi listener
/*    @Override
    public void onClick(View v) {

    }*/
}