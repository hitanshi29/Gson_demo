package com.example.hp.bank;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.hp.bank.AsynTask.AsyncResponce;
import com.example.hp.bank.AsynTask.WebserviceCall;
import com.example.hp.bank.Helper.Utils;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Regist extends Fragment {

    EditText u,p,a,c,e;
    Button reg;
    Spinner t;
    public View onCreateView (final LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState){




        container=(ViewGroup)inflater.inflate(R.layout.activity_regist,container,false);

        u=(EditText)container.findViewById(R.id.uname1);
        p=(EditText)container.findViewById(R.id.pwd1);
        a=(EditText)container.findViewById(R.id.add);
        c=(EditText)container.findViewById(R.id.con);
        e=(EditText)container.findViewById(R.id.email);
        t=(Spinner) container.findViewById(R.id.type);
        String[] str=getResources().getStringArray(R.array.utype);
        ArrayAdapter<String> aadp=new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1,str);
        aadp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        t.setAdapter(aadp);
        t.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        reg=(Button)container.findViewById(R.id.btn_regi);
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String u1 = u.getText().toString();
                String p1 = p.getText().toString();
                String a1 = a.getText().toString();
                String c1 = c.getText().toString();
                String e1 = e.getText().toString();
                //String[] str=getResources().getStringArray(R.array.utype);
                //String t1 = t.toString();

                if (u1.isEmpty() && p1.isEmpty() && a1.isEmpty() && c1.isEmpty() && e1.isEmpty()) {
                    Toast.makeText(getContext(),"field can't be empty",Toast.LENGTH_SHORT).show();
                    AlertDialog.Builder ad = new AlertDialog.Builder(getContext());
                    ad.setCancelable(false);
                    ad.setTitle("Error");
                    ad.setMessage("Plz fill information");
                    ad.setPositiveButton("Cancel", null);
                    ad.show();
                } else {
                    String[] keys = new String[]{"mode", "userName", "email", "address", "password", "contactNumber","userType"};
                    String[] values = new String[]{"registration", u1, e1, a1, p1, c1,"dj"};
                    String jsonRequest = Utils.createJsonRequest(keys, values);

                    String URL = "http://vnurture.in/ecart_new/admin/webservice.php";

                    new WebserviceCall(getContext(), URL, jsonRequest, "Logging in", true, new AsyncResponce() {


                        @Override
                        public void onCallback(String response) {
                            Log.d("myapp", response);
                            JavaDemo model = new Gson().fromJson(response, JavaDemo.class);
                           // Toast.makeText(getContext(), model.getMessage(), Toast.LENGTH_SHORT).show();

                            // store id to sharedpreference



                            if (model.getStatus() == 1) {

                              //  Toast.makeText(getContext(),"register", Toast.LENGTH_LONG).show();

//                                Intent intent = new Intent(Regist.this, MainActivity.class);
//                                intent.putExtra("Dev",model.getUserDetail().getUserId());
//                                startActivity(intent);
                            }


                        }
                    }).execute();
                }}
            });
                    return container;
            }
        }