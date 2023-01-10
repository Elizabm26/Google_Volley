package Adaptador;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.google_volley.R;

import java.util.ArrayList;

import Model.Clientes;

public class ClienteAdapter extends ArrayAdapter<Clientes> {

    public ClienteAdapter(Context mctx, ArrayList<Clientes> datos ){
        super (mctx, R.layout.lyt_usuario, datos);
    }

    public View getView(int position, View convert, ViewGroup parent){

        LayoutInflater inflater = LayoutInflater.from(getContext());
        View cliente = inflater.inflate(R.layout.lyt_usuario,null);

        TextView identificacion = (TextView)cliente.findViewById(R.id.lblidentificacion);
        identificacion.setText(getItem(position).getIdentificacion());

        TextView nombre = (TextView)cliente.findViewById(R.id.lblnombre);
        nombre.setText(getItem(position).getNombre());

        TextView direccion = (TextView)cliente.findViewById(R.id.lbldireccion);
        direccion.setText(getItem(position).getDireccion());

        TextView correo = (TextView)cliente.findViewById(R.id.lblcorreo);
        correo.setText(getItem(position).getCorreo());

        return (cliente);
    }
}
