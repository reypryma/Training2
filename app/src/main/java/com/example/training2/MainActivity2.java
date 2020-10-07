package com.example.training2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    private TextView textViewMessage;
    private EditText editTextReply;
    private Button buttonMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        setTitle("Message Activity Dua");
        textViewMessage = findViewById(R.id.textViewMessage);
        editTextReply = findViewById(R.id.editMessage2);
        buttonMessage = findViewById(R.id.buttonSendMessage);

       String message = getIntent().getStringExtra(MainActivity.KEY_MESSAGE);
       textViewMessage.setText(message);

       buttonMessage.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent();
               intent.putExtra(MainActivity.KEY_MESSAGE, editTextReply.getText().toString());
               setResult(MainActivity.RESULT_OK, intent);
               finish();
           }
       });
    }
}