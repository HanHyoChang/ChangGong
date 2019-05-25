package com.example.test978;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Kid_quiz extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kid_quiz);

        Button button = (Button) findViewById(R.id.kid_quiz_correct1);
        Button button1 = (Button) findViewById(R.id.kid_quiz_correct2);
        Button button2 = (Button) findViewById(R.id.kid_quiz_correct3);
        RadioGroup rg = (RadioGroup) findViewById(R.id.kid_rg1) ;
        Button button3 = (Button) findViewById(R.id.kid_quiz_dab);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(Kid_quiz.this, " 휴지에는 뭐가 많이 묻죠?ㅎㅎ",Toast.LENGTH_LONG);
                toast.show();
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(Kid_quiz.this, "음식물쓰레기는 가축의 비료로 재활용됩니다.", Toast.LENGTH_LONG);
                toast.show();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(Kid_quiz.this, "공병은 깨끗한 상태로 재활용해야 합니다.", Toast.LENGTH_LONG);
                toast.show();
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(Kid_quiz.this, "1.아냐 2.안 된다 3.안 된다", Toast.LENGTH_LONG);
                toast.show();
            }
        });
    }




}
