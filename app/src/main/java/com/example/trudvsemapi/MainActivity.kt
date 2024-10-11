package com.example.trudvsemapi

import android.annotation.SuppressLint
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.trudvsemapi.retrofit.VacanciesResponse

class MainActivity : AppCompatActivity() {

    private lateinit var companyAdapter: CompanyAdapter
    private var companyList: MutableList<CompanyData> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        companyAdapter = CompanyAdapter(companyList)
        recyclerView.adapter = companyAdapter
        fetchVacancies()
    }
    private fun fetchVacancies() {
        val call = RetrofitInstance.api.getVacancies()
        call.enqueue(object : Callback<VacanciesResponse> {
            @SuppressLint("NotifyDataSetChanged")
            override fun onResponse(call: Call<VacanciesResponse>, response: Response<VacanciesResponse>) {
                if (response.isSuccessful) {
                    companyList.clear()
                    response.body()?.let { vacanciesResponse ->
                        vacanciesResponse.results.vacancies.forEach { vacancy ->
                            val companyName = vacancy.details.company.name
                            val email = vacancy.details.company.email ?: "Нет электронной почты"
                            val phone = vacancy.details.contactList.find { it.contactType == "Телефон" }?.contactValue ?: "Нет телефона"
                            companyList.add(CompanyData(companyName, email, phone))
                        }
                    }
                    companyAdapter.notifyDataSetChanged()
                } else {
                    Log.e("Error", "Response not successful: ${response.message()}")
                }
            }
            override fun onFailure(call: Call<VacanciesResponse>, t: Throwable) {
                Log.e("Error", "Failed to fetch vacancies: ${t.message}")
            }
        })
    }
}