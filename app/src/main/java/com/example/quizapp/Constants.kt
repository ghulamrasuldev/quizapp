package com.example.quizapp

object Constants {
    fun getQuestions(): ArrayList<Question>{
        val QuestionsList = ArrayList<Question>()
        val q1 = Question(1, "What Country this Flag Belong to?", R.drawable.ic_flag_of_argentina,
                "Pakistan", "India", "Denmark", "Argentina", 4)
        val q2 = Question(1, "What Country this Flag Belong to?", R.drawable.ic_flag_of_australia,
            "Belgium", "India", "Australia", "Argentina", 3)
        val q3 = Question(1, "What Country this Flag Belong to?", R.drawable.ic_flag_of_belgium,
            "Pakistan", "Belgium", "Australia", "Argentina", 2)
        val q4 = Question(1, "What Country this Flag Belong to?", R.drawable.ic_flag_of_brazil,
            "Africa", "India", "Brazil", "Argentina", 3)
        val q5 = Question(1, "What Country this Flag Belong to?", R.drawable.ic_flag_of_denmark,
            "America", "Fiji", "Uniked Kingdom", "Denmark", 4)
        val q6 = Question(1, "What Country this Flag Belong to?", R.drawable.ic_flag_of_fiji,
            "Scotland", "Afghanistan", "Australia", "Fiji", 4)
        val q7 = Question(1, "What Country this Flag Belong to?", R.drawable.ic_flag_of_germany,
            "Austria", "Germany", "India", "Pakistan", 2)
        val q8 = Question(1, "What Country this Flag Belong to?", R.drawable.ic_flag_of_india,
            "Pakistan", "India", "Australia", "Argentina", 2)
        val q9 = Question(1, "What Country this Flag Belong to?", R.drawable.ic_flag_of_kuwait,
            "Kuwait", "Saudi Arabia", "Iraq", "Iran", 1)

        QuestionsList.add(q1)
        QuestionsList.add(q2)
        QuestionsList.add(q3)
        QuestionsList.add(q4)
        QuestionsList.add(q5)
        QuestionsList.add(q6)
        QuestionsList.add(q7)
        QuestionsList.add(q8)
        QuestionsList.add(q9)
        return QuestionsList
    }
}