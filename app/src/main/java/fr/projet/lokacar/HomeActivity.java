package fr.projet.lokacar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

import fr.projet.lokacar.models.Vehicule;
import fr.projet.lokacar.utils.FastDialog;
import fr.projet.lokacar.utils.Network;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        if (Network.isNetworkAvailable(HomeActivity.this)){
            // Instantiate the RequestQueue.
            RequestQueue queue = Volley.newRequestQueue(HomeActivity.this);
            String url = "http://10.4.140.5:3000/vehicule";

            // Request a string response from the provided URL.
            StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

                            response = response.replace("\\", "");
                            //response = response.replace("\"", "");
                            response = response.substring(1, response.length()-1);
                            //response = response.substring(response.length()-1, 1);

                            Log.e("json", response);

                            List<Vehicule> list = new Gson().fromJson(response,
                                    new TypeToken<List<Vehicule>>(){}.getType());

                            for(int i = 0; i < list.size(); i++){
                                Log.e("id", list.get(i).getId());
                            }

                            //Vehicule vehicule = gson.fromJson(response, Vehicule.class);

                            //console

                                /*textViewCity.setText(openWeather.name);
                                textViewTemperature.setText(openWeather.main.temp);

                                if (openWeather.weather.size() > 0){
                                    Picasso.with(MainActivity.this)
                                            .load(String.format(Constant.URL_IMAGE, openWeather.weather.get(0).icon))
                                            .error(R.mipmap.ic_launcher)
                                            .into(imageViewIcon);
                                }*/

                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            });
// Add the request to the RequestQueue.
            queue.add(stringRequest);
        }else{
            FastDialog.showDialog(HomeActivity.this,
                    FastDialog.SIMPLE_DIALOG,
                    "");
        }
    }
}
