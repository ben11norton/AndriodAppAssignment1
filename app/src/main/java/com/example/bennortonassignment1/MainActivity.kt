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

        // delcaring my layout variables:
        val timeOfDayInput: EditText = findViewById(R.id.dayTimeInput)
        val enterTimeOfDayButton: Button = findViewById(R.id.enterDayTime)
        val mealSuggestionDisplay: TextView = findViewById(R.id.mealSuggestion)
        val resetButton: Button = findViewById(R.id.resetButton)




        // adding an event listener kotlin style
        // normally would be button.addEventLister("onclick" function (){})
        // but here we do :

        // reset button clicking functionality:
        resetButton.setOnClickListener{

        }
    }
}

