package com.example.ansh.pogodyn;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ansh.pogodyn.models.Weather.WeatherModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class WeatherActivity extends AppCompatActivity {

    private String apikey = "jPRAPCFDpaLuWPCyCVdNH0ayBXziM7QS";
    private String language = "pl";
    private String details = "false";
    private String metric = "true";
    private TextView tvCity;
    private TextView tvDate;
    private TextView tvTemperature;
    private TextView tvDescription;
    private ImageView ivIcon;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        tvCity = (TextView)this.findViewById(R.id.textViewCity);
        tvDate = (TextView)this.findViewById(R.id.textViewDate);
        tvTemperature = (TextView)this.findViewById(R.id.textViewTemp);
        tvDescription = (TextView)this.findViewById(R.id.textViewDesc);
        ivIcon = (ImageView)this.findViewById(R.id.imageViewIcon);

        String city = getIntent().getStringExtra("city");
        final String cityName = getIntent().getStringExtra("cityName");

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://dataservice.accuweather.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        final AccuService service = retrofit.create(AccuService.class);

        Call<WeatherModel> response = service.getWeather(city, apikey, language, details, metric);

        response.enqueue(new Callback<WeatherModel>() {
            @Override
            public void onResponse(Call<WeatherModel> call, Response<WeatherModel> response) {
                Log.d("response", response.body().headline.text.toString());
                //@ToDo generate view
                tvCity.setText(cityName);
                tvDate.setText(response.body().dailyForecasts.get(0).date);
                tvTemperature.setText("Temperatura:   minimalna: " + Integer.toString(response.body().dailyForecasts.get(0).temperature.minimum.value) + "   maksymalna: " + Integer.toString(response.body().dailyForecasts.get(0).temperature.maximum.value));
                tvDescription.setText("Pogoda w dzień: " + response.body().dailyForecasts.get(0).day.iconPhrase + '\n' + "Pogoda w nocy: " + response.body().dailyForecasts.get(0).night.iconPhrase);

                if (response.body().dailyForecasts.get(0).day.icon == 1){
                    ivIcon.setImageDrawable(getResources().getDrawable(R.drawable.one));
                }
                else if (response.body().dailyForecasts.get(0).day.icon == 2){
                    ivIcon.setImageDrawable(getResources().getDrawable(R.drawable.two));
                }
                else if (response.body().dailyForecasts.get(0).day.icon == 3){
                    ivIcon.setImageDrawable(getResources().getDrawable(R.drawable.three));
                }
                else if (response.body().dailyForecasts.get(0).day.icon == 4){
                    ivIcon.setImageDrawable(getResources().getDrawable(R.drawable.four));
                }
                else if (response.body().dailyForecasts.get(0).day.icon == 5){
                    ivIcon.setImageDrawable(getResources().getDrawable(R.drawable.five));
                }
                else if (response.body().dailyForecasts.get(0).day.icon == 6){
                    ivIcon.setImageDrawable(getResources().getDrawable(R.drawable.six));
                }
                else if (response.body().dailyForecasts.get(0).day.icon == 7){
                    ivIcon.setImageDrawable(getResources().getDrawable(R.drawable.seven));
                }
                else if (response.body().dailyForecasts.get(0).day.icon == 8){
                    ivIcon.setImageDrawable(getResources().getDrawable(R.drawable.eight));
                }
                else if (response.body().dailyForecasts.get(0).day.icon == 11){
                    ivIcon.setImageDrawable(getResources().getDrawable(R.drawable.eleven));
                }
                else if (response.body().dailyForecasts.get(0).day.icon == 12){
                    ivIcon.setImageDrawable(getResources().getDrawable(R.drawable.twelve));
                }
                else if (response.body().dailyForecasts.get(0).day.icon == 13){
                    ivIcon.setImageDrawable(getResources().getDrawable(R.drawable.thirteen));
                }
                else if (response.body().dailyForecasts.get(0).day.icon == 14){
                    ivIcon.setImageDrawable(getResources().getDrawable(R.drawable.fourteen));
                }
                else if (response.body().dailyForecasts.get(0).day.icon == 15){
                    ivIcon.setImageDrawable(getResources().getDrawable(R.drawable.fiveteen));
                }
                else if (response.body().dailyForecasts.get(0).day.icon == 16){
                    ivIcon.setImageDrawable(getResources().getDrawable(R.drawable.sixteen));
                }
                else if (response.body().dailyForecasts.get(0).day.icon == 17){
                    ivIcon.setImageDrawable(getResources().getDrawable(R.drawable.seventeen));
                }
                else if (response.body().dailyForecasts.get(0).day.icon == 18){
                    ivIcon.setImageDrawable(getResources().getDrawable(R.drawable.eighteen));
                }
                else if (response.body().dailyForecasts.get(0).day.icon == 19){
                    ivIcon.setImageDrawable(getResources().getDrawable(R.drawable.nineteen));
                }
                else if (response.body().dailyForecasts.get(0).day.icon == 20){
                    ivIcon.setImageDrawable(getResources().getDrawable(R.drawable.twenty));
                }
                else if (response.body().dailyForecasts.get(0).day.icon == 21){
                    ivIcon.setImageDrawable(getResources().getDrawable(R.drawable.twentyone));
                }
                else if (response.body().dailyForecasts.get(0).day.icon == 22){
                    ivIcon.setImageDrawable(getResources().getDrawable(R.drawable.twentytwo));
                }
                else if (response.body().dailyForecasts.get(0).day.icon == 23){
                    ivIcon.setImageDrawable(getResources().getDrawable(R.drawable.twentythree));
                }
                else if (response.body().dailyForecasts.get(0).day.icon == 24){
                    ivIcon.setImageDrawable(getResources().getDrawable(R.drawable.twentyfour));
                }
                else if (response.body().dailyForecasts.get(0).day.icon == 25){
                    ivIcon.setImageDrawable(getResources().getDrawable(R.drawable.twentyfive));
                }
                else if (response.body().dailyForecasts.get(0).day.icon == 26){
                    ivIcon.setImageDrawable(getResources().getDrawable(R.drawable.twentysix));
                }
                else if (response.body().dailyForecasts.get(0).day.icon == 29){
                    ivIcon.setImageDrawable(getResources().getDrawable(R.drawable.twentynine));
                }
                else if (response.body().dailyForecasts.get(0).day.icon == 30){
                    ivIcon.setImageDrawable(getResources().getDrawable(R.drawable.thirty));
                }
                else if (response.body().dailyForecasts.get(0).day.icon == 31){
                    ivIcon.setImageDrawable(getResources().getDrawable(R.drawable.thirtyone));
                }
                else if (response.body().dailyForecasts.get(0).day.icon == 32){
                    ivIcon.setImageDrawable(getResources().getDrawable(R.drawable.thirtytwo));
                }
                else if (response.body().dailyForecasts.get(0).day.icon == 33){
                    ivIcon.setImageDrawable(getResources().getDrawable(R.drawable.thirtythree));
                }
                else if (response.body().dailyForecasts.get(0).day.icon == 34){
                    ivIcon.setImageDrawable(getResources().getDrawable(R.drawable.thirtyfour));
                }
                else if (response.body().dailyForecasts.get(0).day.icon == 35){
                    ivIcon.setImageDrawable(getResources().getDrawable(R.drawable.thirtyfive));
                }
                else if (response.body().dailyForecasts.get(0).day.icon == 36){
                    ivIcon.setImageDrawable(getResources().getDrawable(R.drawable.thirtysix));
                }
                else if (response.body().dailyForecasts.get(0).day.icon == 37){
                    ivIcon.setImageDrawable(getResources().getDrawable(R.drawable.thirtyseven));
                }
                else if (response.body().dailyForecasts.get(0).day.icon == 38){
                    ivIcon.setImageDrawable(getResources().getDrawable(R.drawable.thirtyeight));
                }
                else if (response.body().dailyForecasts.get(0).day.icon == 39){
                    ivIcon.setImageDrawable(getResources().getDrawable(R.drawable.thirtynine));
                }
                else if (response.body().dailyForecasts.get(0).day.icon == 40){
                    ivIcon.setImageDrawable(getResources().getDrawable(R.drawable.fourty));
                }
                else if (response.body().dailyForecasts.get(0).day.icon == 41){
                    ivIcon.setImageDrawable(getResources().getDrawable(R.drawable.fourtyone));
                }
                else if (response.body().dailyForecasts.get(0).day.icon == 42){
                    ivIcon.setImageDrawable(getResources().getDrawable(R.drawable.fourtytwo));
                }
                else if (response.body().dailyForecasts.get(0).day.icon == 43){
                    ivIcon.setImageDrawable(getResources().getDrawable(R.drawable.fourtythree));
                }
                else if (response.body().dailyForecasts.get(0).day.icon == 44){
                    ivIcon.setImageDrawable(getResources().getDrawable(R.drawable.fourtyfour));
                }

            }

            @Override
            public void onFailure(Call<WeatherModel> call, Throwable t) {

            }
        });
    }
}
