package com.example.quizapp

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_quiz_questions.*

class QuizQuestionsActivity : AppCompatActivity() {
    private var mCurrentPosition: Int = 1
    private var mQuestionList: ArrayList<Question>? = null
    private var mSelectedOptionPosition: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)
        mQuestionList = Constants.getQuestions()
        setQuestion()
    }

    private fun setQuestion(){
        mCurrentPosition = 1
        val question : Question ? = mQuestionList!![mCurrentPosition-1]
        defaultOptionView()
        progress_bar.progress = mCurrentPosition
        tv_progress.text = "$mCurrentPosition" + "/" + "${progress_bar.max}"
        tv_question.text = question!!.question
        tv_option_one.text = question!!.optionOne
        tv_option_two.text = question!!.optionTwo
        tv_option_three.text = question!!.optionThree
        tv_option_four.text = question!!.optionFour
        iv_image.setImageResource(question!!.image)
    }

    private fun defaultOptionView(){
        val optionArray = ArrayList<TextView>()
        optionArray.add(tv_option_one)
        optionArray.add(tv_option_two)
        optionArray.add(tv_option_three)
        optionArray.add(tv_option_four)

        for (option in optionArray){
            option.setTextColor((Color.parseColor("#7a8089")))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this,R.drawable.default_option_border_bg)
        }
    }
}