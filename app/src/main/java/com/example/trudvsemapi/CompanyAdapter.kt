package com.example.trudvsemapi

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

data class CompanyData(
    val name: String,
    val email: String?,
    val phone: String?
)

class CompanyAdapter(private val companies: List<CompanyData>) : RecyclerView.Adapter<CompanyAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val companyNameTextView: TextView = view.findViewById(R.id.companyNameTextView)
        val contactPhoneTextView: TextView = view.findViewById(R.id.contactPhoneTextView)
        val emailTextView: TextView = view.findViewById(R.id.emailTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_company, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val company = companies[position]
        holder.companyNameTextView.text = company.name
        holder.contactPhoneTextView.text = company.phone ?: "Нет телефона"
        holder.emailTextView.text = company.email ?: "Нет электронной почты"
    }

    override fun getItemCount(): Int {
        return companies.size
    }
}