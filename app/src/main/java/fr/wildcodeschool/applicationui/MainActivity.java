package fr.wildcodeschool.applicationui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonAccept = findViewById(R.id.button_accept);
        buttonAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editFirstname = findViewById(R.id.edit_firstname);
                EditText editLastname = findViewById(R.id.edit_lastname);
                String firstnameValue = editFirstname.getText().toString();
                String lastnameValue = editLastname.getText().toString();
                if (firstnameValue.isEmpty() || lastnameValue.isEmpty()) {
                    Toast.makeText(MainActivity.this, R.string.error_empty, Toast.LENGTH_SHORT).show();
                } else {
                    TextView textCongrats = findViewById(R.id.text_congrats);
                    textCongrats.setVisibility(View.VISIBLE);
                    textCongrats.setText(String.format(getString(R.string.text_congratulation), firstnameValue, lastnameValue));

                }
            }});

        CheckBox checkAccept = findViewById(R.id.check_box);
        checkAccept.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                EditText editFirstname = findViewById(R.id.edit_firstname);
                EditText editLastname = findViewById(R.id.edit_lastname);
                Button buttonAccept = findViewById(R.id.button_accept);


                editFirstname.setEnabled(isChecked);
                editLastname.setEnabled(isChecked);
                buttonAccept.setEnabled(isChecked);

            }
        });
    }
}
