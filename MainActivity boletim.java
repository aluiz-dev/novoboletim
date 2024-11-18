package com.example.boletimdigital;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText edtNota1, edtNota2, edtNota3, edNota4;
    private Button btnCalcular;
    private TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtNota1 = findViewById(R.id.nota1);
        edtNota2 = findViewById(R.id.nota2);
        edtNota3 = findViewById(R.id.nota3);
		edtNota4 = findViewById(R.id.nota4);
        btnCalcular = findViewById(R.id.btnCalcular);
        tvResultado = findViewById(R.id.resultado);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularMedia();
            }
        });
    }

    private void calcularMedia() {
        try {
            // Pega as notas inseridas nos campos EditText
            double nota1 = Double.parseDouble(edtNota1.getText().toString());
            double nota2 = Double.parseDouble(edtNota2.getText().toString());
            double nota3 = Double.parseDouble(edtNota3.getText().toString());
			double nota4 = Double.parseDouble(edtNota4.getText().toString());

            // Calcula a média
            double media = (nota1 + nota2 + nota3 + nota 4) / 4;

            // Exibe o resultado
            tvResultado.setText("Média: " + String.format("%.2f", media));

            // Se a média for maior ou igual a 7.0, o aluno está aprovado
            if (media >= 7.0) {
                tvResultado.append("\nAprovado");
            } else {
                tvResultado.append("\nReprovado");
            }

        } catch (NumberFormatException e) {
            // Se algum campo estiver vazio ou inválido
            Toast.makeText(this, "Por favor, insira todas as notas corretamente.", Toast.LENGTH_SHORT).show();
        }
    }
}
