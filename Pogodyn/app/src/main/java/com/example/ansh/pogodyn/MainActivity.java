package com.example.ansh.pogodyn;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import com.example.ansh.pogodyn.models.AutoCompleteSearch.AutoCompleteSearchModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.app.PendingIntent.getActivity;

public class MainActivity extends AppCompatActivity {

    private String apikey = "jPRAPCFDpaLuWPCyCVdNH0ayBXziM7QS";

    private String hintsArray[];
    private HashMap<String, String> pairs;

    private AutoCompleteTextView textView;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hintsArray = new String[]{""};
        pairs = new HashMap<String, String>();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://dataservice.accuweather.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        final AccuService service = retrofit.create(AccuService.class);


        textView = (AutoCompleteTextView)findViewById(R.id.autocomplete);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, hintsArray);
        textView.setAdapter(adapter);

        textView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Log.d(textView.toString(), charSequence.toString());

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Log.d(textView.toString(), charSequence.toString());

                Call<List<AutoCompleteSearchModel>> response = service.loadCities(apikey, charSequence.toString());
                response.enqueue(new Callback<List<AutoCompleteSearchModel>>() {
                    @Override
                    public void onResponse(Call<List<AutoCompleteSearchModel>> call, Response<List<AutoCompleteSearchModel>> response) {
                        ArrayList<String> currentlist = new ArrayList<String>();

                        try {
                            for (AutoCompleteSearchModel a : response.body()) {
                                Log.d("Kolejny element odpowiedz", a.localizedName);
                                Log.d("Kolejny element odpowiedz", a.key);
                                pairs.put(a.localizedName, a.key);
                                currentlist.add(a.localizedName);
                            }
                        } catch (NullPointerException e){
                            Log.e("Error", e.toString());
                        }

                        ArrayAdapter<String> cityAdapter = new ArrayAdapter<String>(MainActivity.this,
                                android.R.layout.simple_dropdown_item_1line, currentlist.toArray(new String[currentlist.size()]));
                        textView.setAdapter(cityAdapter);
                    }

                    @Override
                    public void onFailure(Call<List<AutoCompleteSearchModel>> call, Throwable t) {
                        Log.d("PAWEL", t.toString());

                    }
                });

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        textView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                textView.showDropDown();
                return false;
            }
        });


        textView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, WeatherActivity.class);
                intent.putExtra("city", pairs.get(adapterView.getItemAtPosition(i).toString()));
                startActivity(intent);
            }
        });
    }

}
