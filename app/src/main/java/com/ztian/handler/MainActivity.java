package com.ztian.handler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tv;
    private int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv=(TextView)findViewById(R.id.msg);
        new Thread(){
            public void run(){
                while (true){refreshMSG();}
            }
        }.start();
    }
    public void refreshMSG(){
     try {Thread.sleep(500);}catch(InterruptedException exception){}
     i++;
        Message msg=Message.obtain();
        msg.arg1=i;
        msg.arg2=i-10;
        mHandler.sendMessage(msg);
    }
    Handler mHandler=new Handler(){
        public void handleMessage(Message msg){
            super.handleMessage(msg);
            tv.setText(msg.arg1+msg.arg2+"");
        }
    };
}
