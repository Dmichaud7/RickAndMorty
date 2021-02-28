package com.example.rickandmorty

import android.util.Log
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.findNavController
import androidx.fragment.app.Fragment
import com.example.rickandmorty.GameFragment
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.fragment_game.*

class GameViewModel: ViewModel() {
    private lateinit var gameFragment: GameFragment

    private var _currentQuestions = MutableLiveData<Question>()
    val currentQuestions: LiveData<Question>
        get() = _currentQuestions

    private var _answerss = MutableLiveData<String>()
    val answerss: LiveData<String>
        get() = _answerss

    // The current score
    private val _score = MutableLiveData<Int>()
    val score: LiveData<Int>
        get() = _score

    private val _eventGameFinish = MutableLiveData<Boolean>()
    val eventGameFinish: LiveData<Boolean>
        get() = _eventGameFinish


    data class Question(
        val text: String,
        val answers: List<String>)


    private var questions: MutableList<Question> = mutableListOf(
        Question(text = "The Rick &amp; Morty That The Show Follows Are Originally From Dimension C-173",
            answers = listOf("true", "false")),
        Question(text = "Jerry\\'s Station Wagon Is Based On The Car From National Lampoon\\'s Vacation?",
            answers = listOf("true", "false")),
        Question(text = "Rick &amp; Morty Have Appeared In The Opening Title Screen Of The Simpsons?",
            answers = listOf("true", "false")),
        Question(text = "Jaguar From \\'Pickle Rick\\' Had His Own Spin Off Show With Adult Swim?",
            answers = listOf("true", "false")),
        Question(text = "Two Brothers\\' Is The First Show Rick &amp; Morty Watch On Inter-Dimensional Cable?",
            answers = listOf("true", "false")),
        Question(text = "According To Dan Harmon, A Schmeckle Is Worth \$148?",
            answers = listOf("true", "false")),
        Question(text = "When Bird-Person Is \\'Reborn\\' He Is Dubbed Phoenix-Bird?",
            answers = listOf("true", "false")),
        Question(text = "Doctor Neon Bloom Runs Anatomy Park?",
            answers = listOf("true", "false")),
        Question(text = "When Snuffles Is Able To Talk, He Changes His Name To Snowball?",
            answers = listOf("true", "false")),
        Question(text = "Wubba Lubba Dub Dub\" Means \\'Let\\'s Party\\'?",
            answers = listOf("true", "false")),
        Question(text = "Leading Up To The First Episode, Rick Had Left Beth And The Family For 10 Year",
            answers = listOf("true", "false")),
        Question(text = "In \\'Total Rickall\\', The Only Character That Isn\\'t A Parasite Is Pencilvester?",
            answers = listOf("true", "false")),
        Question(text = "Tammy Killed Bird-Person On Their Wedding Day?",
            answers = listOf("true", "false")),
        Question(text = "When Being Scammed By The Zigereons, Rick\\'s Safe Code Is \\'1-3-5-3\\'?",
            answers = listOf("true", "false")),
        Question(text = "Ice-T\\'s Real Name On Alphabetrium Was H2O-T?",
            answers = listOf("true", "false")),
        Question(text = "When Jerry &amp; Beth Split Up, Jerry Enters A Relationship With A Krootabulan?",
            answers = listOf("true", "false")),
        Question(text = "The Episode \\'Something Ricked This Way\\' Is A Parody Of An Edgar Allen Poe Poem",
            answers = listOf("true", "false")),
        Question(text = "Rick\\'s Hivemind Ex-Lover Is Called Purity?",
            answers = listOf("true", "false")),
        Question(text = "The Conjoint Twin That Simultaneously Host The News &amp;v A Cooking Show Are Calle Michael &amp; Pichael?",
            answers = listOf("true", "false")),

        )

