package pk.ddm20240229s4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.*;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private EditText gasto;
    private EditText valor;
    private Button add;
    private Button show;
    private Button total;

    private String msg;
    private double totalGasto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gasto = (EditText) findViewById(R.id.gastoInput);
        valor = (EditText) findViewById(R.id.valorInput);
        add = (Button) findViewById(R.id.addBtn);
        show = (Button) findViewById(R.id.showBtn);
        total = (Button) findViewById(R.id.totalBtn);

        msg = new String();

        add.setOnClickListener(new ListenerBtnAdd());
        show.setOnClickListener(new ListenerBtnShow());
        total.setOnClickListener(new ListenerBtnTotal());
    }

    class ListenerBtnAdd implements View.OnClickListener {
        @Override
        public void onClick(View v) {

            String gastoSt = gasto.getText().toString();
            String valorSt = valor.getText().toString();

            if (gastoSt.equals("")) {
                Toast.makeText(getApplicationContext(), "Digite um nome para o gasto.", Toast.LENGTH_LONG).show();
            } else if (valorSt.equals("")) {
                Toast.makeText(getApplicationContext(), "Digite um valor para o gasto.", Toast.LENGTH_LONG).show();
            } else if (!(Pattern.matches("\\d+\\.\\d+", valorSt) || Pattern.matches("\\d+", valorSt))) {
                Toast.makeText(getApplicationContext(), "Digite um valor válido para o gasto.", Toast.LENGTH_LONG).show();
            } else {

                if (!msg.equals("")) msg += "\n\n";

                msg += "Gasto: " + gasto.getText().toString() + "\nValor: " + Double.toString(Double.parseDouble(valor.getText().toString()));
                totalGasto += Double.parseDouble(valorSt);
                Toast.makeText(getApplicationContext(), "Gasto adicionado.", Toast.LENGTH_LONG).show();
            }
        }
    }

    class ListenerBtnShow implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
        }
    }

    class ListenerBtnTotal implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Toast.makeText(getApplicationContext(), "Total de gastos: " + Double.toString(totalGasto), Toast.LENGTH_LONG).show();
        }
    }

}