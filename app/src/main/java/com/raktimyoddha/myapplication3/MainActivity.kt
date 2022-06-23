package com.raktimyoddha.myapplication3

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val greetingTextView = findViewById<TextView>(R.id.tvHello)
        val inputField = findViewById<EditText>(R.id.tvName)
        val submitButton = findViewById<Button>(R.id.submitBt)
        val offersButton = findViewById<Button>(R.id.offersBt)
        var enteredName = ""
        submitButton.setOnClickListener {
            enteredName = inputField.text.toString()
            if(enteredName == ""){
                offersButton.visibility = View.INVISIBLE //If no name given it remains invisible
                greetingTextView.text = ""
                Toast.makeText( this@MainActivity,
                    "Please,enter your name!!",
                    Toast.LENGTH_LONG
                ).show()
            } else{
                val message = "Welcome $enteredName"
                greetingTextView.text = message
                inputField.text.clear()
                offersButton.visibility = View.VISIBLE
            }
        }
        offersButton.setOnClickListener{
            val intent=Intent(this,SecondActivity::class.java)
            intent.putExtra("USER" , enteredName)
            startActivity(intent)
        }

    }
}