package com.moapps.advicebestfriend.views.random

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.moapps.advicebestfriend.R
import kotlinx.android.synthetic.main.activity_random.*
import maes.tech.intentanim.CustomIntent
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class RandomActivity : AppCompatActivity(), IRandomAdvice, KodeinAware {
    lateinit var viewModel: RandomViewModel
    override val kodein: Kodein by kodein()
    private val factory:RandomViewModelFactory by instance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_random)
        viewModel = ViewModelProviders.of(this,factory).get(RandomViewModel::class.java)
        viewModel.iRandomAdvice = this
        viewModel.getRandomAdvice()

        hideSystemUI(this)

        thanks_btn.setOnClickListener {
            finish()
        }


    }

    private fun hideSystemUI(activity: Activity) {
        val decorView = activity.window.decorView
        decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN //| View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                //| View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_FULLSCREEN // hide status bar
                or View.SYSTEM_UI_FLAG_IMMERSIVE)
    }

    override fun onSuccess(advice: String?) {
        advice_text.text = advice
        progress_bar_layout.visibility = View.GONE
    }

    override fun onError(message: String?) {
        error_text.text = message
        error_layout.visibility = View.VISIBLE
        progress_bar_layout.visibility = View.GONE

    }

    override fun finish() {
        super.finish()
        CustomIntent.customType(this, "right-to-left")
    }

}