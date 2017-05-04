package fr.projet.lokacar.ui.vehicule;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import fr.projet.lokacar.R;
import fr.projet.lokacar.models.Vehicule;

public class VehiculeActivity extends AppCompatActivity {

    private ImageView imageViewVehicule;
    private TextView textViewCategorie;
    private TextView textViewMarque;
    private TextView textViewModel;
    private EditText editTextKilometre;
    private TextView textViewEnergie;
    private TextView textViewnbPlace;
    private EditText editTextTarifHoraire;
    private TextView textViewAnnee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicule);

        imageViewVehicule = (ImageView) findViewById(R.id.imageViewVehicule);
        textViewCategorie = (TextView) findViewById(R.id.categorieVehicule);
        textViewMarque = (TextView) findViewById(R.id.marqueVehicule);
        textViewModel = (TextView) findViewById(R.id.modelVehicule);
        editTextKilometre = (EditText) findViewById(R.id.kilometreVehicule);
        textViewEnergie = (TextView) findViewById(R.id.energieVehicule);
        textViewnbPlace = (TextView) findViewById(R.id.nbPlaceVehicule);
        editTextTarifHoraire = (EditText) findViewById(R.id.tarifHoraireVehicule);
        textViewAnnee = (TextView) findViewById(R.id.anneeVehicule);

        if (getIntent().getExtras() != null) {
            Vehicule objet = (Vehicule) getIntent().getExtras().get("INTENT_OBJET");


            textViewMarque.setText(objet.getMarque());
            textViewModel.setText(objet.getModel());
            editTextKilometre.setText(Integer.valueOf(objet.getKilometre()).toString());
            textViewEnergie.setText(objet.getEnergie());
            textViewnbPlace.setText(Integer.valueOf(objet.getNbPlace()).toString());
            editTextTarifHoraire.setText(Double.toString(objet.getTarifHoraire()));
            textViewAnnee.setText(objet.getAnnee());

            Picasso.with(VehiculeActivity.this)
                    .load(objet.getPhoto())
                    .into(imageViewVehicule);
        }

    }
}
