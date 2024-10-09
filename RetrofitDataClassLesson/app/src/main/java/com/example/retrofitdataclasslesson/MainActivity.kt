package com.example.retrofitdataclasslesson

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.retrofitdataclasslesson.databinding.ActivityMainBinding
import com.example.retrofitdataclasslesson.retrofit.MainApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.weatherapi.com/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        binding.request.setOnClickListener{
            CoroutineScope(Dispatchers.Main).launch {
                val api = retrofit.create(MainApi::class.java)
                val model = api.getWeatherData(
                    "ae045381363640449ba74747242109",
                    "London",
                    "3",
                    "no",
                    "no"
                )
                binding.temp.text = model.current.temp_c.toString()
                binding.date.text = model.location.name
            }
        }
    }
}