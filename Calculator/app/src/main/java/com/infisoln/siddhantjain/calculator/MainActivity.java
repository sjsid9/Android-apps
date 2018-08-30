package com.infisoln.siddhantjain.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void seven(View view) {

        TextView textView = findViewById(R.id.textView);
        String s= (String) textView.getText();
        s=s+"7";
        textView.setText(s);
    }

    public void six(View view) {

        TextView textView = findViewById(R.id.textView);
        String s= (String) textView.getText();
        s=s+"6";
        textView.setText(s);
    }

    public void eight(View view) {

        TextView textView = findViewById(R.id.textView);
        String s= (String) textView.getText();
        s=s+"8";
        textView.setText(s);
    }

    public void five(View view) {

        TextView textView = findViewById(R.id.textView);
        String s= (String) textView.getText();
        s=s+"5";
        textView.setText(s);
    }

    public void four(View view) {

        TextView textView = findViewById(R.id.textView);
        String s= (String) textView.getText();
        s=s+"4";
        textView.setText(s);
    }

    public void three(View view) {

        TextView textView = findViewById(R.id.textView);
        String s= (String) textView.getText();
        s=s+"3";
        textView.setText(s);
    }

    public void two(View view) {

        TextView textView = findViewById(R.id.textView);
        String s= (String) textView.getText();
        s=s+"2";
        textView.setText(s);
    }

    public void one(View view) {

        TextView textView = findViewById(R.id.textView);
        String s= (String) textView.getText();
        s=s+"1";
        textView.setText(s);
    }

    public void nine(View view) {

        TextView textView = findViewById(R.id.textView);
        String s= (String) textView.getText();
        s=s+"9";
        textView.setText(s);
    }

    public void zero(View view) {

        TextView textView = findViewById(R.id.textView);
        String s= (String) textView.getText();
        s=s+"0";
        textView.setText(s);
    }

    public void pie(View view) {

        TextView textView = findViewById(R.id.textView);
        String s= (String) textView.getText();
        if(s.equals("")){
            s=s+"3.1415";
        }else {
            double n = Double.parseDouble(s);
            n=n*3.1415926535;
            n =Double.parseDouble(new DecimalFormat("##.##").format(n));
            s=Double.toString(n);
        }

        textView.setText(s);
    }

    public void ecalc(View view) {

        TextView textView = findViewById(R.id.textView);
        String s= (String) textView.getText();
        if(s.equals("")){
            s=s+"2.7182";
        }else {
            double n = Double.parseDouble(s);
            n=n*2.7182818284;
            n =Double.parseDouble(new DecimalFormat("##.##").format(n));
            s=Double.toString(n);
        }
        textView.setText(s);
    }

    public void clear(View view) {

        TextView textView = findViewById(R.id.textView);
        String s= (String) textView.getText();

        textView.setText("");

    }


    public void plus(View view) {

        TextView textView = findViewById(R.id.textView);
        String s= (String) textView.getText();
        if(s.equals("")||s.substring(s.length()-1).equals("+")||s.substring(s.length()-1).equals("-")||s.substring(s.length()-1).equals("x")||s.substring(s.length()-1).equals("/")){
            return;
        }
        s=s+"+";
        textView.setText(s);

    }

    public void minus(View view) {

        TextView textView = findViewById(R.id.textView);
        String s= (String) textView.getText();
        if(s.equals("")||s.substring(s.length()-1).equals("+")||s.substring(s.length()-1).equals("-")||s.substring(s.length()-1).equals("x")||s.substring(s.length()-1).equals("/")){
            return;
        }
        s=s+"-";
        textView.setText(s);

    }

    public void multiply(View view) {

        TextView textView = findViewById(R.id.textView);
        String s= (String) textView.getText();
        if(s.equals("")||s.substring(s.length()-1).equals("+")||s.substring(s.length()-1).equals("-")||s.substring(s.length()-1).equals("x")||s.substring(s.length()-1).equals("/")){
            return;
        }
        s=s+"x";
        textView.setText(s);

    }

    public void divide(View view) {

        TextView textView = findViewById(R.id.textView);
        String s= (String) textView.getText();
        if(s.equals("")||s.substring(s.length()-1).equals("+")||s.substring(s.length()-1).equals("-")||s.substring(s.length()-1).equals("x")||s.substring(s.length()-1).equals("/")){
            return;
        }
        s=s+"/";
        textView.setText(s);

    }

    public void factorial(View view) {

        TextView textView = findViewById(R.id.textView);
        String s= (String) textView.getText();

        if(s.equals("")||s.substring(s.length()-1).equals("+")||s.substring(s.length()-1).equals("-")||s.substring(s.length()-1).equals("x")||s.substring(s.length()-1).equals("/")){
            return;
        }
        boolean flag=false;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='.'){
             flag=true;
             break;
            }
        }

        if(flag){
            return;
        }

        long n=Long.parseLong(s);

        long fact=1;
        for(int i=1;i<=n;i++){
            fact=fact*i;
        }

        textView.setText(Long.toString(fact));


    }

    public void delete(View view) {

        TextView textView = findViewById(R.id.textView);
        String s=(String) textView.getText();
        if(s.equals("")){
            return;
        }
        s=s.substring(0,s.length()-1);
        textView.setText(s);

    }

    public void power(View view) {

        TextView textView = findViewById(R.id.textView);
        String s=(String) textView.getText();
        if(s.equals("")||s.substring(s.length()-1).equals("+")||s.substring(s.length()-1).equals("-")||s.substring(s.length()-1).equals("x")||s.substring(s.length()-1).equals("/")||s.substring(s.length()-1).equals("^")){
            return;
        }

        s=s+"^";

        textView.setText(s);


    }

    public void sqrt(View view) {

        TextView textView = findViewById(R.id.textView);
        String s= (String) textView.getText();
        if(s.equals("")){
            return;
        }else {
            double n = Double.parseDouble(s);
            n=Math.sqrt(n);
            n =Double.parseDouble(new DecimalFormat("##.###").format(n));
            s=Double.toString(n);
        }

        textView.setText(s);
    }

    public void equal(View view) {

        TextView textView = findViewById(R.id.textView);
        String s=(String) textView.getText();
        if(s.equals("")||s.substring(s.length()-1).equals("+")||s.substring(s.length()-1).equals("-")||s.substring(s.length()-1).equals("x")||s.substring(s.length()-1).equals("/")||s.substring(s.length()-1).equals("^")){
            return;
        }
        int reg[]=new int[5];
        boolean flag=false;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='^'){
                reg[0]=1;
                flag=true;
            }
            if(ch=='-' && i!=0){
                reg[1]=1;
                flag=true;
            }
            if(ch=='/'){
                reg[2]=1;
                flag=true;
            }
            if(ch=='x'){
                reg[3]=1;
                flag=true;
            }
            if(ch=='+'){
                reg[4]=1;
                flag=true;
            }
        }
        String ar[]=new String[2];

        if(flag==false){
            return;
        }

        if(reg[0]==1){ar=s.split("\\^");}
        else if(reg[1]==1){ar=s.split("-");}
        else if(reg[2]==1){ar=s.split("/");}
        else if(reg[3]==1){ar=s.split("x");}
        else if(reg[4]==1){ar=s.split("\\+");}

        double num[]=new double[ar.length];

        for(int i=0;i<ar.length;i++){
            num[i]=Double.parseDouble(ar[i]);
        }

        Double ans=1.0d;


        if(reg[0]==1){
            for(int i=1;i<=num[1];i++) {
                ans = ans * (int)num[0];
                ans=Double.parseDouble(new DecimalFormat("##.##").format(ans));
            }
        }else if(reg[1]==1){
            ans=(num[0]-num[1]);
            ans=Double.parseDouble(new DecimalFormat("##.##").format(ans));
        }else if(reg[2]==1){
            ans=num[0]/num[1];
            ans=Double.parseDouble(new DecimalFormat("##.##").format(ans));
        }else if(reg[3]==1){
            ans=num[0]*num[1];
            ans=Double.parseDouble(new DecimalFormat("##.##").format(ans));
        }else if(reg[4]==1){
            ans=num[0]+num[1];
            ans=Double.parseDouble(new DecimalFormat("##.##").format(ans));
        }

        s=Double.toString(ans);
        textView.setText(s);


    }

    public void decimal(View view) {

        TextView textView = findViewById(R.id.textView);
        String s=(String)textView.getText();

        if(!s.equals("")){
            if(s.substring(s.length()-1).equals(".")){
                return;
            }
            else{
                s=s+".";
            }
        }else{
            s=s+".";
        }

        textView.setText(s);

    }
}

