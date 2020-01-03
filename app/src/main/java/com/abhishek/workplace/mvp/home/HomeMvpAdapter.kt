package com.abhishek.workplace.mvp.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.abhishek.workplace.ApiClient.Response.PostResponse
import com.abhishek.workplace.R

class HomeMvpAdapter(val postArrayList: ArrayList<PostResponse>) :
    RecyclerView.Adapter<HomeMvpAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.post_layout, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
       return  postArrayList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(postArrayList[position])
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItems(post: PostResponse) {
            val tvPostName = itemView.findViewById(R.id.tvPostName) as TextView
            val tvPostId= itemView.findViewById(R.id.tvPostId) as TextView
            val tvPostDetail= itemView.findViewById(R.id.tvPostDetail) as TextView

            tvPostName.text = post.title
            tvPostId.text = post.userId
            tvPostDetail.text=post.body
        }
    }
}