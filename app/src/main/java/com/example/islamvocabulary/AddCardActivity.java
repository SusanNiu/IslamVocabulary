package com.example.islamvocabulary;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class AddCardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_card);
        String s1 = getIntent().getStringExtra("question");
        String s2 = getIntent().getStringExtra("answer");

//        cancel button
        findViewById(R.id.cancelCard).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddCardActivity.this, MainActivity.class);
                AddCardActivity.this.startActivity(intent);
            }
        });


//        click save button to save new question and answer as user input

        findViewById(R.id.saveCard).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String somestring =((EditText)findViewById(R.id.newQuestion)).getText().toString();
                String anotherstring = ((EditText)findViewById(R.id.newAnswer)).getText().toString();
                Intent data = new Intent();
                data.putExtra("question", somestring);
                data.putExtra("answer", anotherstring);
                setResult(RESULT_OK, data);
                finish();
            }
        });

    }
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        // Added resultCode == RESULT_OK
//        if (requestCode == 100 && resultCode == RESULT_OK) {
//            String newS1 = getIntent().getStringExtra("question");
//            String  newS2 =  getIntent().getStringExtra("answer");
//            ((EditText) findViewById(R.id.newQuestion)).setText(newS1);
//            ((EditText) findViewById(R.id.newAnswer)).setText(newS2);
//
//
//        }
//    }

}
