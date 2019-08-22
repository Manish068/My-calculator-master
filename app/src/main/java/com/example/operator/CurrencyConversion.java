package com.example.operator;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethod;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CurrencyConversion extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

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
    private Button AC;
    private Button dot;
    private ImageButton Backspace;
    private EditText et1;
    private TextView value, rate;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle stoggle;
    SharedPref sharedpref;
    private Spinner spin1, spin2;
    private String curfrom, curto;
    Double number;
    JsonPlaceHolderApi jsonPlaceHolderApi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        sharedpref = new SharedPref(this);
        if (sharedpref.loadNightModeState() == true) {
            setTheme(R.style.LightTheme);
        } else setTheme(R.style.DarkTheme);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency_conversion);


        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawercur);
        zero0 = (Button) findViewById(R.id.c0);
        one1 = (Button) findViewById(R.id.c1);
        two2 = (Button) findViewById(R.id.c2);
        three3 = (Button) findViewById(R.id.c3);
        four4 = (Button) findViewById(R.id.c4);
        five5 = (Button) findViewById(R.id.c5);
        six6 = (Button) findViewById(R.id.c6);
        seven7 = (Button) findViewById(R.id.c7);
        eight8 = (Button) findViewById(R.id.c8);
        nine9 = (Button) findViewById(R.id.c9);
        AC = (Button) findViewById(R.id.cAC);
        Backspace = (ImageButton) findViewById(R.id.cimgbtn);
        et1 = (EditText) findViewById(R.id.et1);
        rate = (TextView) findViewById(R.id.Rate);
        value = (TextView) findViewById(R.id.value);
        spin1 = (Spinner) findViewById(R.id.spinfrom);
        spin2 = (Spinner) findViewById(R.id.spinto);
        dot= (Button) findViewById(R.id.cdot);

        rate.setText("0");
        et1.setText("0");
        value.setText("0");

        stoggle = new ActionBarDrawerToggle(CurrencyConversion.this, mDrawerLayout, R.string.open, R.string.close);
        mDrawerLayout.addDrawerListener(stoggle);
        stoggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://rate-exchange-1.appspot.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Curren, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spin1.setAdapter(adapter);
        spin2.setAdapter(adapter);

        spin1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        zero0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (et1.getText().toString().equals("0")) {
                    et1.setText("0");
                    rate.setText("0");
                } else {
                    et1.setText(et1.getText() + "0");
                    et1.setSelection(et1.getText().length());
                    number = Double.parseDouble(et1.getText().toString());
                    curfrom = spin1.getSelectedItem().toString();
                    curto = spin2.getSelectedItem().toString();
                    getCurrency(curfrom, curto, number);
                }
            }
        });

        one1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (et1.getText().toString().equals("0")) {
                    et1.setText("1");
                    et1.setSelection(et1.getText().length());
                    number = Double.parseDouble(et1.getText().toString());
                    curfrom = spin1.getSelectedItem().toString();
                    curto = spin2.getSelectedItem().toString();
                    getCurrency(curfrom, curto, number);
                } else {
                    et1.setText(et1.getText() + "1");
                    et1.setSelection(et1.getText().length());
                    number = Double.parseDouble(et1.getText().toString());
                    curfrom = spin1.getSelectedItem().toString();
                    curto = spin2.getSelectedItem().toString();
                    getCurrency(curfrom, curto, number);
                }

            }
        });

        two2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (et1.getText().toString().equals("0")) {
                    et1.setText("2");
                    et1.setSelection(et1.getText().length());
                    number = Double.parseDouble(et1.getText().toString());
                    curfrom = spin1.getSelectedItem().toString();
                    curto = spin2.getSelectedItem().toString();
                    getCurrency(curfrom, curto, number);
                } else {
                    et1.setText(et1.getText() + "2");
                    et1.setSelection(et1.getText().length());
                    number = Double.parseDouble(et1.getText().toString());
                    curfrom = spin1.getSelectedItem().toString();
                    curto = spin2.getSelectedItem().toString();
                    getCurrency(curfrom, curto, number);
                }
            }
        });

        three3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (et1.getText().toString().equals("0")) {
                    et1.setText("3");
                    et1.setSelection(et1.getText().length());
                    number = Double.parseDouble(et1.getText().toString());
                    curfrom = spin1.getSelectedItem().toString();
                    curto = spin2.getSelectedItem().toString();
                    getCurrency(curfrom, curto, number);
                } else {
                    et1.setText(et1.getText() + "3");
                    et1.setSelection(et1.getText().length());
                    number = Double.parseDouble(et1.getText().toString());
                    curfrom = spin1.getSelectedItem().toString();
                    curto = spin2.getSelectedItem().toString();
                    getCurrency(curfrom, curto, number);
                }
            }
        });

        four4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (et1.getText().toString().equals("0")) {
                    et1.setText("4");
                    et1.setSelection(et1.getText().length());
                    number = Double.parseDouble(et1.getText().toString());
                    curfrom = spin1.getSelectedItem().toString();
                    curto = spin2.getSelectedItem().toString();
                    getCurrency(curfrom, curto, number);
                } else {
                    et1.setText(et1.getText() + "4");
                    et1.setSelection(et1.getText().length());
                    number = Double.parseDouble(et1.getText().toString());
                    curfrom = spin1.getSelectedItem().toString();
                    curto = spin2.getSelectedItem().toString();
                    getCurrency(curfrom, curto, number);
                }
            }
        });

        five5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (et1.getText().toString().equals("0")) {
                    et1.setText("5");
                    et1.setSelection(et1.getText().length());
                    number = Double.parseDouble(et1.getText().toString());
                    curfrom = spin1.getSelectedItem().toString();
                    curto = spin2.getSelectedItem().toString();
                    getCurrency(curfrom, curto, number);
                } else {
                    et1.setText(et1.getText() + "5");
                    et1.setSelection(et1.getText().length());
                    number = Double.parseDouble(et1.getText().toString());
                    curfrom = spin1.getSelectedItem().toString();
                    curto = spin2.getSelectedItem().toString();
                    getCurrency(curfrom, curto, number);
                }
            }
        });

        six6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (et1.getText().toString().equals("0")) {
                    et1.setText("6");
                    et1.setSelection(et1.getText().length());
                    number = Double.parseDouble(et1.getText().toString());
                    curfrom = spin1.getSelectedItem().toString();
                    curto = spin2.getSelectedItem().toString();
                    getCurrency(curfrom, curto, number);
                } else {
                    et1.setText(et1.getText() + "6");
                    et1.setSelection(et1.getText().length());
                    number = Double.parseDouble(et1.getText().toString());
                    curfrom = spin1.getSelectedItem().toString();
                    curto = spin2.getSelectedItem().toString();
                    getCurrency(curfrom, curto, number);
                }
            }
        });

        seven7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (et1.getText().toString().equals("0")) {
                    et1.setText("7");
                    et1.setSelection(et1.getText().length());
                    number = Double.parseDouble(et1.getText().toString());
                    curfrom = spin1.getSelectedItem().toString();
                    curto = spin2.getSelectedItem().toString();
                    getCurrency(curfrom, curto, number);
                } else {
                    et1.setText(et1.getText() + "7");
                    et1.setSelection(et1.getText().length());
                    number = Double.parseDouble(et1.getText().toString());
                    curfrom = spin1.getSelectedItem().toString();
                    curto = spin2.getSelectedItem().toString();
                    getCurrency(curfrom, curto, number);
                }
            }
        });
        eight8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (et1.getText().toString().equals("0")) {
                    et1.setText("8");
                    et1.setSelection(et1.getText().length());
                    number = Double.parseDouble(et1.getText().toString());
                    curfrom = spin1.getSelectedItem().toString();
                    curto = spin2.getSelectedItem().toString();
                    getCurrency(curfrom, curto, number);
                } else {
                    et1.setText(et1.getText() + "8");
                    et1.setSelection(et1.getText().length());
                    number = Double.parseDouble(et1.getText().toString());
                    curfrom = spin1.getSelectedItem().toString();
                    curto = spin2.getSelectedItem().toString();
                    getCurrency(curfrom, curto, number);
                }
            }
        });

        nine9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (et1.getText().toString().equals("0")) {
                    et1.setText("9");
                    et1.setSelection(et1.getText().length());
                    number = Double.parseDouble(et1.getText().toString());
                    curfrom = spin1.getSelectedItem().toString();
                    curto = spin2.getSelectedItem().toString();
                    getCurrency(curfrom, curto, number);
                } else {
                    et1.setText(et1.getText() + "9");
                    et1.setSelection(et1.getText().length());
                    number = Double.parseDouble(et1.getText().toString());
                    curfrom = spin1.getSelectedItem().toString();
                    curto = spin2.getSelectedItem().toString();
                    getCurrency(curfrom, curto, number);
                }
            }
        });

        AC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et1.setText("0");
                rate.setText("0");
                value.setText("0");
            }
        });

        Backspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = et1.getText().toString();
                if (et1.length() == 1) {
                    et1.setText("0");
                    rate.setText("0");
                    value.setText("0");
                } else {
                    et1.setText(text.substring(0, text.length() - 1));
                    number = Double.parseDouble(et1.getText().toString());
                    curfrom = spin1.getSelectedItem().toString();
                    curto = spin2.getSelectedItem().toString();
                    getCurrency(curfrom, curto, number);
                }
            }
        });

        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (et1.getText().toString().equals("0")) {
                    et1.setText("0.");
                    et1.setSelection(et1.getText().length());
                    number = Double.parseDouble(et1.getText().toString());
                    //curfrom = spin1.getSelectedItem().toString();
                    //curto = spin2.getSelectedItem().toString();
                    //getCurrency(curfrom, curto, number);
                } else {
                    et1.setText(et1.getText() + ".");
                    et1.setSelection(et1.getText().length());
                    number = Double.parseDouble(et1.getText().toString());
                    curfrom = spin1.getSelectedItem().toString();
                    curto = spin2.getSelectedItem().toString();
                    getCurrency(curfrom, curto, number);
                }

            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (stoggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id = menuItem.getItemId();

        if (id == R.id.home) {
            Intent myintent = new Intent(CurrencyConversion.this, Scientific.class);
            startActivity(myintent);
            return false;

        }
        if (id == R.id.set) {
            Intent myintent = new Intent(CurrencyConversion.this, settinglayout.class);
            startActivity(myintent);
            return false;

        }
        if (id == R.id.standard) {
            Intent myintent = new Intent(CurrencyConversion.this, MainActivity.class);
            startActivity(myintent);
            return false;
        }
        if (id == R.id.Curr) {
            return false;
        }
        return false;
    }

    private void getCurrency(String curfrom, String curto, Double number) {
        Call<Curr> call = jsonPlaceHolderApi.getCurrency(curfrom, curto, number);

        call.enqueue(new Callback<Curr>() {
            @Override
            public void onResponse(Call<Curr> call, Response<Curr> response) {
                if (!response.isSuccessful()) {
                    value.setText("code:" + response.code());
                    return;
                }

                rate.setText(response.body().getRate() + "");
                value.setText(response.body().getV() + "");

            }

            @Override
            public void onFailure(Call<Curr> call, Throwable t) {
                value.setText(t.getMessage());

            }
        });
    }
}
