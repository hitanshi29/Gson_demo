package com.example.hp.bank;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Login extends Fragment {

    Button log;
    public View onCreateView (LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState){
        container=(ViewGroup)inflater.inflate(R.layout.activity_login,container,false);
        log=(Button)container.findViewById(R.id.btn_login);

        return container;
    }
}
