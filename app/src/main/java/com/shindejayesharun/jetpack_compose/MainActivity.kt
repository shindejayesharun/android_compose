package com.shindejayesharun.jetpack_compose

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.shindejayesharun.jetpack_compose.examples.SimpleTextActivity
import com.shindejayesharun.jetpack_compose.examples.TextViewSampleActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun startSimpleText(view: View) {
        startActivity(Intent(this,SimpleTextActivity::class.java))
    }

    fun startTextViewExamples(view: View) {
        startActivity(Intent(this,TextViewSampleActivity::class.java))
    }
}