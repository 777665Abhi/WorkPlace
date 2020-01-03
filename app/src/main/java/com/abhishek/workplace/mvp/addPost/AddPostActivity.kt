package com.abhishek.workplace.mvp.addPost

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.abhishek.workplace.ApiClient.Response.PostResponse
import com.abhishek.workplace.R
import kotlinx.android.synthetic.main.activity_add_post.*

class AddPostActivity : AppCompatActivity(), AddPostView {


    var addPostPresenter: AddPostPresenter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_post)

        addPostPresenter = AddPostPresenter(this, AddPostInteractor())
        bnPost.setOnClickListener(View.OnClickListener {
            showProgress()
            addPostPresenter!!.addPostPre(etPost.text.toString())
        })
    }


    override fun addPostSuccess(msg: String) {
        hideProgress()
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show()
        onBackPressed()
    }


    override fun showProgress() {
        progress.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        progress.visibility = View.GONE

    }


    override fun showToast(msg: String) {
        hideProgress()
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}
