package pk.ddm20240321s7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView imgPedra;
    private ImageView imgPapel;
    private ImageView imgTesoura;
    private ImageView imgApp;
    private TextView lblResultado;
    private int pointsPlayer = 0, pointsApp = 0;
    private TextView lblPontos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgPedra = findViewById( R.id.imgPedra );
        imgPapel = findViewById( R.id.imgPapel );
        imgTesoura = findViewById( R.id.imgTesoura );
        imgApp = findViewById( R.id.imgApp );
        lblResultado = findViewById( R.id.lblResultado );

        lblPontos = findViewById( R.id.txtPoints);

        EscutadorClickImagem eci = new EscutadorClickImagem();
        imgPedra.setOnClickListener( eci );
        imgPapel.setOnClickListener( eci );
        imgTesoura.setOnClickListener( eci );

    }

    private class EscutadorClickImagem implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            int escolhaUsuario = 0;
            ImageView img = (ImageView) view;

            if (img.getId() == R.id.imgPedra) {
                escolhaUsuario = 1;
            } else if (img.getId() == R.id.imgPapel) {
                escolhaUsuario = 2;
            } else {
                escolhaUsuario = 3;
            }

            int escolhaApp = new Random().nextInt(3) + 1;
            switch (escolhaApp) {
                case 1:
                    imgApp.setImageResource(R.drawable.pedra);
                    break;
                case 2:
                    imgApp.setImageResource(R.drawable.papel);
                    break;
                case 3:
                    imgApp.setImageResource(R.drawable.tesoura);
                    break;
            }

            if ( ( escolhaApp == 1 && escolhaUsuario == 3 ) || ( escolhaApp == 2 && escolhaUsuario == 1 ) || ( escolhaApp == 3 && escolhaUsuario == 2 ) )
            {
                lblResultado.setText("O app ganhou!!!!");
                pointsApp++;
            }
            else
            {
                if ( (escolhaApp == 3 && escolhaUsuario == 1) ||
                        (escolhaApp == 1 && escolhaUsuario == 2) ||
                        (escolhaApp == 2 && escolhaUsuario == 3) )
                {
                    lblResultado.setText("Você ganhou!!");
                    pointsPlayer++;
                }
                else
                {
                    lblResultado.setText("Deu empate!");
                }
            }

            lblPontos.setText("       Pontos\nJogador / App: \n           " + pointsPlayer + " / " + pointsApp);

        }
    }
}