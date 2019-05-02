package com.example.operator;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethod;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.evgenii.jsevaluator.JsEvaluator;
import com.evgenii.jsevaluator.interfaces.JsCallback;

public class Scientific extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle stoggle;

    private String val1;

    EditText Text;
    Button shiftbutton;
    Button sin,cos,tan;
    JsEvaluator jsEvaluator;
    Button zero0,one1,two2,three3,four4,five5,six6,seven7,eight8,nine9,equal,cosec,cot,sec;
    Button add,minus,division,multiply,del,AC,log,ln,ANS,EXP,dot,openbr,closebr,x2,x3,comma,fact,reci,pie,rad,pow,sqrt;
    Boolean shiftpressed=false;
    SharedPref sharedpref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        sharedpref = new SharedPref(this);
        if(sharedpref.loadNightModeState()==true) {
            setTheme(R.style.LightTheme);
        }
        else  setTheme(R.style.DarkTheme);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scientific);
        mDrawerLayout=(DrawerLayout)findViewById(R.id.drawer);
        stoggle=new ActionBarDrawerToggle(Scientific.this,mDrawerLayout,R.string.open,R.string.close);
        mDrawerLayout.addDrawerListener(stoggle);
        stoggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView navigationView=(NavigationView)findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);
        UI();
        Text.setText("0");
        jsEvaluator=new JsEvaluator(this);

        zero0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Text.setText(Text.getText()+"0");
                Text.setSelection(Text.getText().length());
            }
        });

        one1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Text.getText().toString().equals("0")){
                    Text.setText("1");
                    Text.setSelection(Text.getText().length());
                }else{
                    Text.setText(Text.getText()+"1");
                    Text.setSelection(Text.getText().length());
                }
            }
        });

        two2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Text.getText().toString().equals("0")){
                    Text.setText("2");
                    Text.setSelection(Text.getText().length());
                }else{
                    Text.setText(Text.getText()+"2");
                    Text.setSelection(Text.getText().length());
                }
            }
        });

        three3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Text.getText().toString().equals("0")){
                    Text.setText("3");
                    Text.setSelection(Text.getText().length());
                }else{
                    Text.setText(Text.getText()+"3");
                    Text.setSelection(Text.getText().length());
                }
            }
        });

        four4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Text.getText().toString().equals("0")){
                    Text.setText("4");
                    Text.setSelection(Text.getText().length());
                }else{
                    Text.setText(Text.getText()+"4");
                    Text.setSelection(Text.getText().length());
                }
            }
        });

        five5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Text.getText().toString().equals("0")){
                    Text.setText("5");
                    Text.setSelection(Text.getText().length());
                }else{
                    Text.setText(Text.getText()+"5");
                    Text.setSelection(Text.getText().length());
                }
            }
        });

        six6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Text.getText().toString().equals("0")){
                    Text.setText("6");
                    Text.setSelection(Text.getText().length());
                }else{
                    Text.setText(Text.getText()+"6");
                    Text.setSelection(Text.getText().length());
                }
            }
        });

        seven7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Text.getText().toString().equals("0")){
                    Text.setText("7");
                    Text.setSelection(Text.getText().length());
                }else{
                    Text.setText(Text.getText()+"7");
                    Text.setSelection(Text.getText().length());
                }            }
        });
        eight8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Text.getText().toString().equals("0")){
                    Text.setText("8");
                    Text.setSelection(Text.getText().length());
                }else{
                    Text.setText(Text.getText()+"8");
                    Text.setSelection(Text.getText().length());
                }
            }
        });

        nine9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Text.getText().toString().equals("0")){
                    Text.setText("9");
                    Text.setSelection(Text.getText().length());
                }else{
                    Text.setText(Text.getText()+"9");
                    Text.setSelection(Text.getText().length());
                }
            }
        });


        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Text.getText().toString().equals("null") && Text.getText().toString().equals(" ")){
                    Text.setText(".syntax error");
                }
                else{
                    jsEvaluator.evaluate(Text.getText().toString(), new JsCallback() {
                        @Override
                        public void onResult(String value) {
                            val1=value;
                            Text.setText(value);
                            Text.setSelection(Text.getText().length());
                        }

                        @Override
                        public void onError(String errorMessage) {
                            Text.setText(".syntax error");
                            Text.setSelection(Text.getText().length());

                        }
                    });
                }
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Text.setText(Text.getText()+"+");
                Text.setSelection(Text.getText().length());
            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Text.setText(Text.getText()+"-");
                Text.setSelection(Text.getText().length());
            }
        });
        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Text.setText(Text.getText()+"*");
                Text.setSelection(Text.getText().length());
            }
        });
        division.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Text.setText(Text.getText()+"/");
                Text.setSelection(Text.getText().length());
            }
        });
        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Text.setText(Text.getText()+".");
                Text.setSelection(Text.getText().length());
            }
        });

        EXP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Text.getText().toString().equals("0")){
                    Text.setText("Math.exp(");
                    Text.setSelection(Text.getText().length());
                }else{
                    Text.setText(Text.getText()+"Math.exp(");
                    Text.setSelection(Text.getText().length());
                }
            }
        });

        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Text.getText().toString().equals("0")){
                    Text.setText("Math.log(");
                    Text.setSelection(Text.getText().length());
                }else{
                    Text.setText(Text.getText()+"Math.log(");
                    Text.setSelection(Text.getText().length());
                }
            }
        });

        ln.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Text.getText().toString().equals("0")){
                    Text.setText("Math.log10(");
                    Text.setSelection(Text.getText().length());
                }else{
                    Text.setText(Text.getText()+"Math.log10(");
                    Text.setSelection(Text.getText().length());
                }
            }
        });

        ANS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(Text.getText().toString().equals("0")){
                    Text.setText(val1);
                    Text.setSelection(Text.getText().length());
                }else{
                    Text.setText(val1+Text.getText());
                    Text.setSelection(Text.getText().length());
                }
            }
        });
        cos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Text.getText().toString().equals("0") && cos.getText().toString().equals("cos")){
                    Text.setText("Math.cos(");
                    Text.setSelection(Text.getText().length());
                }else if(cos.getText().toString().equals("cos-1")){
                    String inputvalue=Text.getText().toString();
                    double val=Math.toDegrees(Math.acos(Double.parseDouble(inputvalue)));

                    String newValue=Double.toString(val);
                    Text.setText(newValue);
                    Text.setSelection(Text.getText().length());
                }else{
                    Text.setText(Text.getText()+"Math.cos(");
                    Text.setSelection(Text.getText().length());
                }
            }
        });

        sin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Text.getText().toString().equals("0") && sin.getText().toString().equals("sin")){
                    Text.setText("Math.sin(");
                    Text.setSelection(Text.getText().length());
                }else if(sin.getText().toString().equals("sin-1")){
                    String inputvalue=Text.getText().toString();
                    double val=Math.toDegrees(Math.asin(Double.parseDouble(inputvalue)));

                    String newValue=Double.toString(val);
                    Text.setText(newValue);
                    Text.setSelection(Text.getText().length());
                }else{
                    Text.setText(Text.getText()+"Math.sin(");
                    Text.setSelection(Text.getText().length());
                }
            }
        });

        tan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Text.getText().toString().equals("0") && tan.getText().toString().equals("tan")){
                    Text.setText("Math.tan(");
                    Text.setSelection(Text.getText().length());
                }else if(tan.getText().toString().equals("tan-1")){
                    String inputvalue=Text.getText().toString();
                    double val=Math.toDegrees(Math.atan(Double.parseDouble(inputvalue)));

                    String newValue=Double.toString(val);
                    Text.setText(newValue);
                    Text.setSelection(Text.getText().length());
                }else{
                    Text.setText(Text.getText()+"Math.tan(");
                    Text.setSelection(Text.getText().length());
                }
            }
        });

        shiftbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(shiftpressed==false){
                    shiftpressed=true;
                    sin.setText("sin-1");
                    cos.setText("cos-1");
                    tan.setText("tan-1");
                    shiftbutton.setBackgroundColor(Color.parseColor("#FFFF80"));
                    shiftbutton.setBackgroundResource(R.drawable.circle_button);
                }else if(shiftpressed){
                    shiftpressed=false;
                    sin.setText("sin");
                    cos.setText("cos");
                    tan.setText("tan");
                    shiftbutton.setBackgroundResource(R.drawable.circle_button);
                }
            }
        });

        cot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Text.getText().toString().equals("0")){
                    Text.setText("Math.atan(");
                    Text.setSelection(Text.getText().length());
                }else{
                    Text.setText(Text.getText()+"Math.atan(");
                    Text.setSelection(Text.getText().length());
                }
            }
        });

        cosec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Text.getText().toString().equals("0")){
                    Text.setText("Math.asin(");
                    Text.setSelection(Text.getText().length());
                }else{
                    Text.setText(Text.getText()+"Math.asin(");
                    Text.setSelection(Text.getText().length());
                }
            }
        });

        sec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Text.getText().toString().equals("0")){
                    Text.setText("Math.acos(");
                    Text.setSelection(Text.getText().length());
                }else{
                    Text.setText(Text.getText()+"Math.acos(");
                    Text.setSelection(Text.getText().length());
                }
            }
        });

        openbr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Text.getText().toString().equals("0")){
                    Text.setText("(");
                    Text.setSelection(Text.getText().length());
                }else{
                    Text.setText(Text.getText()+"(");
                    Text.setSelection(Text.getText().length());
                }
            }
        });

        closebr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Text.getText().toString().equals("0")){
                    Text.setText(")");
                    Text.setSelection(Text.getText().length());
                }else{
                    Text.setText(Text.getText()+")");
                    Text.setSelection(Text.getText().length());
                }
            }
        });

        AC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Text.setText("0");
                Text.setSelection(Text.getText().length());
            }
        });

        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text=Text.getText().toString();
                if(text.length()==1){
                    Text.setText("0");
                }else{
                    Text.setText(text.substring(0,text.length()-1));
                    Text.setSelection(Text.getText().length());
                }
            }
        });
        x2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Text.setText(Text.getText()+"*2");
                Text.setSelection(Text.getText().length());

            }
        });

        x3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double ans=Double.parseDouble(Text.getText().toString());
                ans=ans*ans*ans;
                Text.setText(""+ans);
                Text.setSelection(Text.getText().length());
            }
        });

        comma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Text.getText().toString().equals("0")){
                    Text.setText(",");
                    Text.setSelection(Text.getText().length());
                }else{
                    Text.setText(Text.getText()+",");
                    Text.setSelection(Text.getText().length());
                }
            }
        });
        pie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Text.setText(Text.getText()+"3.14159");
                Text.setSelection(Text.getText().length());
            }
        });
        fact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int i,fact=1;
                int number=Integer.parseInt(Text.getText().toString());
                for(i=0;i<=number;i++){
                    fact=fact*1;
                }
                Text.setText(""+fact);
                Text.setSelection(Text.getText().length());
            }
        });

        rad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double answer=Double.parseDouble(Text.getText().toString())* 0.01745329252;
                Text.setText(""+answer);
                Text.setSelection(Text.getText().length());
            }
        });
        reci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double ans=1/Double.parseDouble(Text.getText().toString());
                Text.setText(""+ans);
                Text.setSelection(Text.getText().length());
            }
        });
        pow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Text.getText().toString().equals("0")){
                    Text.setText("Math.pow(");
                    Text.setSelection(Text.getText().length());
                }else{
                    Text.setText(Text.getText()+"Math.pow(");
                    Text.setSelection(Text.getText().length());
                }
            }
        });

        sqrt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Text.getText().toString().equals("0")){
                    Text.setText("Math.sqrt(");
                    Text.setSelection(Text.getText().length());
                }else{
                    Text.setText(Text.getText()+"Math.sqrt(");
                    Text.setSelection(Text.getText().length());
                }
            }
        });
    }


    private void UI(){
        zero0=(Button)findViewById(R.id.btn0);
        one1=(Button)findViewById(R.id.btn1);
        two2=(Button)findViewById(R.id.btn2);
        three3=(Button)findViewById(R.id.btn3);
        four4=(Button)findViewById(R.id.btn4);
        five5=(Button)findViewById(R.id.btn5);
        six6=(Button)findViewById(R.id.btn6);
        seven7=(Button)findViewById(R.id.btn7);
        eight8=(Button)findViewById(R.id.btn8);
        nine9=(Button)findViewById(R.id.btn9);
        sin=(Button)findViewById(R.id.btnsin);
        cos=(Button)findViewById(R.id.btncos);
        tan=(Button)findViewById(R.id.btntan);
        cosec=(Button)findViewById(R.id.btncosec);
        cot=(Button)findViewById(R.id.btncot);
        sec=(Button)findViewById(R.id.btnsec);
        shiftbutton=(Button)findViewById(R.id.btnshift);
        equal=(Button)findViewById(R.id.Equal);
        Text=(EditText)findViewById(R.id.display_text);
        add=(Button)findViewById(R.id.btnplus);
        minus=(Button)findViewById(R.id.btnmin);
        multiply=(Button)findViewById(R.id.btnmul);
        division=(Button)findViewById(R.id.btndiv);
        ANS=(Button)findViewById(R.id.btnans);
        AC=(Button)findViewById(R.id.btnac);
        del=(Button)findViewById(R.id.btndel);
        log=(Button)findViewById(R.id.btnlog);
        ln=(Button)findViewById(R.id.btnln);
        EXP=(Button)findViewById(R.id.btnEXP);
        dot=(Button)findViewById(R.id.btndot);
        openbr=(Button)findViewById(R.id.btnbr1);
        closebr=(Button)findViewById(R.id.btnbr2);
        x2=(Button)findViewById(R.id.btnsqr2);
        x3=(Button)findViewById(R.id.btncubx);
        comma=(Button)findViewById(R.id.btnsep);
        pie=(Button)findViewById(R.id.btnpie);
        fact=(Button)findViewById(R.id.btnfct);
        rad=(Button)findViewById(R.id.btnrad);
        reci=(Button)findViewById(R.id.btnbyx);
        pow=(Button)findViewById(R.id.btnxy);
        sqrt=(Button)findViewById(R.id.btnsqr);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(stoggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id= menuItem.getItemId();

        if(id==R.id.home)
        {
            return false;
        }
        if(id==R.id.set){
            Intent myintent=new Intent(Scientific.this,settinglayout.class);
            startActivity(myintent);

        }
        if (id==R.id.standard)
        {
            Intent myintent=new Intent(Scientific.this,MainActivity.class);
            startActivity(myintent);
        }
        return false;
    }

}
