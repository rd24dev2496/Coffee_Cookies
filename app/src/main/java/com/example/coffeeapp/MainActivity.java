package com.example.coffeeapp;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int quantity = 1;
    Button btn_1;
    String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_1=findViewById(R.id.btn_1);
        btn_1.setOnClickListener(view -> {
            String subject="Order Details";
            Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                    "mailto","email@email.com", null));
            intent.putExtra(Intent.EXTRA_SUBJECT, subject);
            intent.putExtra(Intent.EXTRA_TEXT, message);
            startActivity(Intent.createChooser(intent, "Choose an Email client :"));
        });
    }

    public void increment(View view) {
        if(quantity==10)
        {
            return;
        }
        quantity = quantity + 1;
        displayQuantity(quantity);
    }

    public void decrement(View view) {
        if(quantity==1)
        {
            return;
        }
        quantity = quantity - 1;
        displayQuantity(quantity);
    }


    public void submitOrder(View view) {
        // Figure out if the user wants whipped cream topping
        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();

        // Figure out if the user wants chocolate topping
        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.chocolate_checkbox);
        boolean hasChocolate = chocolateCheckBox.isChecked();

        // Calculate the price
        int price = calculatePrice();

        // Display the order summary on the screen
         message = createOrderSummary(price, hasWhippedCream, hasChocolate);
        displayMessage(message);
    }


    private int calculatePrice() {
        return quantity * 5;
    }


    private String createOrderSummary(int price, boolean addWhippedCream, boolean addChocolate) {
        String priceMessage = "Name: Rishabh Sharma";
        priceMessage += "\nAdd whipped cream? " + addWhippedCream;
        priceMessage += "\nAdd chocolate? " + addChocolate;
        priceMessage += "\nQuantity: " + quantity;
        priceMessage += "\nTotal: $" + price;
        priceMessage += "\nThank you!";
        return priceMessage;
    }

    @SuppressLint("SetTextI18n")
    private void displayQuantity(int numberOfCoffees) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText("" + numberOfCoffees);
    }

    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }

    public void activity(View view) {
        Intent intent = new Intent(this, CookieActivity.class);
        startActivity(intent);
    }

    public void showMap(Uri geoLocation) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(geoLocation);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}