package com.example.chat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.ArrayList;
import java.util.Iterator;

public class _2_0homepage extends AppCompatActivity {

    ArrayList<TextView> id_view=new ArrayList<TextView>();
    ArrayList<TextView> title_view=new ArrayList<TextView>();
    static String gettitle="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout._2_0activity_homepage);

        if (Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }


        Button find_password=(Button)findViewById(R.id.send_btn);
        find_password.setOnClickListener(new View.OnClickListener(){
            @Override
            public void  onClick(View view){
                Intent registerintent=new Intent(_2_0homepage.this, _2_2homepage_make.class);
                _2_0homepage.this.startActivity(registerintent);
            }
        });

        id_view.add(findViewById(R.id.id1));
        id_view.add(findViewById(R.id.id2));
        id_view.add(findViewById(R.id.id3));
        id_view.add(findViewById(R.id.id4));
        id_view.add(findViewById(R.id.id5));
        id_view.add(findViewById(R.id.id6));
        id_view.add(findViewById(R.id.id7));
        id_view.add(findViewById(R.id.id8));
        id_view.add(findViewById(R.id.id9));
        id_view.add(findViewById(R.id.id10));

        title_view.add(findViewById(R.id.writer1));
        title_view.add(findViewById(R.id.writer2));
        title_view.add(findViewById(R.id.writer3));
        title_view.add(findViewById(R.id.writer4));
        title_view.add(findViewById(R.id.writer5));
        title_view.add(findViewById(R.id.writer6));
        title_view.add(findViewById(R.id.writer7));
        title_view.add(findViewById(R.id.writer8));
        title_view.add(findViewById(R.id.writer9));
        title_view.add(findViewById(R.id.writer10));

        Iterator<TextView> iter2 = title_view.iterator();
        while(iter2.hasNext()){
            TextView iternext= (TextView) iter2.next();
            iternext.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    System.out.println(iternext.getId());
                    System.out.println(iternext.getText());
                    gettitle= (String) iternext.getText();
                    System.out.println("gettitle"+gettitle);
                    Intent registerintent = new Intent(_2_0homepage.this, _2_1room_password_check.class);
                    _2_0homepage.this.startActivity(registerintent);
                }
            });
        }


        ImageButton homepage_re_btn=(ImageButton)findViewById(R.id.homepage_re_btn);
        homepage_re_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void  onClick(View view){
                homepage_method();     } });





        homepage_method();
    }

    @Override
    public void onBackPressed() {
        Intent registerintent = new Intent(_2_0homepage.this, _1_0first_page.class);
        _2_0homepage.this.startActivity(registerintent);
        super.onBackPressed();
    }

    public void homepage_method() {

        String url = "http://tidahk.dothome.co.kr/chat_homepage.php";
        StringRequest request = new StringRequest(
                Request.Method.GET,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        System.out.println("response\n" + response);

                        try {
                            StringBuilder sb0=new StringBuilder();
                            StringBuilder sb1=new StringBuilder();
                            StringBuilder sb2=new StringBuilder();
                            StringBuilder sb3=new StringBuilder();
                            String[] sp0=new String[100];
                            String[] sp1=new String[100];
                            String[] sp2=new String[100];
                            String[] sp3=new String[100];
                            JSONParser jsonParser = new JSONParser();
                            JSONObject jsonObject1 = (JSONObject) jsonParser.parse(response);
                            JSONArray json0 = (JSONArray) jsonObject1.get("result");


                            for (int i = 0; i < json0.size(); i++) {
                                JSONObject json1 = (JSONObject) json0.get(i);
                                System.out.println("json1"+json1);
                                String json2 = (String) json1.get("index");
                                String json3 = (String) json1.get("room_name");
                                System.out.println("json2"+json2);
                                System.out.println("json3"+json3);

                                sb0.append(json2+"split");
                                sb1.append(json3+"split");

                            }


                            sp0=sb0.toString().split("split");
                            sp1=sb1.toString().split("split");

                            for(int i=0;i<sp0.length;i++){
                                id_view.get(i).setText(sp0[i]);
                                title_view.get(i).setText(sp1[i]);
                            }

                        } catch (ParseException |NullPointerException e) {
                            e.printStackTrace();
                        }

                    }
                }
                ,
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        System.out.println(error + "통신실패");
                    }
                }
        );

        staticmethod.requestQueue.add(request);


    }


}