package com.moapps.advicebestfriend.views.search

import android.app.ProgressDialog
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.moapps.advicebestfriend.R
import com.moapps.advicebestfriend.pojo.SearchAdvice
import com.moapps.advicebestfriend.pojo.SlipX
import kotlinx.android.synthetic.main.activity_search.*
import maes.tech.intentanim.CustomIntent
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class SearchActivity : AppCompatActivity(), ISearchAdvice, KodeinAware {
    lateinit var viewmodel: SearchViewModel
    lateinit var progressDialog: ProgressDialog
    lateinit var adapter: SearchAdapter
    override val kodein: Kodein by kodein()
    private val factory: SearchViewModelFactory by instance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        viewmodel = ViewModelProviders.of(this, factory).get(SearchViewModel::class.java)
        viewmodel.iSearchAdvice = this
        progressDialog = ProgressDialog(this)
        progressDialog.setCancelable(false)
        progressDialog.setCanceledOnTouchOutside(false)

        rv_search.layoutManager = LinearLayoutManager(this)
        adapter = SearchAdapter(this)

        search_btn_search.setOnClickListener {
            if (!search_text_search.text.isNullOrEmpty()) {
                viewmodel.getSearchAdvice(search_text_search.text.toString().trim())
            }
        }

    }

    override fun onStarted() {
        progressDialog.show()
    }

    override fun onSuccess(list: List<SlipX>) {
        progressDialog.dismiss()
        adapter.setData(list)
        error_text_search.visibility = View.GONE
        adapter.notifyDataSetChanged()
        rv_search.adapter = adapter
    }

    override fun onError(message: String?) {
        error_text_search.text = message
        error_text_search.visibility = View.VISIBLE
        progressDialog.dismiss()
    }

    override fun finish() {
        super.finish()
        CustomIntent.customType(this, "right-to-left")
    }
}