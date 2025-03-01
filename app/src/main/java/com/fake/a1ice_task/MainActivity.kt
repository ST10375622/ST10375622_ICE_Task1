package com.fake.a1ice_task

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val number1EditText: EditText = findViewById(R.id.etNumber1)
        val number2EditText: EditText = findViewById(R.id.etNumber2)
        val addButton: Button = findViewById(R.id.addButton)
        val subtractButton: Button = findViewById(R.id.subtractButton)
        val divideButton: Button = findViewById(R.id.divideButton)
        val multiplyButton:Button = findViewById(R.id.multiplyButton)
        val resultTextView: TextView = findViewById(R.id.resultTextView)

        addButton.setOnClickListener{

            val num1 = number1EditText.text.toString().toDoubleOrNull()
            val num2 = number2EditText.text.toString().toDoubleOrNull()

            if (num1 != null && num2 != null)
            {
                val sum = num1 + num2
                resultTextView.text = "Result: $sum"
            } else
            {
                resultTextView.text = "please enter valid numbers"
            }
        }

        subtractButton.setOnClickListener{
            val num1 = number1EditText.text.toString().toDoubleOrNull()
            val num2 = number2EditText.text.toString().toDoubleOrNull()

            if (num1 != null && num2 != null)
            {
                val subtraction = num1 - num2
                resultTextView.text = "Result: $subtraction"
            } else
            {
                resultTextView.text = "please enter valid numbers"
            }
        }

        divideButton.setOnClickListener {
            val num1 = number1EditText.text.toString().toDoubleOrNull()
            val num2 = number2EditText.text.toString().toDoubleOrNull()

            if (num1 != null && num2 != null ) {
                if (num2 != 0.0) {
                    val divide = num1 / num2
                    resultTextView.text = "Result: $divide"
                } else {
                    resultTextView.text = "Cannot to divisible by 0"
                }
            }else
            {
                resultTextView.text = "please enter valid numbers"
            }

        }

        multiplyButton.setOnClickListener {
            val num1 = number1EditText.text.toString().toDoubleOrNull()
            val num2 = number2EditText.text.toString().toDoubleOrNull()

            if (num1 != null && num2 != null ) {
                val multiply = num1 * num2
                resultTextView.text = "Result: $multiply"
            }else
            {
                resultTextView.text = "please enter valid numbers"
            }

        }


        //ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
          //  val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            //v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            //insets
        }
    }
