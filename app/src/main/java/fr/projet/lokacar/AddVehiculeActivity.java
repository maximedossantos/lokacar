package fr.projet.lokacar;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageSwitcher;
import android.widget.ImageView;

/**
 * Created by agirardeau2015 on 03/05/2017.
 */

public class AddVehiculeActivity extends AppCompatActivity {

    private EditText editTextMarque,editTextModel,editTextKm,editTextEnergie,editTextNbplace,editTextTarifHoraire,editTextAnnee;
    private Button buttonSave,buttonAddPhotoVehicule;
    private ImageView imageSwitcherListPhotoVehicule;
    private static final int CAMERA_REQUEST = 1888;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion);

        imageSwitcherListPhotoVehicule = (ImageView) this.findViewById(R.id.listPhotoVehicule);
        buttonAddPhotoVehicule = (Button)this.findViewById(R.id.addPhotoVehicule);

        buttonAddPhotoVehicule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cameraIntent =new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent,CAMERA_REQUEST);
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
