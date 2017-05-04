package fr.projet.lokacar.ui.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

import fr.projet.lokacar.ui.vehicule.AddVehiculeActivity;
import fr.projet.lokacar.R;
import fr.projet.lokacar.ui.home.HomeActivity;

public class MainActivity extends AppCompatActivity {

    private Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {

                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(intent);

            }
        }, 2000);

    }
}
