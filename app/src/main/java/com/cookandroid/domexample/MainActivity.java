package com.cookandroid.domexample;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View v){
        switch (v.getId())
        {
            case R.id.button_All:
            {
                EditText date_EditText = (EditText)findViewById(R.id.date);
                EditText region_EditText = (EditText)findViewById(R.id.region);
                if(region_EditText.getText().toString().equals(""))
                {
                    Toast.makeText(this, "지역을 제대로 입력해주세요", Toast.LENGTH_LONG).show();
                    return;
                }
                String date = date_EditText.getText().toString();
                try{
                    String[] dateArray = date.split("[년월일]");
                    date = "";
                    for(int i = 0; i < dateArray.length; i++)
                        date = date + dateArray[i];
                    if(date.length() != 8)
                        throw new Exception();
                }catch (Exception e){
                    Toast.makeText(this, "날짜를 제대로 입력해주세요", Toast.LENGTH_LONG).show();
                    return;
                }
                Intent intent = new Intent(this, AllInfo.class);
                intent.putExtra("date", date);
                intent.putExtra("region", region_EditText.getText().toString());
                startActivity(intent);
                break;
            }
            case R.id.button_Dust:
            {
                EditText region_EditText = (EditText)findViewById(R.id.region_dust);
                if(region_EditText.getText().toString().equals(""))
                {
                    Toast.makeText(this, "지역을 제대로 입력해주세요", Toast.LENGTH_LONG).show();
                    return;
                }
                Intent intent = new Intent(this, Dust.class);
                intent.putExtra("region", region_EditText.getText().toString());
                startActivity(intent);
                break;
            }
        }
    }
}
