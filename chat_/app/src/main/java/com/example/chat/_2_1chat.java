package com.example.chat;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class _2_1chat extends AppCompatActivity {
    ArrayList<TextView> id_view=new ArrayList<TextView>();
    ArrayList<TextView> title_view=new ArrayList<TextView>();
    ArrayList<TextView> writer_view=new ArrayList<TextView>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout._2_1activity_chat);
        if (Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }



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

        writer_view.add(findViewById(R.id.writer1));
        writer_view.add(findViewById(R.id.writer2));
        writer_view.add(findViewById(R.id.writer3));
        writer_view.add(findViewById(R.id.writer4));
        writer_view.add(findViewById(R.id.writer5));
        writer_view.add(findViewById(R.id.writer6));
        writer_view.add(findViewById(R.id.writer7));
        writer_view.add(findViewById(R.id.writer8));
        writer_view.add(findViewById(R.id.writer9));
        writer_view.add(findViewById(R.id.writer10));





        chatroom_method();




        Button send_button = (Button) findViewById(R.id.send_btn);
        send_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                send();
                EditText write_text = (EditText) findViewById(R.id.write_text);
                write_text.setText("");

                chatroom_method();


            }
        });

        ImageButton chat_re_btn=(ImageButton)findViewById(R.id.chat_re_btn);
        chat_re_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void  onClick(View view){
                chatroom_method();     } });






    }


    @Override
    public void onBackPressed() {
        Intent registerintent = new Intent(_2_1chat.this, _2_0homepage.class);
        _2_1chat.this.startActivity(registerintent);
        super.onBackPressed();
    }





    public void chatroom_method() {

        String url = "http://tidahk.dothome.co.kr/chatroom_home.php";
        StringRequest request = new StringRequest(
                Request.Method.POST,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        System.out.println("chatroom_method_response\n" + response);





                        try {
                            StringBuilder sb0=new StringBuilder();
                            StringBuilder sb1=new StringBuilder();
                            StringBuilder sb2=new StringBuilder();
                            String[] sp0=new String[100];
                            String[] sp1=new String[100];
                            String[] sp2=new String[100];
                            JSONParser jsonParser = new JSONParser();
                            JSONObject jsonObject1 = (JSONObject) jsonParser.parse(response);
                            JSONArray json0 = (JSONArray) jsonObject1.get("result");

                            for (int i = 0; i < json0.size(); i++) {

                                JSONObject json1 = (JSONObject) json0.get(i);
                                String json2 = (String) json1.get("make_other_id");
                                String json3 = (String) json1.get("make_user_id");


                                if(_2_1room_password_check.chat_room_json4.equals(_1_0first_page.json1)) {
                                    sb0.append(json3+"split");
                                    sb1.append(json2+"split");
                                }else{
                                    sb0.append(json2+"split");
                                    sb1.append(json3+"split");
                                }


                                System.out.println("chatroom_methodjson2"+json2);
                                System.out.println("chatroom_methodjson3"+json3);

                            }
                            sp0=sb0.toString().split("split");
                            sp1=sb1.toString().split("split");

                            for(int i=0;i<sp0.length;i++){

                                System.out.println("sp0[i]"+sp0[i]);
                                System.out.println("sp1[i]"+sp1[i]);

                                id_view.get(i).setText(sp0[i]);
                                writer_view.get(i).setText(sp1[i]);
                            }

                        } catch (ParseException|NullPointerException|IndexOutOfBoundsException e) {
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
        ) {
            @Override
            public Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("title_php", _2_0homepage.gettitle);
                return params;
            }
        };

        staticmethod.requestQueue.add(request);


    }


    public void send() {
        String url = "http://tidahk.dothome.co.kr/send_massege.php";

        EditText write_text = (EditText) findViewById(R.id.write_text);

        String write_text_var = write_text.getText().toString();


        StringRequest request = new StringRequest(
                Request.Method.POST,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        System.out.println("send_massege_response"+response);
                        StringBuilder sb0=new StringBuilder();
                        StringBuilder sb1=new StringBuilder();
                        StringBuilder sb2=new StringBuilder();
                        StringBuilder sb3=new StringBuilder();
                        String[] sp0=new String[100];
                        String[] sp1=new String[100];
                        String[] sp2=new String[100];
                        String[] sp3=new String[100];
                        System.out.println("writer_id_php="+ _1_0first_page.json1);
                        System.out.println("other_id_php="+_2_1room_password_check.passwordcheck_otherid);



                        System.out.println("php통신성공");

                    }
                }
                ,
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(_2_1chat.this);
                        builder.setTitle("서버통신 실패");
                        builder.setPositiveButton("뒤로가기", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                System.out.println("버튼클릭3");

                                Intent registerintent = new Intent(_2_1chat.this, _2_1chat.class);
                                _2_1chat.this.startActivity(registerintent);
                            }
                        });
                        AlertDialog alertDialog = builder.create();
                        alertDialog.show();
                        System.out.println(error + "실패");
                        String json1 = _1_0first_page.json1;
                    }
                }
        ) {
            @Override
            public Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("write_text_php", write_text_var);
                params.put("writer_id_php", _1_0first_page.json1);
                params.put("other_id_php", _2_1room_password_check.passwordcheck_otherid);
                params.put("room_title", _2_0homepage.gettitle);

                return params;
            }
        };

        staticmethod.requestQueue.add(request);


    }















}