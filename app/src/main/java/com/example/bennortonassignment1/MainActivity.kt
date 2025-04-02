package com.example.bennortonassignment1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // declaring my layout variables:
        val timeOfDayInput: EditText = findViewById(R.id.dayTimeInput)
        val enterTimeOfDayButton: Button = findViewById(R.id.enterDayTime)
        val mealSuggestionDisplay: TextView = findViewById(R.id.mealSuggestion)
        val resetButton: Button = findViewById(R.id.resetButton)
        var suggestionToDisplay = ""

        // button so that we can enter the time of day and trigger our logic
        // to decide what our friend is going to eat
        enterTimeOfDayButton.setOnClickListener{
            var timeOfDay = timeOfDayInput.text.toString()
            // first we check to see if they have pressed the button without pressing anything
            if(timeOfDay.isEmpty()){
                suggestionToDisplay = GetTimeOfDaySuggestion()
            }

            // then we check to see if it matches any of the timesOfDay
            var isValidTimeOfDay = CheckTimeOfDayIsValid(timeOfDay)

            // if it is a valid time of the day then we can go and select out meals
            // depending on the time of day
            if(isValidTimeOfDay){
                // ok so now the user has entered the valid time of day we just need to build a function
                // that will give us our fresh meals depending on the timeOfDay
                suggestionToDisplay = GetDelciousMealSuggestion(timeOfDay)
            } else{
                // else we display the hint again
                suggestionToDisplay = GetTimeOfDaySuggestion()
            }

            // finally show the text to display in the mealSuggestionDisplay
            mealSuggestionDisplay.text = suggestionToDisplay
        }


        // reset button clicking functionality:
        resetButton.setOnClickListener{
            // in here we need to get the text values from both the dayTimeinput field and the mealSuggestionDisplay field
            var mealSuggestion = mealSuggestionDisplay.text.toString()
            var mealSuggestionPlaceHolder = "Chef yes Chef"

            var dayTimeInput = timeOfDayInput.text.toString()
            var dayTimePlaceHolder = "Enter the time of Day"

            // check to see if the mealSuggestion text = "Chef yes Chef" (placeholder value)
            // if it does then leave it
            // else reset it back to "Chef yes Chef"
            if(mealSuggestion != mealSuggestionPlaceHolder){
                // reset mealSuggestionDisplay.text to placeholder
                mealSuggestionDisplay.setText(mealSuggestionPlaceHolder) // this is a TextView element
            }

            // check to see if the dayTimeInput is also placeholder value
            // if it does then we can leave it
            // else reset it back to the placeholder value
            if(dayTimeInput != dayTimePlaceHolder){
                timeOfDayInput.setText(dayTimePlaceHolder) // this is an EditText element
            }
        }
    }

    // functions and variables to use for the logic to keep things neat :) (delcared globally)
    // I have delcared them in the order that they are used in the onCreate function above

    var timesOfDay = arrayOf("Morning", "Mid-morning", "Afternoon", "Mid-Afternoon", "Dinner")

    // function to dislay a hint string if the timeOfDay input is null/empty
    fun GetTimeOfDaySuggestion(): String{
        val suggestion = "Someone's hungry, please enter the time of day for your meal prep\n" +
                "Time of day to enter:\n" +
                "${timesOfDay[0]}\n" +
                "${timesOfDay[1]}\n" +
                "${timesOfDay[2]}\n" +
                "${timesOfDay[3]}\n" +
                "${timesOfDay[4]}"
        return suggestion
    }

    fun CheckTimeOfDayIsValid(dayTimeEntered: String): Boolean {
        var isValidTimeOfDay = false
        var timeEnteredLowerCase = dayTimeEntered.lowercase()

        // checking to see if our timeOfDay matches any of the timesOfDay we can allow
        for(timeOfDay in timesOfDay){
            // if it matches the times we allow then we can say it's valid
            if(timeEnteredLowerCase == timeOfDay.lowercase() ){
                return true;
            }
        }

        // else, if it does not match then we return false
        return isValidTimeOfDay
    }

    // function to get the meal suggestions
    fun GetDelciousMealSuggestion(dayTimeEntered: String): String{
        var mealSuggestion = ""

        // now  in this function we do our if checks for "Morning", "Mid-morning", "Afternoon", "Mid-Afternoon", "Dinner"
        // and decide what meal to give them

        // but first we need to make sure it's lower case to it actually matches due to case sensitivity
        var lowerCaseDayTime = dayTimeEntered.lowercase()

        // now we can give our freind the meal suggestions
        if(lowerCaseDayTime == "morning"){
            mealSuggestion = "Eggs on Toast"
        } else if(lowerCaseDayTime == "mid-morning"){
            mealSuggestion = "Fruit Bowl with Granola"
        } else if(lowerCaseDayTime == "afternoon"){
            mealSuggestion = "Chicken Wrap"
        }else if(lowerCaseDayTime == "mid-afternoon"){
            mealSuggestion = "Peanut Butter on toast with banana"
        } else if(lowerCaseDayTime == "dinner"){
            mealSuggestion = "Curry and Naan Bread"
        }

        return mealSuggestion
    }

}

