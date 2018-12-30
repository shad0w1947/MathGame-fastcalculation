package com.example.shad0w.quickcalculation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class final_activity extends AppCompatActivity {

    TextView maxquestionTV,scoreTV,unanswerTV;
    int maxquestion,score,unanswer;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_activity);
        i=getIntent();
        maxquestion=i.getIntExtra(Contact.maxquestion,0);
        score=i.getIntExtra(Contact.score,0);
        unanswer=i.getIntExtra(Contact.unanswer,0);

        maxquestionTV=findViewById(R.id.maxquestion);
        scoreTV=findViewById(R.id.correctanswer);
        unanswerTV=findViewById(R.id.unanswer);

        maxquestionTV.setText("Total Question "+maxquestion);
        scoreTV.setText("score  "+score);
        unanswerTV.setText("unanswer "+unanswer);

    }

    public void home(View view) {
    }
}
