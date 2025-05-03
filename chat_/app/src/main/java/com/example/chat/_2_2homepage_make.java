package com.example.chat;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.HashMap;
import java.util.Map;

public class _2_2homepage_make extends AppCompatActivity {

    static String make_password="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout._2_2homepage_make);



        Button roommake_btn=(Button)findViewById(R.id.roommake_btn);
        roommake_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void  onClick(View view){
                Intent registerintent=new Intent(_2_2homepage_make.this, _2_0homepage.class);
                _2_2homepage_make.this.startActivity(registerintent);

                room_make();
                System.out.println("방만들기클릭");
            }
        });
    }


    @Override
    public void onBackPressed() {
        Intent registerintent = new Intent(_2_2homepage_make.this, _2_0homepage.class);
        _2_2homepage_make.this.startActivity(registerintent);
        super.onBackPressed();
    }


    public void room_make() {
        String url = "http://tidahk.dothome.co.kr/make_chatroom.php";
        EditText room_name = (EditText) findViewById(R.id.room_name);

        String room_name_edit = room_name.getText().toString();

        EditText room_password = (EditText) findViewById(R.id.room_password);
        String room_password_edit = room_password.getText().toString();


        EditText room_othername2 = (EditText) findViewById(R.id.room_othername);
        String room_othername = room_othername2.getText().toString();

        StringRequest request = new StringRequest(
                Request.Method.POST,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        System.out.println("room_makeresponse"+response);
                        try {

                            JSONParser jsonParser = new JSONParser();
                            JSONObject jsonObject1 = (JSONObject) jsonParser.parse(response);
                            JSONObject json0 = (JSONObject) jsonObject1.get("result");
                            String json1 = (String) json0.get("title_db");
                            make_password = (String) json0.get("room_password_db");
                            String json3 = (String) json0.get("userid_db");
                            String json4 = (String) json0.get("otherid_db");

                            System.out.println("make_password222"+make_password);
                            AlertDialog.Builder builder = new AlertDialog.Builder(_2_2homepage_make.this);
                            builder.setTitle("방을 만들었습니다");
                            builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    System.out.println("버튼클릭1");
                                    Intent registerintent = new Intent(_2_2homepage_make.this, _2_0homepage.class);
                                    _2_2homepage_make.this.startActivity(registerintent);
                                }
                            });
                            AlertDialog alertDialog = builder.create();
                            alertDialog.show();

                        } catch (ParseException e) {
                            System.out.println("room_makeexeption"+e);
                            System.out.println("room_makecatchrespone"+response);
                        }
                        System.out.println("php통신성공");

                    }
                }
                ,
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(_2_2homepage_make.this);
                        builder.setTitle("서버통신 실패");
                        builder.setPositiveButton("뒤로가기", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                System.out.println("버튼클릭3");

                                Intent registerintent = new Intent(_2_2homepage_make.this, _2_2homepage_make.class);
                                _2_2homepage_make.this.startActivity(registerintent);
                            }
                        });
                        AlertDialog alertDialog = builder.create();
                        alertDialog.show();
                        System.out.println(error + "실패");
                    }
                }
        ) {
            @Override
            public Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("room_name_php", room_name_edit);
                params.put("room_password_php", room_password_edit);
                params.put("userid_php", _1_0first_page.json1);
                params.put("otherid_php", room_othername);
                return params;
            }
        };

        staticmethod.requestQueue.add(request);


    }



}