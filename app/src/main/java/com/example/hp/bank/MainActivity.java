package com.example.hp.bank;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button r,l;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        r=(Button)findViewById(R.id.regi);
        l=(Button)findViewById(R.id.login);
        l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Login l1=new Login();

                android.support.v4.app.FragmentManager fm=getSupportFragmentManager();
                android.support.v4.app.FragmentTransaction ft=fm.beginTransaction();
                ft.replace(R.id.frag,l1);

                ft.commit();
            }
        });
        r.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Regist r1=new Regist();

                android.support.v4.app.FragmentManager fm=getSupportFragmentManager();
                android.support.v4.app.FragmentTransaction ft=fm.beginTransaction();
                ft.replace(R.id.frag,r1);

                ft.commit();

            }
        });
        getSupportActionBar().hide();

    }
}
