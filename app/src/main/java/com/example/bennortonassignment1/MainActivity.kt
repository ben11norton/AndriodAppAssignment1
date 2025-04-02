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

        // delcare the UI elements
        val tvResult: TextView = findViewById(R.id.tvResult)
        val button: Button = findViewById(R.id.myButton)
        val editTextBox: EditText = findViewById(R.id.editTextBox)

        // adding an event listener kotlin style
        // normally would be button.addEventLister("onclick" function (){})
        // but here we do :
        button.setOnClickListener{
            val userName = editTextBox.text
            var textToDisplay = ""

            if(userName.isNotEmpty()){
                // if the string is not null or empty then we display their name
                textToDisplay = "Hello there ${userName}, this is your computer speaking"
            } else{
                textToDisplay = "Please enter your name in the text box, kind regards computer"
            }

            tvResult.text = textToDisplay
        }
    }
}

