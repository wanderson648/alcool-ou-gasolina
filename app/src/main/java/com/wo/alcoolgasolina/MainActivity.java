package com.wo.alcoolgasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

   private TextInputEditText editPrecoAlcool, editPrecoGasolina;
   private TextView txtResultado;


   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);

      editPrecoAlcool = findViewById(R.id.preco_alcool);
      editPrecoGasolina = findViewById(R.id.preco_gasolina);
      txtResultado = findViewById(R.id.txt_resultado);

   }

   public void cacularPreco(View v) {
      String precoAlcool = editPrecoAlcool.getText().toString();
      String precoGasolina = editPrecoGasolina.getText().toString();

      Boolean camposValidados = validarCampos(precoAlcool, precoGasolina);

      if (camposValidados) {
         Double valorAlcool = Double.parseDouble(precoAlcool);
         Double valorGasolina = Double.parseDouble(precoGasolina);

         double resultado = valorAlcool / valorGasolina;
         if (resultado >= 0.7) {
            txtResultado.setText("Melhor utilizar Gasolina");
         } else {
            txtResultado.setText("Melhor utilizar Alcool");
         }
      } else {
         txtResultado.setText("Preencha os preços primeiro");
      }

   }

   private Boolean validarCampos(String pAlcool, String pGasolina) {
      boolean camposValidados = true;

      if (pAlcool == null || pAlcool.equals("")) {
         camposValidados = false;
      } else if (pGasolina == null || pGasolina.equals("")) {
         camposValidados = false;
      }
      return camposValidados;
   }
}