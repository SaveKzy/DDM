// Alunos: Benjamim Silva Manoel, Matheus Cristhian Papareli Barbosa e Pedro dos Santos Kemp

package pk.ddm20240307s5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button btn1;
    private Button btn2;
    private Button btn3;
    private TextView Txt_Resposta;
    private TextView Txt_Resultado;
    private TextView Txt_Pontos;

    private Integer numero;
    private Random gerador = new Random();
    private int Acertos = 0;
    private int Total = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (Button) findViewById(R.id.Btn1);
        btn2 = (Button) findViewById(R.id.Btn2);
        btn3 = (Button) findViewById(R.id.Btn3);
        Txt_Resposta = (TextView) findViewById(R.id.Txt_Resposta);
        Txt_Resultado = (TextView) findViewById(R.id.Txt_Resultado);
        Txt_Pontos = (TextView) findViewById(R.id.Txt_Pontos);

        btn1.setOnClickListener(new EscutadorBotoes(1));
        btn2.setOnClickListener(new EscutadorBotoes(2));
        btn3.setOnClickListener(new EscutadorBotoes(3));

    }

    class EscutadorBotoes implements View.OnClickListener {

        private int click;
        public EscutadorBotoes(int click) {
            this.click = click;
        }

        @Override
        public void onClick(View v) {

            numero = gerador.nextInt(3) + 1;
            Total += 1;

            Txt_Resposta.setText("Pensei: " + numero.toString());

            if (numero == click) {
                Acertos += 1;
                Txt_Resultado.setText("Acertou!");
                Toast.makeText(getApplicationContext(), "Acertou!", Toast.LENGTH_LONG).show();
            } else {
                Txt_Resultado.setText("Errou!");
                Toast.makeText(getApplicationContext(), "Errou!", Toast.LENGTH_LONG).show();
            }

            Txt_Pontos.setText("Acertos / Total: " + String.valueOf(Acertos) + " / " + String.valueOf(Total));

        }
    }
}