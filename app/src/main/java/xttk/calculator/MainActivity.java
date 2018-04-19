package xttk.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText input_lend, input_rate, input_number;
    private TextView amount;
    private Button submit;
    private double lend, rate, number;
    private int amount_count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        find();

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lend = Double.valueOf(input_lend.getText().toString());
                rate = Double.valueOf(input_rate.getText().toString());
                rate /= 100;
                rate /= 12;
                number = Double.valueOf(input_number.getText().toString());
                amount_count = (int) (lend * Math.pow(rate + 1, number));
                amount.setText("本利和為：" + amount_count);
            }
        });
    }

    private void find() {
        input_lend = (EditText) findViewById(R.id.input_lend);
        input_rate = (EditText) findViewById(R.id.input_rate);
        input_number = (EditText) findViewById(R.id.input_number);
        amount = (TextView) findViewById(R.id.amount);
        submit = (Button) findViewById(R.id.submit);
    }
}
