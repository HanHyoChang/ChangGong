package com.example.test978;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Adult_quiz extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adult_quiz);
        Button button = (Button) findViewById(R.id.adult_quiz_correct1);
        Button button1 = (Button) findViewById(R.id.adult_quiz_correct2);
        Button button2 = (Button) findViewById(R.id.adult_quiz_correct3);
        RadioGroup rg = (RadioGroup) findViewById(R.id.kid_rg1) ;
        Button button3 = (Button) findViewById(R.id.adult_quiz_dab);
        TextView textView = (TextView) findViewById(R.id.textView10);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(Adult_quiz.this, "어려운 문제입니다. 비료로 만들지 못할만한 것은 무엇일까요?",Toast.LENGTH_LONG);
                toast.show();
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(Adult_quiz.this, "쉽게 생각하면 됩니다.", Toast.LENGTH_LONG);
                toast.show();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(Adult_quiz.this, "이물질이 뭍어있으면 연소과정에서 유해물질이 나옵니다.", Toast.LENGTH_LONG);
                toast.show();
            }
        });
    }
}
