package com.example.trudvsemapi.retrofit

import com.google.gson.annotations.SerializedName

data class Company(
    @SerializedName("name") val name: String,
    @SerializedName("email") val email: String?,
    val phone: String?

)

data class VacancyDetails(
    @SerializedName("company") val company: Company,
    @SerializedName("contact_list") val contactList: List<Contact>
)

data class Vacancy(
    @SerializedName("vacancy") val details: VacancyDetails
)

data class Results(
    val vacancies: List<Vacancy>
)

data class VacanciesResponse(
    val results: Results
)

data class Contact(
    @SerializedName("contact_type") val contactType: String,
    @SerializedName("contact_value") val contactValue: String
)