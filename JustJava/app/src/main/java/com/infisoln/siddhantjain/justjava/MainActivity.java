package com.infisoln.siddhantjain.justjava;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    int quantity=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitOrder(View view) {
        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.whipped_check_box);
        boolean hasWhippedCream=whippedCreamCheckBox.isChecked();
        CheckBox chocolateCheckBox=(CheckBox) findViewById(R.id.chocolate_check_box);
        boolean hasChocolate=chocolateCheckBox.isChecked();
//        Log.v("MainActivity","HasWhippedCream "+hasWhippedCream);
        EditText editText=(EditText) findViewById(R.id.name_edit_text);
        Editable name=editText.getText();

            Context context = getApplicationContext();
            CharSequence text = "Order Submitted Succesfully";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
            int basePrice=0;
            if(hasChocolate && hasWhippedCream) {
                 basePrice = quantity*5+quantity+quantity*2;
            }else if(hasChocolate){
                basePrice = quantity*5+quantity*2;
            }else if(hasWhippedCream){
                basePrice = quantity*5+quantity;
            }
        String priceMessage="Name: "+name+ "\n"+"Quantity: "+quantity+"\n"+"Has Whipped Cream : "+hasWhippedCream+"\nHas Chocolate : "+hasChocolate+"\nTotal: "+basePrice+"\n"+"Thank You!";
        displayPrice(priceMessage);
    }

    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    private void displayPrice(String message){
        TextView priceTextView=(TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(message);
    }

    public void increment(View view){
        quantity=quantity+1;
        display(quantity);
    }

    public void decrement(View view){
        if(quantity>0)
            quantity=quantity-1;
        display(quantity);
    }

//    public void onCheckboxClicked(View view){
//        boolean checked=((CheckBox)view).isChecked();
//        if(checked){
//            displayPrice("Topping : Whipped Cream");
//        }else{
//
//        }
//    }

}
