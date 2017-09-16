package com.ear.evaluaciolab;

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

/**
 * Created by Adalberto on 16/09/2017.
 */

public class AdaptadorDatos extends ArrayAdapter<Estudiante> {
    public AdaptadorDatos(Context context, List<Estudiante> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Estudiante estudiante = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_datos, parent, false);
        }
        TextView lblNombre = (TextView) convertView.findViewById(R.id.lblNombre);
        TextView lblCodigo = (TextView) convertView.findViewById(R.id.lblCodigo);
        TextView lblMateria = (TextView) convertView.findViewById(R.id.lblMateria);
        TextView lblPromedio = (TextView) convertView.findViewById(R.id.lblPromedio);

        // mostrar los datos
        lblNombre.setText(estudiante.Nombre);
        lblMateria.setText(estudiante.Codigo);
        lblCodigo.setText(estudiante.Materia);
        lblPromedio.setText(estudiante.Promedio);

        return convertView;
    }
}
