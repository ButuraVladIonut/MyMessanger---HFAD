package com.example.mymessanger;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //PAG 105
    public void onSendMessage(View view) {

        EditText messageView = (EditText) findViewById(R.id.message);//1
        String messageText = messageView.getText().toString();//1
//1        Intent intent = new Intent(this, ReceiveMessageActivity.class);
//1        intent.putExtra(EXTRA_MESSAGE, messageText);
        Intent intent = new Intent(Intent.ACTION_SEND);//2
        intent.setType("text/plain");//2
        intent.putExtra(Intent.EXTRA_TEXT, messageText);//2

        String chooserTitle = getString(R.string.chooser);//3
        Intent chosenIntent = Intent.createChooser(intent, chooserTitle);//3
        startActivity(chosenIntent);//3

//1        startActivity(intent);
    }
}