package pk.ddm20240215s2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    private boolean click = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if (!click) {
                    ((TextView)findViewById(R.id.textView)).setText("Clicado");
                    click = true;
                }
                else {
                    ((TextView)findViewById(R.id.textView)).setText("Texto");
                    click = false;
                }

                int num = Integer.parseInt((String) ((TextView)findViewById(R.id.textView2)).getText());
                ((TextView)findViewById(R.id.textView2)).setText(Integer.toString(num + 1));
            }
        });


    }
}