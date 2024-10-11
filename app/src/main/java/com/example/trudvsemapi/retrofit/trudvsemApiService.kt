package com.example.trudvsemapi.retrofit

import retrofit2.Call
import retrofit2.http.GET

interface trudvsemApiService {
    @GET("vacancies")
    fun getVacancies(): Call<VacanciesResponse>
}