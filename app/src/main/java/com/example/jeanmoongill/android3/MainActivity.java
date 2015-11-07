package com.example.jeanmoongill.android3;

import android.app.Service;
import android.os.Vibrator;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.content.Context;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_hasVibrator;
    private Button btn_short;
    private Button btn_long;
    private Button btn_rhythm;
    private Button btn_cancel;
    private Vibrator myVibrator;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //get the instance of the Vibrator
        myVibrator = (Vibrator)getSystemService(Service.VIBRATOR_SERVICE);
        mContext = MainActivity.this;
        bindView();
    }

    private void bindView() {
        btn_hasVibrator = (Button)findViewById(R.id.btn_hasVibrator);
        btn_short = (Button)findViewById(R.id.btn_short);
        btn_long = (Button)findViewById(R.id.btn_long);
        btn_rhythm = (Button)findViewById(R.id.btn_rhythm);
        btn_cancel = (Button)findViewById(R.id.btn_cancel);

        btn_hasVibrator.setOnClickListener(this);
        btn_short.setOnClickListener(this);
        btn_long.setOnClickListener(this);
        btn_rhythm.setOnClickListener(this);
        btn_cancel.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_hasVibrator:
                Toast.makeText(mContext, myVibrator.hasVibrator() ? "진동 있" :"진동 없음", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_short:
                myVibrator.cancel();
                myVibrator.vibrate(new long[]{100, 200, 100, 200}, 0);
                Toast.makeText(mContext, "단 진동", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_long:
                myVibrator.cancel();
                myVibrator.vibrate(new long[]{100, 100, 100, 1000}, 0);
                Toast.makeText(mContext, "장진동", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_rhythm:
                myVibrator.cancel();
                myVibrator.vibrate(new long[]{500, 100, 500, 100, 500, 100}, 0);
                Toast.makeText(mContext, "음악 진동", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_cancel:
                myVibrator.cancel();
                Toast.makeText(mContext, "진동 취소", Toast.LENGTH_SHORT).show();
        }
    }
}
