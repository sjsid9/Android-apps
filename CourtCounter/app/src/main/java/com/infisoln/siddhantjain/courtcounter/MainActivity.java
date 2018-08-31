package com.infisoln.siddhantjain.courtcounter;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int Score_A=0;
    int Score_B=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public  void incTeamA3(View view){
        Score_A=Score_A+3;
        displayA(Score_A);
    }

    public  void incTeamA2(View view){
        Score_A=Score_A+2;
        displayA(Score_A);
    }

    public  void incTeamA1(View view){
        Score_A=Score_A+1;
        displayA(Score_A);
    }

    private void displayA(int number){
        TextView ScoreA=(TextView) findViewById(R.id.scoreOfA_text_view);
        ScoreA.setText(String.valueOf(number));
    }

    private void displayB(int number){
        TextView ScoreB=(TextView) findViewById(R.id.scoreOfB_text_view);
        ScoreB.setText(String.valueOf(number));
    }

    public  void incTeamB3(View view){
        Score_B=Score_B+3;
        displayB(Score_B);
    }

    public  void incTeamB2(View view){
        Score_B=Score_B+2;
        displayB(Score_B);
    }

    public  void incTeamB1(View view){
        Score_B=Score_B+1;
        displayB(Score_B);
    }

    public void reset(View view){
        TextView ScoreA=(TextView)findViewById(R.id.scoreOfA_text_view);
        TextView ScoreB=(TextView)findViewById(R.id.scoreOfB_text_view);
        ScoreA.setText(String.valueOf(0));
        ScoreB.setText(String.valueOf(0));
        Score_A=0;
        Score_B=0;
    }

}