        private fun resetQuestion(){
            questions = mutableListOf(
                Question(text = "The Rick &amp; Morty That The Show Follows Are Originally From Dimension C-173",
                    answers = listOf("false", "true")),
                Question(text = "Jerry\'s Station Wagon Is Based On The Car From National Lampoon\'s Vacation?",
                    answers = listOf("true", "false")),
                Question(text = "Rick &amp; Morty Have Appeared In The Opening Title Screen Of The Simpsons?",
                    answers = listOf("true", "false")),
                Question(text = "Jaguar From \'Pickle Rick\' Had His Own Spin Off Show With Adult Swim?",
                    answers = listOf("false", "true")),
                Question(text = "Two Brothers\' Is The First Show Rick &amp; Morty Watch On Inter-Dimensional Cable?",
                    answers = listOf("false", "true")),
                Question(text = "According To Dan Harmon, A Schmeckle Is Worth \$148?",
                    answers = listOf("true", "false")),
                Question(text = "The Bloomflark Is The Universal Currency For The Galactic Federation?",
                    answers = listOf("false", "true")),
                Question(text = "When Bird-Person Is \'Reborn\' He Is Dubbed Phoenix-Bird?",
                    answers = listOf("true", "false")),
                Question(text = "Doctor Neon Bloom Runs Anatomy Park?",
                    answers = listOf("false", "true")),
                Question(text = "When Snuffles Is Able To Talk, He Changes His Name To Snowball?",
                    answers = listOf("false", "true")),
                Question(text = "Wubba Lubba Dub Dub\" Means \'Let\'s Party\'?",
                    answers = listOf("false", "true")),
                Question(text = "Leading Up To The First Episode, Rick Had Left Beth And The Family For 10 Year",
                    answers = listOf("true", "false")),
                Question(text = "In \'Total Rickall\', The Only Character That Isn\'t A Parasite Is Pencilvester?",
                    answers = listOf("false", "true")),
                Question(text = "Tammy Killed Bird-Person On Their Wedding Day?",
                    answers = listOf("true", "false")),
                Question(text = "When Being Scammed By The Zigereons, Rick\'s Safe Code Is \'1-3-5-3\'?",
                    answers = listOf("true", "false")),
                Question(text = "Ice-T\'s Real Name On Alphabetrium Was H2O-T?",
                    answers = listOf("true", "false")),
                Question(text = "When Jerry &amp; Beth Split Up, Jerry Enters A Relationship With A Krootabulan?",
                    answers = listOf("true", "false")),
                Question(text = "The Episode \'Something Ricked This Way\' Is A Parody Of An Edgar Allen Poe Poem",
                    answers = listOf("false", "true")),
                Question(text = "Rick\\'s Hivemind Ex-Lover Is Called Purity?",
                    answers = listOf("false", "true")),
                Question(text = "The Conjoint Twin That Simultaneously Host The News &amp;v A Cooking Show Are Calle Michael &amp; Pichael?",
                    answers = listOf("true", "false")),

                )

            questions.shuffle()
        }

    init{
        _score.value = 0
        resetQuestion()
        randomizeQuestions()

    }

    lateinit var currentQuestion: Question
    lateinit var answers: MutableList<String>
    private var questionIndex = 0
    private val numQuestions = 3

    override fun onCleared() {
        super.onCleared()
        Log.i("GameViewModel", "GameViewModel destroyed!")
    }

     fun nextQuestion(){
//        val radio: Int  =  gameFragment.radio
            var radio = 1
//         radio = gameFragment.questionRadioGroup.checkedRadioButtonId

        if (-1 != radio) {
            var answerIndex = 0
            when (radio) {
                R.id.secondAnswerRadioButton -> answerIndex = 1

            }

            if (answers[answerIndex] == currentQuestion.answers[0]) {
                _score.value = (_score.value)?.plus(1)
                questionIndex++

                // Advance to the next question
                if (questionIndex < numQuestions) {
                    currentQuestion = questions[questionIndex]
                    setQuestion()

                }
            }else{
//                _score.value = (_score.value)?.minus(1)
                questionIndex++

                if (questionIndex < numQuestions) {
                    currentQuestion = questions[questionIndex]
                    setQuestion()
                }

            }
        }

         if(questionIndex == 3){
             onGameFinish()
         }

    }

    private fun setQuestion() {
        currentQuestion = questions[questionIndex]

        _currentQuestions.value = currentQuestion
        // randomize the answers into a copy of the array
        answers = currentQuestion.answers.toMutableList()

        _answerss.value = answers.toString()


    }

    private fun randomizeQuestions() {
        questions.shuffle()
        questionIndex = 0
        setQuestion()
    }

    fun onGameFinishComplete() {
        _eventGameFinish.value = false
    }

    fun onGameFinish() {
        _eventGameFinish.value = true
    }

}
