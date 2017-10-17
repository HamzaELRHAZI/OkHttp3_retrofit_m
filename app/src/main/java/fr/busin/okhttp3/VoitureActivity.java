package fr.busin.okhttp3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import fr.busin.okhttp3.models.Voiture;

public class VoitureActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voiture);
        Intent i = getIntent();
        ArrayList<Voiture> list = (ArrayList<Voiture>) i.getSerializableExtra("Cars");
        LinearLayout linearLayout = new LinearLayout(this);
        setContentView(linearLayout);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
         for(Voiture v:list)
        {
            TextView textView = new TextView(this);
            textView.setText("Name :" +v.getName()+"\n Marque : "+v.getMarque()+" \n Color : "+v.getCouleur()+"\n");
            linearLayout.addView(textView);
        }
    }
}
