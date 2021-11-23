package com.example.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_quiz_questions.*

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {
    private var mCurrentPosition: Int = 1
    private var mQuestionList: ArrayList<Question>? = null
    private var mSelectedOptionPosition: Int = 0
    private var mCorrectAnswers: Int = 0
    private var mUSER_NAME: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)
        mUSER_NAME = intent.getStringExtra(Constants.USER_NAME)

        mQuestionList = Constants.getQuestions()
        setQuestion()
        tv_option_one.setOnClickListener(this)
        tv_option_two.setOnClickListener(this)
        tv_option_three.setOnClickListener(this)
        tv_option_four.setOnClickListener(this)
        btn_submit.setOnClickListener(this)
    }

    private fun setQuestion(){
        val question : Question ? = mQuestionList!![mCurrentPosition-1]
        defaultOptionView()
        if (mCurrentPosition == mQuestionList!!.size){
            btn_submit.text = "Finish"
        }
        else{
            btn_submit.text = "SUBMIT"
        }
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

    private fun selectedOptionView(tv: TextView, selectedOptionNumber: Int){
        defaultOptionView()
        mSelectedOptionPosition = selectedOptionNumber
        tv.setTextColor((Color.parseColor("#363a43")))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(this,R.drawable.selected_option_border_bg)
    }

    private fun answerView(answer: Int, drawableView: Int){
        when(answer){
            1 -> {
                tv_option_one.background = ContextCompat.getDrawable(this, drawableView)
            }
            2 -> {
                tv_option_two.background = ContextCompat.getDrawable(this, drawableView)
            }
            3 -> {
                tv_option_three.background = ContextCompat.getDrawable(this, drawableView)
            }
            4 -> {
                tv_option_four.background = ContextCompat.getDrawable(this, drawableView)
            }
        }
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.tv_option_one -> {
                selectedOptionView(tv_option_one, 1)
            }
            R.id.tv_option_two -> {
                selectedOptionView(tv_option_two, 2)
            }
            R.id.tv_option_three -> {
                selectedOptionView(tv_option_three, 3)
            }
            R.id.tv_option_four -> {
                selectedOptionView(tv_option_four, 4)
            }
            R.id.btn_submit -> {
                if (mSelectedOptionPosition == 0){
                    mCurrentPosition++
                    when {
                        mCurrentPosition <= mQuestionList!!.size -> {
                            setQuestion()
                        }
                        else ->{
                            val intent = Intent(this, ResultActivity::class.java)
                            intent.putExtra(Constants.USER_NAME, mUSER_NAME)
                            intent.putExtra(Constants.TOTAL_QUESTIONS, mQuestionList!!.size)
                            intent.putExtra(Constants.CORRECT_ANSWERS, mCorrectAnswers)
                            startActivity(intent)
                            finish()
                        }
                    }
                }
                else{
                    val question = mQuestionList!![mCurrentPosition-1]
                    if(question!!.correctAnswer!=mSelectedOptionPosition){
                        answerView(mSelectedOptionPosition, R.drawable.wrong_option_border_bg)
                    }
                    else if (question!!.correctAnswer==mSelectedOptionPosition){
                        mCorrectAnswers++
                        print(mCorrectAnswers)
                        print(mCorrectAnswers)
                        print(mCorrectAnswers)
                        print(mCorrectAnswers)
                        print(mCorrectAnswers)
                        print(mCorrectAnswers)
                        print(mCorrectAnswers)

                    }
                    print(mCorrectAnswers)
                    answerView(question!!.correctAnswer, R.drawable.correct_option_border_bg)
                    if (mCurrentPosition == mQuestionList!!.size){
                        btn_submit.text = "Finish"
                    }
                    else{
                        btn_submit.text = "Go To Next Question"
                    }
                    mSelectedOptionPosition =0
                }
            }
        }
    }
}