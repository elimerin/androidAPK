package com.example.ansh.pogodyn;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private String apikey = "jPRAPCFDpaLuWPCyCVdNH0ayBXziM7QS";
    private String location;

    private Button button1;
    private TextView textView1;

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://dataservice.accuweather.com/")
            .build();

    AccuService service = retrofit.create(AccuService.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = (Button) this.findViewById(R.id.button);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        //editText1 = (EditText)this.findViewById(R.id.editText);
        String[] countries = getResources().getStringArray(R.array.countries_array);
        AutoCompleteTextView textView = (AutoCompleteTextView)findViewById(R.id.autocomplete);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, countries) //(this, android.R.layout.simple_dropdown_item_1line, service.loadCities(apikey, location));
        textView.setAdapter(adapter);

        });
    }

}
