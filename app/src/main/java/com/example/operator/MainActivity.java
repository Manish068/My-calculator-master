package com.example.operator;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private Button zero0;
    private Button one1;
    private Button two2;
    private Button three3;
    private Button four4;
    private Button five5;
    private Button six6;
    private Button seven7;
    private Button eight8;
    private Button nine9;
    private Button ADD;
    private Button MOD;
    private Button DIV;
    private Button sub;
    private Button root;
    private Button EQ;
    private Button MULTI;
    private Button CLEAR;
    private Double value1=Double.NaN;
    private Double value2;
    private TextView results;
    private TextView inf;
    private  char Action;
    private final char ADDIT='+';
    private final char EQUAL='0';
    private final char MODULUS='%';
    private final char DIVIDE='/';
    private final char MULTIPLICATION='*';
    private final char SUBTRACTION='-';
    private final char SQUARERT='q';
    private Double temp;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle stoggle;
    SharedPref sharedpref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        sharedpref = new SharedPref(this);
        if(sharedpref.loadNightModeState()==true) {
            setTheme(R.style.LightTheme);
        }
        else  setTheme(R.style.DarkTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mDrawerLayout=(DrawerLayout)findViewById(R.id.drawer);
        stoggle=new ActionBarDrawerToggle(MainActivity.this,mDrawerLayout,R.string.open,R.string.close);
        mDrawerLayout.addDrawerListener(stoggle);
        stoggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView navigationView=(NavigationView)findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);


        calculatorUI();



        zero0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inf.setText(inf.getText().toString()+"0");
            }
        });

        one1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inf.setText(inf.getText().toString()+"1");
            }
        });

        two2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inf.setText(inf.getText().toString()+"2");
            }
        });

        three3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inf.setText(inf.getText().toString()+"3");
            }
        });

        four4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inf.setText(inf.getText().toString()+"4");
            }
        });

        five5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inf.setText(inf.getText().toString()+"5");
            }
        });

        six6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inf.setText(inf.getText().toString()+"6");
            }
        });

        seven7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inf.setText(inf.getText().toString()+"7");
            }
        });
        eight8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inf.setText(inf.getText().toString()+"8");
            }
        });

        nine9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inf.setText(inf.getText().toString()+"9");
            }
        });

        ADD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=inf.getText().toString();
                if(name==""){
                    Toast.makeText(getApplicationContext(),"input value",Toast.LENGTH_LONG).show();
                }
                else {
                    comp();
                    Action = ADDIT;
                    results.setText(String.valueOf(value1) + "+");
                    inf.setText(null);
                }
            }
        });

        DIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=inf.getText().toString();
                if(name==""){
                    Toast.makeText(getApplicationContext(),"input value",Toast.LENGTH_LONG).show();
                }
                else {
                    comp();
                    Action = DIVIDE;
                    results.setText(String.valueOf(value1) + "/");
                    inf.setText(null);
                }
            }
        });

        MOD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=inf.getText().toString();
                if(name==""){
                    Toast.makeText(getApplicationContext(),"input value",Toast.LENGTH_LONG).show();
                }
                else {
                    comp();
                    Action = MODULUS;
                    results.setText(String.valueOf(value1) + "%");
                    inf.setText(null);
                }
            }
        });

        MULTI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=inf.getText().toString();
                if(name==""){
                    Toast.makeText(getApplicationContext(),"input value",Toast.LENGTH_LONG).show();
                }
                else {
                    comp();
                    Action=MULTIPLICATION;
                    results.setText(String.valueOf(value1)+"*");
                    inf.setText(null);
                }
            }
        });

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=inf.getText().toString();
                if(name==""){
                    Toast.makeText(getApplicationContext(),"input value",Toast.LENGTH_LONG).show();
                }
                else {
                    comp();
                    Action = SUBTRACTION;
                    results.setText(String.valueOf(value1) + "-");
                    inf.setText(null);
                }
            }
        });
        root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=inf.getText().toString();
                if(name==""){
                    Toast.makeText(getApplicationContext(),"input value",Toast.LENGTH_LONG).show();
                }
                else {
                    comp();
                    Action = SQUARERT;
                    results.setText("sqrt("+String.valueOf(value1)+")");
                }
            }
        });


        EQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=inf.getText().toString();
                if(name==""){
                    Toast.makeText(getApplicationContext(),"input value",Toast.LENGTH_LONG).show();
                }
                else {
                    comp();
                    Action = EQUAL;
                    if(temp==value1){
                        inf.setText(null);
                        results.setText(results.getText().toString()+"="+String.valueOf(value1));
                    }
                    else {
                        results.setText(results.getText().toString() + String.valueOf(value2) + "=" + String.valueOf(value1));
                        inf.setText(null);
                    }
                }
            }
        });
        CLEAR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(inf.getText().length()>0){
                    CharSequence name=inf.getText().toString();
                    inf.setText(name.subSequence(0,name.length()-1));
                }
                else{
                    value1=Double.NaN;
                    value2=Double.NaN;
                    inf.setText(null);
                    results.setText(null);
                }
            }
        });
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(stoggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    private void calculatorUI(){
        zero0=(Button)findViewById(R.id.num0);
        one1=(Button)findViewById(R.id.num1);
        two2=(Button)findViewById(R.id.num2);
        three3=(Button)findViewById(R.id.num3);
        four4=(Button)findViewById(R.id.num4);
        five5=(Button)findViewById(R.id.num5);
        six6=(Button)findViewById(R.id.num6);
        seven7=(Button)findViewById(R.id.num7);
        eight8=(Button)findViewById(R.id.num8);
        nine9=(Button)findViewById(R.id.num9);
        ADD=(Button)findViewById(R.id.a);
        DIV=(Button)findViewById(R.id.opdiv);
        MOD=(Button)findViewById(R.id.m);
        MULTI=(Button)findViewById(R.id.mu);
        sub=(Button)findViewById(R.id.s);
        root=(Button)findViewById(R.id.root);
        CLEAR=(Button)findViewById(R.id.C);
        EQ=(Button)findViewById(R.id.e);
        inf=(TextView)findViewById(R.id.inp);
        results=(TextView)findViewById(R.id.res);

    }
    private void comp(){
        if(!Double.isNaN(value1)){
            value2=Double.parseDouble(inf.getText().toString());
            switch (Action){
                case ADDIT:
                    value1=value1+value2;
                    break;
                case DIVIDE:
                    value1=value1/value2;
                    break;
                case MODULUS:
                    value1=value1%value2;
                    break;
                case MULTIPLICATION:
                    value1=value1*value2;
                    break;
                case SUBTRACTION:
                    value1=value1-value2;
                    break;
                case SQUARERT:
                    value1=Math.sqrt(value1);
                    temp=value1;
                    break;
                case EQUAL:
                    break;
            }
        }
        else {
            value1=Double.parseDouble(inf.getText().toString());
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id= menuItem.getItemId();

        if(id==R.id.home)
        {
            Intent myintent=new Intent(MainActivity.this,Scientific.class);
            startActivity(myintent);
            return false;
        }
        if(id==R.id.set){
            Intent myintent=new Intent(MainActivity.this,settinglayout.class);
            startActivity(myintent);
            return false;
        }
        if (id==R.id.standard) {


        }
        return false;
    }
}

