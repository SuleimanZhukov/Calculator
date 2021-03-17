package com.suleiman.calculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String KEY = "saveState";

    private float mFirst;
    private float mSecond;
    private String mOperator;
    private TextView tvResultField;
    private TextView tvTextField;
    private boolean plus;
    private boolean minus;
    private boolean multi;
    private boolean divide;

    private Button button0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }


    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedState) {
        super.onRestoreInstanceState(savedState);
        if (savedState != null) {
            tvTextField.setText(savedState.getString(KEY));
            tvResultField.setText(savedState.getString(KEY));
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle state) {
        super.onSaveInstanceState(state);
        if (state != null) {
            state.putString(KEY, tvTextField.getText().toString());
            state.putString(KEY, tvResultField.getText().toString());
        }
    }

    private View.OnClickListener clickListener = (view) -> {
        switch (view.getId()) {
            case R.id.button0: {
                button0.setTextColor(Color.green(1));
                tvTextField.append("0");
                break;
            }
            case R.id.button1: {
                tvTextField.append("1");
                break;
            }
            case R.id.button2: {
                tvTextField.append("2");
                break;
            }
            case R.id.button3: {
                tvTextField.append("3");
                break;
            }
            case R.id.button4: {
                tvTextField.append("4");
                break;
            }
            case R.id.button5: {
                tvTextField.append("5");
                break;
            }
            case R.id.button6: {
                tvTextField.append("6");
                break;
            }
            case R.id.button7: {
                tvTextField.append("7");
                break;
            }
            case R.id.button8: {
                tvTextField.append("8");
                break;
            }
            case R.id.button9: {
                tvTextField.append("9");
                break;
            }
            case R.id.buttonDot: {
                tvTextField.append(".");
                break;
            }
            case R.id.buttonPlus: {
                mathDuty(" + ");
                break;
            }
            case R.id.buttonMinus: {
                mathDuty(" - ");
                break;
            }
            case R.id.buttonMultiply: {
                mathDuty(" ✕ ");
                break;
            }
            case R.id.buttonDivide: {
                mathDuty(" ÷ ");
                break;
            }
            case R.id.buttonEquals: {
                calculate();
                break;
            }
            case R.id.clear: {
                tvResultField.setText(null);
                tvTextField.setText(null);
                break;
            }
        }
    };

    private void calculate() {
        tvResultField.append(tvTextField.getText().toString());
        mSecond = Float.parseFloat(tvTextField.getText().toString());
        if (plus) {
            tvResultField.append(" = " + (mFirst + mSecond));
            plus = false;
        } else if (minus) {
            tvResultField.append(" = " + (mFirst - mSecond));
            minus = false;
        } else if (multi) {
            tvResultField.append(" = " + (mFirst * mSecond));
            multi = false;
        } else if (divide) {
            tvResultField.append(" = " + (mFirst / mSecond));
            divide = false;
        }
        clearScreen();
    }

    private void mathDuty(String symbol) {
        tvResultField.append(tvTextField.getText().toString());
        mFirst = Float.parseFloat(tvTextField.getText().toString());
        if (symbol.contains("+")) {
            plus = true;
        } else if (symbol.contains("-")) {
            minus = true;
        } else if (symbol.contains("✕")) {
            multi = true;
        } else if (symbol.contains("÷")) {
            divide = true;
        }
        tvResultField.append(symbol);
        clearScreen();
    }

    private void clearScreen() {
        tvTextField.setText("");
    }

    private void init() {
        tvResultField = findViewById(R.id.result_field);
        tvTextField = findViewById(R.id.text_field);
        button0 = findViewById(R.id.button0);
        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);
        Button button5 = findViewById(R.id.button5);
        Button button6 = findViewById(R.id.button6);
        Button button7 = findViewById(R.id.button7);
        Button button8 = findViewById(R.id.button8);
        Button button9 = findViewById(R.id.button9);
        Button buttonDot = findViewById(R.id.buttonDot);
        Button buttonPlus = findViewById(R.id.buttonPlus);
        Button buttonMinus = findViewById(R.id.buttonMinus);
        Button buttonMultiply = findViewById(R.id.buttonMultiply);
        Button buttonDivide = findViewById(R.id.buttonDivide);
        Button buttonEquals = findViewById(R.id.buttonEquals);
        Button buttonClear = findViewById(R.id.clear);

        button0.setOnClickListener(clickListener);
        button1.setOnClickListener(clickListener);
        button2.setOnClickListener(clickListener);
        button3.setOnClickListener(clickListener);
        button4.setOnClickListener(clickListener);
        button5.setOnClickListener(clickListener);
        button6.setOnClickListener(clickListener);
        button7.setOnClickListener(clickListener);
        button8.setOnClickListener(clickListener);
        button9.setOnClickListener(clickListener);
        buttonDot.setOnClickListener(clickListener);
        buttonPlus.setOnClickListener(clickListener);
        buttonMinus.setOnClickListener(clickListener);
        buttonMultiply.setOnClickListener(clickListener);
        buttonDivide.setOnClickListener(clickListener);
        buttonEquals.setOnClickListener(clickListener);
        buttonClear.setOnClickListener(clickListener);
    }
}