package sg.edu.rp.c346.id22038283.democheckboxexample;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CheckBox cbEnabled;
    Button btnCheck;
    TextView tvShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cbEnabled = findViewById(R.id.cbEnabled);
        btnCheck = findViewById(R.id.btnCheck);
        tvShow = findViewById(R.id.tvShow);

        calculatePay();

        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculatePay();
            }
        });
    }

    private void calculatePay() {
        if (cbEnabled.isChecked()) {
            double pay = calcPay(100, 20);
            tvShow.setText("The discount is given. You need to pay " + pay);
        } else {
            double pay = calcPay(100, 0);
            tvShow.setText("The discount is not given. You need to pay " + pay);
        }

        Log.i("MainActivity", "Pay calculated successfully");
    }

    private double calcPay(double price, double discount) {
        double pay = price;
        if (discount > 0) {
            double discAmount = (discount / 100) * price;
            pay = price - discAmount;
        }
        return pay;
    }
}
