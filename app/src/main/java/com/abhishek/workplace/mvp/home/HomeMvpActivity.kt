package com.abhishek.workplace.mvp.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.abhishek.workplace.ApiClient.Response.PostResponse
import com.abhishek.workplace.R
import com.abhishek.workplace.Utils
import com.abhishek.workplace.mvp.addPost.AddPostActivity
import kotlinx.android.synthetic.main.activity_home.*

class HomeMvpActivity : AppCompatActivity(), HomeMvpView {


    var homePresenter: HomePresenter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        homePresenter = HomePresenter(this, HomeMvpInteractor())
        getData()

        fabAdd.setOnClickListener(View.OnClickListener {
            Utils.moveNextScreen(this,AddPostActivity::class.java)
        })

    }

    fun getData() {
        homePresenter!!.getDataPresenter()
    }

    override fun showProgress() {
        progress.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        progress.visibility = View.GONE
    }

    override fun showToast(msg: String) {
        Toast.makeText(this, "msg", Toast.LENGTH_SHORT).show()
    }

    override fun displayData(postArray: ArrayList<PostResponse>) {
        val homeMvpAdapter = HomeMvpAdapter(postArray)

        rvPost.adapter = homeMvpAdapter
        rvPost.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
    }
}
