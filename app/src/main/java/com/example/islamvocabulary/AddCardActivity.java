package com.example.islamvocabulary;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddCardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_card);


//      take the user back to question and answer editing
        String str1=getIntent().getStringExtra("question");
        String str2=getIntent().getStringExtra("answer");
        String str3=getIntent().getStringExtra("choice1");
        String str4=getIntent().getStringExtra("choice2");
        String str5=getIntent().getStringExtra("choice3");

        ((EditText) findViewById(R.id.newQuestion)).setText(str1);
        ((EditText) findViewById(R.id.newAnswer)).setText(str2);
        ((EditText) findViewById(R.id.newChoice1)).setText(str3);
        ((EditText) findViewById(R.id.newChoice2)).setText(str4);
        ((EditText) findViewById(R.id.newChoice3)).setText(str5);


//        cancel button
        findViewById(R.id.cancelCard).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(AddCardActivity.this, MainActivity.class);
                AddCardActivity.this.startActivity(intent);
            }
        });


//        click save button to save new question and answer as user input
        findViewById(R.id.saveCard).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str1=((EditText) findViewById(R.id.newQuestion)).getText().toString();
                String str2=((EditText) findViewById(R.id.newAnswer)).getText().toString();
                String str3=((EditText) findViewById(R.id.newChoice1)).getText().toString();
                String str4=((EditText) findViewById(R.id.newChoice2)).getText().toString();
                String str5=((EditText) findViewById(R.id.newChoice3)).getText().toString();
                if(str1.isEmpty() || str2.isEmpty() || str3.isEmpty() || str4.isEmpty() || str5.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "you can't leave blank in the text.", Toast.LENGTH_LONG).show();
                } else {
                    Intent data=new Intent();
                    data.putExtra("question", str1);
                    data.putExtra("answer", str2);
                    data.putExtra("choice1", str3);
                    data.putExtra("choice2", str4);
                    data.putExtra("choice3", str5);

                    setResult(RESULT_OK, data);
                    finish();
                }
            }
        });
    }
}
