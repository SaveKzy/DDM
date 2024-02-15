package pk.ddm20240215s2_calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText nomeTxt;
    private EditText emailTxt;
    private EditText nota1Txt;
    private EditText nota2Txt;
    private TextView mediaTxt;
    private Button btnCalcula;
    private Button btnExibe;
    private Button btnSai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nomeTxt = (EditText) findViewById(R.id.nomeTxt);
        emailTxt = (EditText) findViewById(R.id.emailTxt);
        nota1Txt = (EditText) findViewById(R.id.nota1Txt);
        nota2Txt = (EditText) findViewById(R.id.nota2Txt);
        mediaTxt = (TextView) findViewById(R.id.mediaTxt);
        btnCalcula = (Button) findViewById(R.id.btnCalcula);
        btnExibe = (Button) findViewById(R.id.btnExibe);
        btnSai = (Button) findViewById(R.id.btnSai);

        btnCalcula.setOnClickListener(new EscutadorBotaoCalcula());
        btnExibe.setOnClickListener(new EscutadorBotaoExibe());
        btnSai.setOnClickListener(new EscutadorBotaoSai());

    }

    class EscutadorBotaoCalcula implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            double n1, n2, media;
            n1 = Double.parseDouble( nota1Txt.getText().toString() );
            n2 = Double.parseDouble( nota2Txt.getText().toString() );
            media = (n1 + n2)/2;
            mediaTxt.setText( Double.toString(media) );
        }
    }

    class EscutadorBotaoExibe implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            String msg = "";
            msg += nomeTxt.getText() + "\n";
            msg += emailTxt.getText() + "\n";
            msg += "Notas: " + nota1Txt.getText() + " e " + nota2Txt.getText();
            Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
        }
    }

    class EscutadorBotaoSai implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            System.exit(0);
        }
    }
}