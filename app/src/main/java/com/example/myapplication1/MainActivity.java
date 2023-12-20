package com.example.myapplication1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

        EditText P,R1,N;

    TextView TotalInterest,TotalAmount,TotalPayable;
        Button btnSubmit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initBinding();

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String amount = P.getText().toString();
                String interest = R1.getText().toString();
                String year = N.getText().toString();

                if (amount.isEmpty()) {
                    P.setError("Enter Your Amount");

                }
                else if (interest.isEmpty()) {
                    R1.setError("Enter Your Interest");
                }
                else if (year.isEmpty()) {
                    N.setError("Enter Your Year");
                }
                else {
                    int amount1 = Integer.parseInt(P.getText().toString());
                    int interest1 = Integer.parseInt(R1.getText().toString());
                    int year1 = Integer.parseInt(N.getText().toString());

                    int monthlyInterestRate = interest1/12*100;
                    System.out.println(interest1);
                    int numberOfPayments = year1 * 12;
                    int emi = (int) (amount1 * monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberOfPayments) / ( Math.pow(1 + monthlyInterestRate, numberOfPayments) - 1));
//                  TotalAmount.setText(emi);

                }

            }
        }
        );
    }

    private void initBinding(){
         P = findViewById(R.id.amount);
         R1 = findViewById(R.id.interest);
         N = findViewById(R.id.year);
         btnSubmit = findViewById(R.id.calculate);
         TotalAmount = findViewById(R.id.totalAmount);
         TotalInterest = findViewById(R.id.totalInterest);
         TotalPayable = findViewById(R.id.totalPayable);
    }
}