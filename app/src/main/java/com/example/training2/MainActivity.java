package com.example.training2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

//implements View.OnClickListener
public class MainActivity extends AppCompatActivity {

    public static final String KEY_MESSAGE = "MESSAGE";
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
    }

    public void buttonSendMessageClick(View view) {

    }

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