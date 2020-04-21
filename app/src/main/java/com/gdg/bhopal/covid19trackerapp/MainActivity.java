package com.gdg.bhopal.covid19trackerapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public  static final String DATA_URL="https://api.rootnet.in/covid19-in/unofficial/covid19india.org/statewise";
   RecyclerView  recyclerView;
    List<Usrdata> usrdata;
     CustumAdapter custumAdapter;
    static int a=0;
      @Override
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_main);
          recyclerView=findViewById(R.id.recycle);
             usrdata=new ArrayList<>();

          RequestQueue queue= Volley.newRequestQueue(this);
             //volley request
          StringRequest request=new StringRequest(DATA_URL, new Response.Listener<String>() {

              @Override

              public void onResponse(String response) {
                  JSONObject objec = null;
                  JSONArray arr=null;
                  try {
                      objec = new JSONObject(response);

                    JSONObject  jjarr=objec.getJSONObject("data");

                         arr=jjarr.getJSONArray("statewise");


                for(int i=0;i<arr.length();i++) {

                    JSONObject onjct = arr.getJSONObject(i);
                    Usrdata us = new Usrdata();

                        us.setState(onjct.getString("state").toString());
                        us.setActive(onjct.getString("active").toString());
                        us.setConferm(onjct.getString("confirmed").toString());
                        us.setDeath(onjct.getString("deaths").toString());
                        us.setRecover(onjct.getString("recovered").toString());
                        usrdata.add(us);
                      Log.i("data enter","    "+a);

                      a++;

                    }

                      } catch (JSONException e) {
                          e.printStackTrace();
                      }
                  recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                  custumAdapter=new CustumAdapter(getApplicationContext(),usrdata);
                  recyclerView.setAdapter(custumAdapter);
                  }


              },new Response.ErrorListener()
          {

              @Override
              public void onErrorResponse(VolleyError error) {
                  Log.e("error","erro"+error);
              }
          }

          );

          queue.add(request);


     }
}
