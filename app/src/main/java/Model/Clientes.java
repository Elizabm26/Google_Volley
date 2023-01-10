package Model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class Clientes {

    private  String Identificacion;
    private  String Nombre;
    private  String Direccion;
    private String Correo;

    public String getIdentificacion() {
        return Identificacion;
    }

    public void setIdentificacion(String identificacion) {
        Identificacion = identificacion;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String correo) {
        Correo = correo;
    }

    public Clientes(JSONObject a) throws JSONException{
        Identificacion = a.getString("identificacion").toString();
        Nombre = a.getString("nombre").toString();
        Direccion = a.getString("direccion").toString();
        Correo = a.getString("correo").toString();
    }

    public static ArrayList<Clientes> JsonObjectsBuild(JSONArray datos) throws JSONException {
        ArrayList<Clientes> clientes = new ArrayList<>();

        for (int i = 0; i < datos.length(); i++) {
            clientes.add(new Clientes(datos.getJSONObject(i)));
        }
        return clientes;
    }
}