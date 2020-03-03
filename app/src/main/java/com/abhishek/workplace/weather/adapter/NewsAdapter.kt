package com.abhishek.workplace.weather.adapter

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.abhishek.workplace.ApiClient.Response.Article
import com.abhishek.workplace.ApiClient.Response.PostResponse
import com.abhishek.workplace.R
import com.abhishek.workplace.mvp.home.HomeMvpAdapter
import com.bumptech.glide.Glide

class NewsAdapter(val articleArrayList: ArrayList<Article>,val context:Activity) :
    RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val v = LayoutInflater.from(parent.context).inflate(R.layout.news_row_layout, parent, false)
            return ViewHolder(v)
 }

    override fun getItemCount(): Int {
        return articleArrayList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        holder.bindItems(articleArrayList[position])
        holder!!.newsTittle.text = articleArrayList[position].title
        holder!!.newsDetail.text = articleArrayList[position].description

        Glide.with(context).load(articleArrayList[position].urlToImage)
            .into(holder.ivNews)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val newsTittle = itemView.findViewById(R.id.newsTittle) as TextView
        val newsDetail= itemView.findViewById(R.id.newsDetail) as TextView
        val ivNews= itemView.findViewById(R.id.ivNews) as ImageView

    }
}