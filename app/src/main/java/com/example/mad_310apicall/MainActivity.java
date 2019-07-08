package com.example.mad_310apicall;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    ArrayList<Products> pro;
    ListView lstv;

    Listadapt adapt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pro = new ArrayList<>();
        lstv = findViewById(R.id.lst_products);

        String link = getResources().getString(R.string.link);

        try
        {
            String myjson = new Syncdata().execute(link).get();

            System.out.println("MainActivity :"+myjson);

            JSONObject mainObj = new JSONObject(myjson);

            JSONArray products = mainObj.getJSONArray("products");

            for(int i=0;i<products.length();i++)
            {
                JSONObject childObj = products.getJSONObject(i);
                String name = childObj.getString("title");
                String img = childObj.getString("image");
                String desc = childObj.getString("description");
                long price = childObj.getLong("price");


                pro.add(new Products(img,name,desc,price));

            }

            System.out.println("Size of Arraylist "+pro.size());

            adapt = new Listadapt(getApplicationContext(),pro);

            lstv.setAdapter(adapt);



            lstv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    Intent i = new Intent(MainActivity.this,Prodactdesc.class);

                    i.putExtra("data",pro.get(position));
                    startActivity(i);

                }
            });


        }catch (ExecutionException e)
        {
            Log.e("MainActivity :",e.getMessage());
        }catch (InterruptedException e)
        {
            Log.e("MainActivity :",e.getMessage());
        }catch (JSONException e)
        {
            Log.e("MainActivity :",e.getMessage());
        }


    }
}
