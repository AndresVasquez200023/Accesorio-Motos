package com.example.login;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity3 extends AppCompatActivity {

    Button btnAnt;
    EditText cant, cant2; // Agregamos el EditText cant2
    TextView textView3, total, envi, sub;

    Button fin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main3);

        btnAnt = findViewById(R.id.btnAnt);
        cant = findViewById(R.id.cant);
        cant2 = findViewById(R.id.cant2); // Asignamos el EditText cant2
        textView3 = findViewById(R.id.textView3);
        total = findViewById(R.id.total);
        envi = findViewById(R.id.envi);
        sub = findViewById(R.id.sub);
        fin = findViewById(R.id.fin);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnAnt.setOnClickListener(v -> {
            finish();
        });

        // Creamos un TextWatcher para cant y cant2
        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                if (!s.toString().isEmpty()) {
                    int cantidad = Integer.parseInt(s.toString());
                    int precioUnitario = Integer.parseInt(textView3.getText().toString().replaceAll("[^0-9]", ""));
                    int resultado = cantidad * precioUnitario;
                    int costoEnvio = Integer.parseInt(envi.getText().toString().replaceAll("[^0-9]", ""));
                    resultado += costoEnvio;
                    total.setText(String.valueOf(resultado));
                    sub.setText(String.valueOf(cantidad * precioUnitario));
                } else {
                    total.setText("0");
                    sub.setText("0");
                }
            }
        };
        fin.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity3.this, gracias.class);
            startActivity(intent);
        });

        // Asignamos el TextWatcher a los EditText cant y cant2
        cant.addTextChangedListener(textWatcher);
        cant2.addTextChangedListener(textWatcher);


    }
}
