package com.example.mad_310apicall;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class Prodactdesc extends AppCompatActivity {

    ImageView pimg;
    TextView  pname,pdesc,pprice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prodactdesc);

        pimg = findViewById(R.id.desc_imag);
        pname = findViewById(R.id.desc_name);
        pdesc = findViewById(R.id.desc_pdesc);
        pprice  = findViewById(R.id.desc_price);


        Intent i = getIntent();

        Products p = i.getParcelableExtra("data");

        Picasso.get().load(p.getPimgurl()).into(pimg);

        pname.setText(p.getPproname());
        pdesc.setText(p.getPdesc());
        pprice.setText(""+p.getPrice());

    }
}
