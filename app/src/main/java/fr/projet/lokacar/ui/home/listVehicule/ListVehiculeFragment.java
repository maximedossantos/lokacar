package fr.projet.lokacar.ui.home.listVehicule;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

import fr.projet.lokacar.AddVehiculeActivity;
import fr.projet.lokacar.R;
import fr.projet.lokacar.models.Vehicule;
import fr.projet.lokacar.ui.vehicule.VehiculeActivity;
import fr.projet.lokacar.utils.FastDialog;
import fr.projet.lokacar.utils.Network;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListVehiculeFragment extends Fragment {

    private ListView listViewVehicule;
    private FloatingActionButton fab;

    public ListVehiculeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_list_vehicule, container, false);

        fab = (FloatingActionButton) view.findViewById(R.id.buttonAdd);

        listViewVehicule = (ListView) view.findViewById(R.id.listViewVehicule);

        return view;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {

                Intent intent = new Intent(getContext(), AddVehiculeActivity.class);

                startActivity(intent);
                /*FastDialog.showDialogAddVehicule(getContext(), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Snackbar.make(view, "Super", Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();
                    }
                }, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });*/


            }
        });

        if (Network.isNetworkAvailable(getContext())){
            // Instantiate the RequestQueue.
            RequestQueue queue = Volley.newRequestQueue(getContext());
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

                            final List<Vehicule> list = new Gson().fromJson(response,
                                    new TypeToken<List<Vehicule>>(){}.getType());

                            /*for(int i = 0; i < list.size(); i++){
                                Log.e("id", list.get(i).getId());
                            }*/

                            listViewVehicule.setAdapter(new VehiculeAdapter(getContext(),
                                    R.layout.item_vehicule, list));

                            listViewVehicule.setOnItemClickListener(new AdapterView.OnItemClickListener(){
                                @Override
                                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                                    Intent intent = new Intent(getContext(), VehiculeActivity.class);

                                    Bundle bundle = new Bundle();
                                    bundle.putSerializable("INTENT_OBJET", list.get(i));
                                    intent.putExtras(bundle);

                                    startActivity(intent);

                                }
                            });
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.e("error", "stop");
                }
            });
            // Add the request to the RequestQueue.
            queue.add(stringRequest);

        }else{
            FastDialog.showDialog(getContext(),
                    FastDialog.SIMPLE_DIALOG,
                    "");
        }
    }
}
