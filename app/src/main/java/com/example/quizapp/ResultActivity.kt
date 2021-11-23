package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        tv_username.text = intent.getStringExtra(Constants.USER_NAME)
        tv_score.text = "You scored ${intent.getStringExtra(Constants.CORRECT_ANSWERS)} " +
                "out of ${intent.getStringExtra(Constants.TOTAL_QUESTIONS)}"
        btn_finish.setOnClickListener(){
            val finalIntent = Intent(this, MainActivity::class.java)
            startActivity(finalIntent)
            finish()
        }

    }
}