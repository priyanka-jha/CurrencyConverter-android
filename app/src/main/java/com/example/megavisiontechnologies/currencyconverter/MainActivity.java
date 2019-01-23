package com.example.megavisiontechnologies.currencyconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText rupeesText;
    TextView resulttext;
    Button convertBtn;
    Spinner currencySpinner;

    double rupees;
    double result;
    String symbol;
    String[] currency = {"Select","USD","EUR","JPY","GBP","CHF"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rupeesText = findViewById(R.id.rupeetext);
        resulttext = findViewById(R.id.resulttext);
        convertBtn = findViewById(R.id.convertBtn);
        currencySpinner = findViewById(R.id.spinnerCurreny);

        ArrayAdapter currencyAdapter = new ArrayAdapter(this,R.layout.spinner_item,currency);

        currencyAdapter.setDropDownViewResource(R.layout.spinner_item);
        currencySpinner.setAdapter(currencyAdapter);


          convertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


              String rupees1 = rupeesText.getText().toString();
                String toCurrency = currencySpinner.getSelectedItem().toString();
                System.out.println("to..."+toCurrency);

                if (rupees1.length()==0){
                    Toast.makeText(getApplicationContext(),"Please enter amount",Toast.LENGTH_LONG).show();

                }
                else {
                    rupees=Double.parseDouble(rupees1);
                    if (toCurrency.equals("Select")) {
                        Toast.makeText(getApplicationContext(),"Please select the conversion unit",Toast.LENGTH_LONG).show();

                    }
                    else {

                        switch (toCurrency) {

                            case "USD":
                                result = 0.014*rupees;
                                symbol = "$";
                                break;

                            case "EUR":
                                result = 0.012*rupees;
                                symbol = "€";
                                break;

                            case "JPY":
                                result = 1.54*rupees;
                                symbol = "¥";
                                break;

                            case "GBP":
                                result = 0.011*rupees;
                                symbol = "£";
                                break;

                            case "CHF":
                                result = 0.014*rupees;
                                symbol = "₣";
                                break;

                            default:
                                Toast.makeText(getApplicationContext(),"Please select the conversion unit",Toast.LENGTH_SHORT).show();

                        }

                        resulttext.setText("Result: "+symbol+result);
                   }
                }


                }
        });



    }
}
