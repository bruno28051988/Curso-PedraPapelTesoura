package com.br.cursopedrapapeltesoura;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selecionarPedra(View view){
        this.opcaoSelecionada("pedra");
    }

    public void selecionarPapel(View view){
        this.opcaoSelecionada("papel");
    }

    public void selecionarTesoura(View view){
        this.opcaoSelecionada("tesoura");
    }


    public void opcaoSelecionada(String opcaoUsuario){

        ImageView imgResultado = findViewById(R.id.img_resultado);
        TextView txtResultado = findViewById(R.id.textResultado);


        int numero = new Random().nextInt(3);
         String[] opcoes = {"pedra", "papel", "tesoura"};
         String opcaoApp = opcoes [numero];


         switch (opcaoApp){
             case "pedra":
                 imgResultado.setImageResource(R.drawable.pedra);
                 break;
             case "papel":
                 imgResultado.setImageResource(R.drawable.papel);
                 break;
             case "tesoura":
                 imgResultado.setImageResource(R.drawable.tesoura);
                 break;
         }

         if ((opcaoApp == "tesoura" && opcaoUsuario == "papel") ||
                 (opcaoApp == "papel" && opcaoUsuario == "pedra") ||
                    (opcaoApp == "pedra" && opcaoUsuario == "tesoura") ){//App ganhador

             txtResultado.setText("Você PERDEU!!  :(");

         }else if((opcaoUsuario == "tesoura" && opcaoApp == "papel") ||
                    (opcaoUsuario == "papel" && opcaoApp == "pedra") ||
                        (opcaoUsuario == "pedra" && opcaoApp == "tesoura") ){//Usuário ganhador

             txtResultado.setText("Você GANHOU!!  :)");
         }else{//Empate

             txtResultado.setText("EMPATE!!  ;)");
         }

    }
}