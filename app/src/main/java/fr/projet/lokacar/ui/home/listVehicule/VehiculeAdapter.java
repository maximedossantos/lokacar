package fr.projet.lokacar.ui.home.listVehicule;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import fr.projet.lokacar.R;
import fr.projet.lokacar.models.Vehicule;

/**
 * Created by mdossantos2015 on 03/05/2017.
 */

public class VehiculeAdapter extends ArrayAdapter<Vehicule> {

    private LayoutInflater inflater;
    private int resId; // R.layout.item_restaurant

    public VehiculeAdapter(@NonNull Context context,
                           @LayoutRes int resource,
                           @NonNull List<Vehicule> objects) {
        super(context, resource, objects);

        inflater = LayoutInflater.from(context);
        resId = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        ViewHolder viewHolder;

        if (convertView == null) {

            convertView = inflater.inflate(resId, parent, false);

            viewHolder = new ViewHolder();
            viewHolder.textViewMarque = (TextView) convertView.findViewById(R.id.textViewMarque);
            viewHolder.textViewModel = (TextView) convertView.findViewById(R.id.textViewModel);
            viewHolder.textViewAnnee = (TextView) convertView.findViewById(R.id.textViewAnnee);
            viewHolder.textViewEnergie = (TextView) convertView.findViewById(R.id.textViewEnergie);

            convertView.setTag(viewHolder); // Enregistrer les view dans le viewHolder
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Vehicule item = getItem(position);

        viewHolder.textViewMarque.setText(item.getMarque());
        viewHolder.textViewModel.setText(item.getModel());
        viewHolder.textViewAnnee.setText(item.getAnnee());
        viewHolder.textViewEnergie.setText(item.getEnergie());

        return convertView;
    }

    class ViewHolder{
        TextView textViewMarque;
        TextView textViewModel;
        TextView textViewAnnee;
        TextView textViewEnergie;
    }
}
