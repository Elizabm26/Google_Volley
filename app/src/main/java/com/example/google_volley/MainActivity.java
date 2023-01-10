package com.example.google_volley;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import Adaptador.ClienteAdapter;
import Model.Clientes;

public class MainActivity extends AppCompatActivity {

    ListView lstclientes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lstclientes = (ListView) findViewById(R.id.lst_user);
        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="https://api.uealecpeterson.net/public/clientes/search";
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject JSONlista =  new JSONObject(response);
                            JSONArray JSONlistaUsuarios= JSONlista.getJSONArray("clientes");
                            ArrayList<Clientes> lstProductoss = Clientes.JsonObjectsBuild(JSONlistaUsuarios);
                            ClienteAdapter adapatorUsuario = new ClienteAdapter( getApplicationContext(), lstProductoss);
                            lstclientes.setAdapter(adapatorUsuario);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),  error.getMessage(), Toast.LENGTH_LONG).show();
            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> headerMap = new HashMap<String, String>();
                headerMap.put("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpZHVzciI6OSwiZW1haWwiOiJjemFtYnJhbm9AdXRlcS5lZHUuZWMiLCJpYXQiOjE2NzE0OTYzOTEsImV4cCI6MTY3MTg1NjM5MX0.hZooTHB43sV3tdjL2unBAk7xIdClGRg3ltWUFTEfzyc");
                return headerMap;
            }
            protected Map<String, String> getParams(){
                Map<String, String> params = new HashMap<String, String>();
                params.put("fuente", "1");
                return params;
            }
        };
        queue.add(stringRequest);
    }
}