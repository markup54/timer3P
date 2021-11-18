package pl.example.timer3p;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int sekundy=0;
    private TextView textView;
    private boolean zlicza = false;
    private Button startButton,stopButton, resetButton, zapiszButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textview);
        runTimer();
    }

    private void runTimer(){
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                if(zlicza) {
                    sekundy++;
                }
                textView.setText(Integer.toString(sekundy));
                handler.postDelayed(this,1000);
            }
        });
    }


}