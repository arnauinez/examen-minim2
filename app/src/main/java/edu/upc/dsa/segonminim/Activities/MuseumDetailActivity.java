package edu.upc.dsa.segonminim.Activities;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import edu.upc.dsa.segonminim.Models.*;

public class MuseumDetailActivity extends AppCompatActivity {
    private Museums museumsList;
    private String Nom;

    public void setMuseumsList(Museums museumsList) {
        this.museumsList = museumsList;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
