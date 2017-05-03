package fr.projet.lokacar;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import fr.projet.lokacar.models.Client;

/**
 * Created by agirardeau2015 on 03/05/2017.
 */

public class AddClientActivity extends AppCompatActivity {

    private EditText editTextName,editTextSurname,editTextBirthDate,editTextEmail;
    private Button buttonSave;
    private Client client;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion);




        buttonSave.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                editTextName = (EditText) findViewById(R.id.nameClient);
                editTextSurname=(EditText) findViewById(R.id.surnameClient);
                editTextBirthDate=(EditText) findViewById(R.id.birthDateClient);
                editTextEmail=(EditText) findViewById(R.id.emailClient);


            }
        });


        if (client !=null){

        }
    }

}
