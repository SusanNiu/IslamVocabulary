package com.example.islamvocabulary;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


//    onCreate Method
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//toggle between question and answer
        findViewById(R.id.flashcard_question).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.flashcard_answer).setVisibility(View.VISIBLE);
                findViewById(R.id.flashcard_question).setVisibility(View.INVISIBLE);
            }
        });

        findViewById(R.id.flashcard_answer).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.flashcard_question).setVisibility(View.VISIBLE);
                findViewById(R.id.flashcard_answer).setVisibility(View.INVISIBLE);
            }
        });


//choice toggle colors
        findViewById(R.id.choice1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.choice1).setBackgroundColor(getResources().getColor(R.color.my_red_color, null));
            }
        });
        findViewById(R.id.choice2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.choice2).setBackgroundColor(getResources().getColor(R.color.my_answer_color, null));
            }
        });
        findViewById(R.id.choice3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.choice3).setBackgroundColor(getResources().getColor(R.color.my_red_color, null));
            }
        });


// toggle with the eye button between see choices and unsee choices
        findViewById(R.id.see_choices).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((ImageView) findViewById(R.id.see_choices)).setImageResource(R.drawable.ic_eye1);
                findViewById(R.id.choice1).setVisibility(View.INVISIBLE);
                findViewById(R.id.choice2).setVisibility(View.INVISIBLE);
                findViewById(R.id.choice3).setVisibility(View.INVISIBLE);
                findViewById(R.id.unsee_choices).setVisibility(View.VISIBLE);
            }
        });
        findViewById(R.id.unsee_choices).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((ImageView) findViewById(R.id.unsee_choices)).setImageResource(R.drawable.ic_eye2);
                findViewById(R.id.choice1).setVisibility(View.VISIBLE);
                findViewById(R.id.choice2).setVisibility(View.VISIBLE);
                findViewById(R.id.choice3).setVisibility(View.VISIBLE);
                findViewById(R.id.unsee_choices).setVisibility(View.INVISIBLE);
                findViewById(R.id.see_choices).setVisibility(View.VISIBLE);
            }
        });


//click on add button to navigate to add card activity which is to input new questions
        findViewById(R.id.addNew).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddCardActivity.class);
                MainActivity.this.startActivityForResult(intent, 100);
            }
        });


//click edit button and return the users back to the question and answer they want to edit
        findViewById(R.id.editText).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String somestring =((TextView)findViewById(R.id.flashcard_question)).getText().toString();
                String anotherstring = ((TextView)findViewById(R.id.flashcard_answer)).getText().toString();
                Intent intent = new Intent(MainActivity.this, AddCardActivity.class);
                intent.putExtra("question",somestring);
                intent.putExtra("answer",anotherstring);
                MainActivity.this.startActivityForResult(intent, 100);
            }
        });


    }


//    onActivityResult Method to grab new input and display on the question and answer places
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // Added resultCode == RESULT_OK
        if (requestCode == 100 && resultCode == RESULT_OK) {
            String newS1 = data.getExtras().getString("question");
            String newS2 = data.getExtras().getString("answer");
            ((TextView) findViewById(R.id.flashcard_question)).setText(newS1);
            ((TextView) findViewById(R.id.flashcard_answer)).setText(newS2);
            findViewById(R.id.choice1).setVisibility(View.INVISIBLE);
            findViewById(R.id.choice2).setVisibility(View.INVISIBLE);
            findViewById(R.id.choice3).setVisibility(View.INVISIBLE);
        }
    }

}
