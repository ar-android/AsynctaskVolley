package com.ocit.asynctaskvolley;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private String URL = "http://ocittwo.tk/manga/api/beranda";
    private ArrayList<DataResponse> data;
    private ResponseObject responData;
    private ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listview = (ListView)findViewById(R.id.listview);

        data = new ArrayList<DataResponse>();
        volleyAsyncTask();

    }

    private void volleyAsyncTask() {
        JsonObjectRequest request = new JsonObjectRequest(URL, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Gson gson = new Gson();
                        responData = gson.fromJson(response.toString(), ResponseObject.class);
                        data = responData.getResponse();

                        AdapterListview adapter = new AdapterListview(getApplicationContext(), data);
                        listview.setAdapter(adapter);

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }
        );

        AplicationContext.getInstance().getRequestQueue().add(request);
    }

    private class ResponseObject{
        ArrayList<DataResponse> response;

        public ArrayList<DataResponse> getResponse() {
            return response;
        }

        public void setResponse(ArrayList<DataResponse> response) {
            this.response = response;
        }
    }
}