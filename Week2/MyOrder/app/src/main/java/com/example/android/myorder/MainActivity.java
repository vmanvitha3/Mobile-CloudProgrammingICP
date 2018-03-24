package com.example.android.myorder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

/**
 * This app displays an order form to order pizza.
 */

public class MainActivity extends AppCompatActivity {

    int quantity = 1;
    String priceMessage="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        EditText nameField = (EditText)findViewById(R.id.name_field);
        String name = nameField.getText().toString();
        CheckBox pepperoniCheckBox = (CheckBox) findViewById(R.id.add_pepperoni_checkbox);
        boolean hasPepperoni = pepperoniCheckBox.isChecked();
        CheckBox mushroomsCheckBox = (CheckBox) findViewById(R.id.add_mushrooms_checkbox);
        boolean hasMushrooms = mushroomsCheckBox.isChecked();
        CheckBox extracheeseCheckBox = (CheckBox) findViewById(R.id.add_extracheese_checkbox);
        boolean hasExtraCheese = extracheeseCheckBox.isChecked();
        CheckBox olivesCheckBox = (CheckBox) findViewById(R.id.add_olives_checkbox);
        boolean hasOlives = olivesCheckBox.isChecked();
        int price = calculatePrice(hasPepperoni,hasMushrooms,hasExtraCheese,hasOlives);
        priceMessage = createOrderSummary(name, price, hasPepperoni, hasMushrooms, hasExtraCheese, hasOlives);

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, "Pizza Order for "+name);
        intent.putExtra(Intent.EXTRA_TEXT, priceMessage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

    }

    /**
     * This method is called when the + button is clicked.
     */
    public void increment(View view) {
        if (quantity==10){
            Toast.makeText(this,"You cannot have more than 10 quantity",Toast.LENGTH_SHORT).show();
            return;
        }
        quantity=quantity+1;
        displayQuantity(quantity);
    }

    /**
     * This method is called when the - button is clicked.
     */
    public void decrement(View view) {
        if (quantity==1){
            Toast.makeText(this,"You cannot have less than 1 quantity",Toast.LENGTH_SHORT).show();
            return;
        }
        quantity=quantity-1;
        displayQuantity(quantity);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * Calculates the price of the order.
     *
     * @return total price
     * @param hasPepperoni
     * @param hasMushrooms
     * @param hasExtraCheese
     * @param hasOlives
     */
    private int calculatePrice(boolean hasPepperoni, boolean hasMushrooms, boolean hasExtraCheese, boolean hasOlives){

        int basePrice = 5;
        if(hasPepperoni){
            basePrice = basePrice + 1;
        }
        if(hasMushrooms){
            basePrice = basePrice + 2;
        }
        if(hasExtraCheese){
            basePrice = basePrice + 3;
        }
        if(hasOlives){
            basePrice = basePrice + 2;
        }

        return quantity * basePrice;

    }

    /**
     * Calculates summary of the order.
     *
     * @param price of the order
     * @return text summary
     * */
    private String createOrderSummary(String name,int price, boolean hasPepperoni, boolean hasMushrooms, boolean hasExtraCheese, boolean hasOlives){

        String priceMessage = "Name: " + name;
        priceMessage += "\nAdd Pepperoni? " +hasPepperoni;
        priceMessage += "\nAdd Mushrooms? " +hasMushrooms;
        priceMessage += "\nAdd Extra Cheese? " +hasExtraCheese;
        priceMessage += "\nAdd Olives? " +hasOlives;
        priceMessage += "\nQuantity: " +quantity;
        priceMessage += "\nTotal: $" +price;
        priceMessage += "\nThank You!";
        return priceMessage;

    }


    public void sendMessage(View view) {
        EditText nameField = (EditText)findViewById(R.id.name_field);
        String name = nameField.getText().toString();
        CheckBox pepperoniCheckBox = (CheckBox) findViewById(R.id.add_pepperoni_checkbox);
        boolean hasPepperoni = pepperoniCheckBox.isChecked();
        CheckBox mushroomsCheckBox = (CheckBox) findViewById(R.id.add_mushrooms_checkbox);
        boolean hasMushrooms = mushroomsCheckBox.isChecked();
        CheckBox extracheeseCheckBox = (CheckBox) findViewById(R.id.add_extracheese_checkbox);
        boolean hasExtraCheese = extracheeseCheckBox.isChecked();
        CheckBox olivesCheckBox = (CheckBox) findViewById(R.id.add_olives_checkbox);
        boolean hasOlives = olivesCheckBox.isChecked();
        int price = calculatePrice(hasPepperoni,hasMushrooms,hasExtraCheese,hasOlives);
        priceMessage = createOrderSummary(name, price, hasPepperoni, hasMushrooms, hasExtraCheese, hasOlives);

        Intent summary = new Intent(this, SummaryActivity.class);
        summary.putExtra("message", priceMessage);
        summary.putExtra("pepperoni",hasPepperoni);
        summary.putExtra("mushrooms",hasMushrooms);
        summary.putExtra("extracheese",hasExtraCheese);
        summary.putExtra("olives",hasOlives);
        startActivity(summary);
    }
}
