package hcmute.edu.vn.calculator_29;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button num0, num1, num2, num3, num4, num5, num6, num7, num8, num9;
    private Button btn_add, btn_sub, btn_mul, btn_div, btn_dot, btn_clear, btn_equal;
    private TextView textView;

    private double operand1, operand2;
    private int operator = View.NO_ID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        textView.setText("");

        public void onClick

        num0 = findViewById(R.id.button_num0);
        num0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.append();
            }
        });

        num1 = findViewById(R.id.button_num1);
    }
}