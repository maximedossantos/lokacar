package fr.projet.lokacar.ui.vehicule;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import fr.projet.lokacar.R;
import fr.projet.lokacar.models.Vehicule;
import fr.projet.lokacar.utils.Network;

/**
 * Created by agirardeau2015 on 03/05/2017.
 */

public class AddVehiculeActivity extends AppCompatActivity {

    private EditText editTextMarque;
    private EditText editTextCategorie;
    private EditText editTextModel;
    private EditText editTextKm;
    private EditText editTextEnergie;
    private EditText editTextNbplace;
    private EditText editTextTarifHoraire;
    private EditText editTextAnnee;
    private EditText editTextDin;

    private Button buttonSave;
    private Button buttonAddPhotoVehicule;
    private ImageView imageSwitcherListPhotoVehicule;
    private static final int CAMERA_REQUEST = 1888;
    private Vehicule vehicule;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_vehicule);

        editTextMarque=(EditText)this.findViewById(R.id.marqueVehicule);
        editTextCategorie=(EditText) this.findViewById(R.id.categorieVehicule);
        editTextModel=(EditText)this.findViewById(R.id.modelVehicule);
        editTextEnergie=(EditText)this.findViewById(R.id.energieVehicule);
        editTextKm=(EditText)this.findViewById(R.id.kmVehicule);
        editTextNbplace=(EditText)this.findViewById(R.id.nbplace);
        editTextTarifHoraire=(EditText)this.findViewById(R.id.tarifHoraireVehicule);
        editTextAnnee=(EditText)this.findViewById(R.id.anneeVehicule);
        editTextDin=(EditText)this.findViewById(R.id.dinVehicule);
        buttonSave =(Button) this.findViewById(R.id.saveButtonVehicule);

        imageSwitcherListPhotoVehicule = (ImageView) this.findViewById(R.id.listPhotoVehicule);
        buttonAddPhotoVehicule = (Button)this.findViewById(R.id.addPhotoVehicule);
        buttonAddPhotoVehicule.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent cameraIntent =new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent,CAMERA_REQUEST);
            }
        });


        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                vehicule = new Vehicule();

                vehicule.setMarque(editTextMarque.getText().toString());
                vehicule.setModel(editTextModel.getText().toString());
                vehicule.setEnergie(editTextEnergie.getText().toString());
                vehicule.setKilometre(Integer.parseInt(editTextKm.getText().toString()));
                vehicule.setNbPlace(Integer.parseInt(editTextNbplace.getText().toString()));
                vehicule.setAnnee(editTextAnnee.getText().toString());
                vehicule.setDin(editTextDin.getText().toString());

                if (vehicule != null) {
                    if (Network.isNetworkAvailable(AddVehiculeActivity.this)) {


                    }
                }else{
                    new AlertDialog.Builder(AddVehiculeActivity.this)
                            .setTitle("Your Alert")
                            .setMessage("Your Message")
                            .setCancelable(false)
                            .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        // Whatever...
                                    }
                            }).show();
                }
            }
        });



    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAMERA_REQUEST && resultCode == Activity.RESULT_OK) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            imageSwitcherListPhotoVehicule.setImageBitmap(photo);
        }
    }

}
