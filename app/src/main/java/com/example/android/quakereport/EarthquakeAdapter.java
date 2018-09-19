package com.example.android.quakereport;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class EarthquakeAdapter extends ArrayAdapter {
    private Context context;

    public EarthquakeAdapter(@NonNull Context context, ArrayList<Earthquake> earthquakes) {
        super(context, 0, earthquakes);
    }

    private int getMagnitudeColor(double magnitude) {
        int magnitudeColorResourceId;
        int magnitudeFloor = (int) Math.floor(magnitude);
        Log.i("EarthquakeAdapter", String.valueOf(magnitudeFloor));
        switch (magnitudeFloor) {
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }
        return ContextCompat.getColor(getContext(),magnitudeColorResourceId);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View earthquakeView = convertView;

        if(earthquakeView == null){
            earthquakeView = LayoutInflater.from(getContext()).inflate(R.layout.listearthquake,parent,false);
        }

        Earthquake earthquake = (Earthquake) getItem(position);

        TextView txtMag = (TextView) earthquakeView.findViewById(R.id.txtMag);
        txtMag.setText(String.valueOf(earthquake.getmMagnivy()));

        GradientDrawable shape = (GradientDrawable)txtMag.getBackground();
        int magnitudeColor = getMagnitudeColor(Double.valueOf(earthquake.getmMagnivy()));
        shape.setColor(magnitudeColor);

        TextView txtCity = (TextView) earthquakeView.findViewById(R.id.txtCity);
        txtCity.setText(earthquake.getmCity());

        TextView txtDate = (TextView) earthquakeView.findViewById(R.id.txtDate);
        txtDate.setText(earthquake.getmDate());

        TextView txtTime = (TextView) earthquakeView.findViewById(R.id.txtTime);
        txtTime.setText(earthquake.getmTime());

        return earthquakeView;
    }
}
