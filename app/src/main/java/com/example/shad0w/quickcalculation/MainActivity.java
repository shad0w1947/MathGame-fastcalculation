package com.example.shad0w.quickcalculation;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    int score=0;
    int unanswer=0;
    int questionasked=1;
    int maxquestion=20;
    TextView first,operator,second,timeview;
    Button A,B,C,D;
    int ans=0;
    String t;
    DecimalFormat df;
    CountDownTimer mCountDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timeview=findViewById(R.id.time);
        A=findViewById(R.id.A);
        A.setOnClickListener(this);
        B=findViewById(R.id.B);
        B.setOnClickListener(this);
        C=findViewById(R.id.C);
        C.setOnClickListener(this);
        D=findViewById(R.id.D);
        D.setOnClickListener(this);
        first=findViewById(R.id.first);
        second=findViewById(R.id.second);
        operator=findViewById(R.id.operator);
        df=new DecimalFormat("###.##");
        starTimer();
        fillValue();

    }

    private void fillValue() {
        if(questionasked>maxquestion)
            showscore();
        questionasked++;
        int a=(int)(Math.random() * 50 + 1);
        int b=(int)(Math.random() * 50 + 1);
        int op=(int)(Math.random() * 4 + 1);
        int buttonoption=(int)(Math.random() * 4 + 1);
        char operatorcharter='+';
        switch (op){
            case 1:ans=a+b;
                   operatorcharter='+';
                   break;
            case 2:ans=a-b;
                operatorcharter='-';
                break;
            case 3:ans=a*b;
                operatorcharter='X';
                break;
            case 4:ans=(a)/b;
                operatorcharter='/';
                break;
                default:
                    Toast.makeText(this,op+"",Toast.LENGTH_SHORT).show();
        }
        Toast.makeText(this,a+" "+operatorcharter+" "+b+" "+ans+" "+buttonoption,Toast.LENGTH_LONG).show();
        operator.setText(operatorcharter+"");
        first.setText(a+"");
        second.setText(b+"");
       t=df.format(ans);
        int temp=0;
        switch (buttonoption){
            case 1:A.setText(t);
                break;
            case 2:B.setText(t);
                break;
            case 3:C.setText(t);
                break;
            case 4:D.setText(t);
                break;
            default:
                Toast.makeText(this,buttonoption+" butt",Toast.LENGTH_SHORT).show();
        }
    for(int i=1;i<=4;i++)
    {
        if(i==buttonoption)
            continue;
        temp= (int)(Math.random()*ans+1);
        if(temp==ans);
        temp+=5;
        String temp1=df.format(temp);
        if(i==1)
            A.setText(temp1+"");
        else if(i==2)
            B.setText(temp1+"");
        else if(i==3)
            C.setText(temp1+"");
        else if(i==4)
            D.setText(temp1+"");
    }
        mCountDownTimer.start();
    }

    private void showscore() {
        Intent i=new Intent(this,final_activity.class);
        i.putExtra(Contact.maxquestion,maxquestion);
        i.putExtra(Contact.score,score);
        i.putExtra(Contact.unanswer,unanswer);
        finish();
        startActivity(i);
    }

    @Override
    public void onClick(View v) {
        Button b=(Button)v;
        String clickbuttonvalue= (String) b.getText();
        if(clickbuttonvalue.equals(t))
            score++;
        Toast.makeText(this,score+"  "+clickbuttonvalue   ,Toast.LENGTH_LONG).show();
        mCountDownTimer.cancel();
        fillValue();
    }


    public void starTimer() {
      mCountDownTimer=  new CountDownTimer(10000, 1000) {

            public void onTick(long millisUntilFinished) {
                timeview.setText("seconds remaining: " + millisUntilFinished / 1000);
            }

            public void onFinish() {
                unanswer++;
                fillValue();
            }

        };
    }
}
