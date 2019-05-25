package com.example.test978;

import android.app.Activity;
import android.os.Bundle;

public class Yungjongdong extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.yungjongdong);
    }

    public static class PaperRecycle   extends Activity {
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.paperrecycle);
        }
    }
}
