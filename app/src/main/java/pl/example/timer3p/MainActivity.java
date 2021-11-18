package pl.example.timer3p;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int sekundy=0;
    private String tekst;
    private TextView textView, zapisTextView;
    private boolean zlicza = false;
    private Button startButton,stopButton, resetButton, zapiszButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textview);
        zapisTextView = (TextView) findViewById(R.id.textview2);
        runTimer();
        startButton = (Button) findViewById(R.id.button);
        stopButton = (Button) findViewById(R.id.button2);
        resetButton = (Button) findViewById(R.id.button3);
        zapiszButton = (Button) findViewById(R.id.button4);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                zlicza =true;
            }
        });
        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                zlicza = false;
            }
        });
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sekundy=0;
            }
        });
        zapiszButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String zapisane = zapisTextView.getText().toString();
                zapisane = zapisane +"\n"+tekst;
                zapisTextView.setText(zapisane);
            }
        });
    }



    private void runTimer(){
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                if(zlicza) {
                    sekundy++;
                }
                int s = sekundy%60;
                int m = (sekundy/60)%60;
                int h = sekundy/3600;
                tekst = String.format("%d:%02d:%02d",h,m,s);
                textView.setText(tekst);
                handler.postDelayed(this,1000);
            }
        });
    }


}