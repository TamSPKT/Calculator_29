package hcmute.edu.vn.calculator_29;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private Button num0, num1, num2, num3, num4, num5, num6, num7, num8, num9;
    private Button btn_add, btn_sub, btn_mul, btn_div, btn_dot, btn_clear, btn_equal;
    private TextView textView;

    private Double operand1 = Double.NaN, operand2 = Double.NaN;
    private int operator = View.NO_ID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        textView.setText("");

        num0 = findViewById(R.id.button_num0);
        num0.setOnClickListener(this::onButtonClick);

        num1 = findViewById(R.id.button_num1);
        num1.setOnClickListener(this::onButtonClick);

        num2 = findViewById(R.id.button_num2);
        num2.setOnClickListener(this::onButtonClick);

        num3 = findViewById(R.id.button_num3);
        num3.setOnClickListener(this::onButtonClick);

        num4 = findViewById(R.id.button_num4);
        num4.setOnClickListener(this::onButtonClick);

        num5 = findViewById(R.id.button_num5);
        num5.setOnClickListener(this::onButtonClick);

        num6 = findViewById(R.id.button_num6);
        num6.setOnClickListener(this::onButtonClick);

        num7 = findViewById(R.id.button_num7);
        num7.setOnClickListener(this::onButtonClick);

        num8 = findViewById(R.id.button_num8);
        num8.setOnClickListener(this::onButtonClick);

        num9 = findViewById(R.id.button_num9);
        num9.setOnClickListener(this::onButtonClick);

        btn_add = findViewById(R.id.button_add);
        btn_add.setOnClickListener(this::onOperatorButtonClick);

        btn_sub = findViewById(R.id.button_sub);
        btn_sub.setOnClickListener(this::onOperatorButtonClick);

        btn_mul = findViewById(R.id.button_mul);
        btn_mul.setOnClickListener(this::onOperatorButtonClick);

        btn_div = findViewById(R.id.button_div);
        btn_div.setOnClickListener(this::onOperatorButtonClick);

        btn_dot = findViewById(R.id.button_dot);
        btn_dot.setOnClickListener(this::onButtonClick);

        btn_clear = findViewById(R.id.button_clear);
        btn_clear.setOnClickListener(this::onClearButtonClick);

        btn_equal = findViewById(R.id.button_equal);
        btn_equal.setOnClickListener(this::onEqualButtonClick);
    }

    public void onButtonClick(@NonNull View v) {
        int id = v.getId();
        if (id == R.id.button_num0) {
            textView.append("0");
        } else if (id == R.id.button_num1) {
            textView.append("1");
        } else if (id == R.id.button_num2) {
            textView.append("2");
        } else if (id == R.id.button_num3) {
            textView.append("3");
        } else if (id == R.id.button_num4) {
            textView.append("4");
        } else if (id == R.id.button_num5) {
            textView.append("5");
        } else if (id == R.id.button_num6) {
            textView.append("6");
        } else if (id == R.id.button_num7) {
            textView.append("7");
        } else if (id == R.id.button_num8) {
            textView.append("8");
        } else if (id == R.id.button_num9) {
            textView.append("9");
        } else if (id == R.id.button_dot) {
            String s = textView.getText().toString();
            if (s.isEmpty()) {
                textView.append("0.");
            } else if (!s.contains(".")) {
                textView.append(".");
            }
        }
    }

    public void onOperatorButtonClick(@NonNull View v) {
        btn_add.setBackgroundResource(R.drawable.operator_background);
        btn_sub.setBackgroundResource(R.drawable.operator_background);
        btn_mul.setBackgroundResource(R.drawable.operator_background);
        btn_div.setBackgroundResource(R.drawable.operator_background);

        int id = v.getId();
        if (id == R.id.button_add) {
            btn_add.setBackgroundResource(R.drawable.operator_background_pressed);
        } else if (id == R.id.button_sub) {
            btn_sub.setBackgroundResource(R.drawable.operator_background_pressed);
        } else if (id == R.id.button_mul) {
            btn_mul.setBackgroundResource(R.drawable.operator_background_pressed);
        } else if (id == R.id.button_div) {
            btn_div.setBackgroundResource(R.drawable.operator_background_pressed);
        }

        operator = id; // Set operator type (addition, subtraction, multiplication, division)
        if (operand1.isNaN()) { // First time click operator button
            operand1 = textView.getText().toString().isEmpty()
                    ? 0
                    : Double.parseDouble(textView.getText().toString());
        }
        // Click again after click equal button (Same or different operator type)
        else if (!operand2.isNaN()) {
            operand2 = textView.getText().toString().isEmpty()
                    ? operand1
                    : Double.parseDouble(textView.getText().toString());
        }
        textView.setText("");
    }

    public void onClearButtonClick(View v) {
        btn_add.setBackgroundResource(R.drawable.operator_background);
        btn_sub.setBackgroundResource(R.drawable.operator_background);
        btn_mul.setBackgroundResource(R.drawable.operator_background);
        btn_div.setBackgroundResource(R.drawable.operator_background);

        textView.setText("");
        operand1 = operand2 = Double.NaN;
        operator = View.NO_ID;
    }

    public void onEqualButtonClick(View v) {
        if (operand1.isNaN()) { // Click equal button without input first operand
            return;
        }
        if (operand2.isNaN()) { // Click equal button without input second operand
            operand2 = textView.getText().toString().isEmpty()
                    ? operand1
                    : Double.parseDouble(textView.getText().toString());
        }

        double result = Double.NaN;
        if (operator == R.id.button_add) {
            result = operand1 + operand2;
        } else if (operator == R.id.button_sub) {
            result = operand1 - operand2;
        } else if (operator == R.id.button_mul) {
            result = operand1 * operand2;
        } else if (operator == R.id.button_div) {
            result = operand1 / operand2;
        }
        operand1 = result; // Save result for next calculation

        DecimalFormat df = new DecimalFormat();
        df.setDecimalSeparatorAlwaysShown(false);
        textView.setText(df.format(result));
    }
}