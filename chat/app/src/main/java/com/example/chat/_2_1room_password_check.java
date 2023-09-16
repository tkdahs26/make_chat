package com.example.chat;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.json.simple.JSONArray;

import java.util.HashMap;
import java.util.Map;

public class _2_1room_password_check extends AppCompatActivity {

    static String passwordcheck_otherid="";
    static String chat_room_me0="";
    static String chat_room_other0="";
    static String chat_room_json4="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout._2_1room_password_check);


        if (Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }


        Button password_check_btn=(Button)findViewById(R.id.password_check_btn);
        password_check_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void  onClick(View view){
                passwordcheck();
            }
        });
    }





    @Override
    public void onBackPressed() {
        Intent registerintent = new Intent(_2_1room_password_check.this, _2_0homepage.class);
        _2_1room_password_check.this.startActivity(registerintent);
        super.onBackPressed();
    }

    public void passwordcheck() {
        String url = "http://tidahk.dothome.co.kr/passwordcheck_php.php";

        EditText edit_room_password = (EditText) findViewById(R.id.room_password_check);

        String room_password_text = edit_room_password.getText().toString();


        StringRequest request = new StringRequest(
                Request.Method.POST,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        System.out.println("passwordcheckresponse"+response);
                        try {

                            JSONParser jsonParser = new JSONParser();
                            JSONObject jsonObject = (JSONObject) jsonParser.parse(response);
                            JSONObject json0 = (JSONObject) jsonObject.get("result");
                            String json1 = (String) json0.get("title_db");
                            String json2 = (String) json0.get("room_password_db");
                            String json3 = (String) json0.get("userid_db");
                            String json4 = (String) json0.get("otherid_db");

                            chat_room_json4=json4;
                            if(json4.equals(_1_0first_page.json1)) {
                                System.out.println("json4="+json4);
                                System.out.println("방만들때 기입한 상대id랑 로그인id랑 일치하므로 passwordcheck_otherid 변경");

                                passwordcheck_otherid= (String) json0.get("userid_db");
                                System.out.println("passwordcheck_otherid"+passwordcheck_otherid);
                            }else{
                                System.out.println("json4="+json4);
                                System.out.println("방만들때 기입한 상대id랑 로그인id랑 일치하지않음");
                                passwordcheck_otherid = (String) json0.get("otherid_db");
                                System.out.println("passwordcheck_otherid="+passwordcheck_otherid);
                            }

                            System.out.println("gettitle" + _2_0homepage.gettitle);
                            System.out.println("json1111111" + json1);
                            if (_2_0homepage.gettitle.equals(json1)) {
                                AlertDialog.Builder builder = new AlertDialog.Builder(_2_1room_password_check.this);
                                builder.setTitle("비밀번호확인 완료");
                                builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        System.out.println("버튼클릭1");
                                        Intent registerintent = new Intent(_2_1room_password_check.this, _2_1chat.class);
                                        _2_1room_password_check.this.startActivity(registerintent);
                                    }
                                });
                                AlertDialog alertDialog = builder.create();
                                alertDialog.show();
                            } else {

                                AlertDialog.Builder builder = new AlertDialog.Builder(_2_1room_password_check.this);
                                builder.setTitle("비밀번호가 틀립니다");
                                builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        System.out.println("버튼클릭1");
                                        Intent registerintent = new Intent(_2_1room_password_check.this, _2_0homepage.class);
                                        _2_1room_password_check.this.startActivity(registerintent);
                                    }
                                });
                                AlertDialog alertDialog = builder.create();
                                alertDialog.show();
                            }


                        } catch (NullPointerException | ParseException e) {
                            System.out.println("exeption"+e);
                            System.out.println("catchrespone"+response);

                            AlertDialog.Builder builder = new AlertDialog.Builder(_2_1room_password_check.this);
                            builder.setTitle("비밀번호가 틀립니다 catch오류");
                            builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    System.out.println("버튼클릭1");
                                    Intent registerintent = new Intent(_2_1room_password_check.this, _2_0homepage.class);
                                    _2_1room_password_check.this.startActivity(registerintent);
                                }
                            });
                            AlertDialog alertDialog = builder.create();
                            alertDialog.show();

                        }
                        System.out.println("php통신성공");

                    }
                }

                ,
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(_2_1room_password_check.this);
                        builder.setTitle("서버통신 실패");
                        builder.setPositiveButton("뒤로가기", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                System.out.println("버튼클릭3");

                                Intent registerintent = new Intent(_2_1room_password_check.this, _2_1room_password_check.class);
                                _2_1room_password_check.this.startActivity(registerintent);
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
                params.put("room_password_php", room_password_text);
                return params;
            }
        };

        staticmethod.requestQueue.add(request);


    }

}

