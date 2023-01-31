package com.example.ejercicio4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.text.isDigitsOnly
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doOnTextChanged
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var num = 0
        var Text:TextView = findViewById(R.id.textView)
        var button:Button = findViewById(R.id.buttonNeg)
        var button2:Button = findViewById(R.id.buttonPlus)

        button.setOnClickListener {
            if(num>0){
                num--
                Text.text = num.toString()
            }

        }
        button2.setOnClickListener {
            num++
            Text.text = num.toString()
        }

        var editText2:EditText = findViewById(R.id.editTextFocus)

        editText2.setOnFocusChangeListener { v, hasFocus ->
            if(hasFocus){
                button.background.alpha=0
                button2.background.alpha=0
            }else{
                button.background.alpha=255
                button2.background.alpha=255
            }
        }

        editText2.doAfterTextChanged { text ->
            if (text.toString().isDigitsOnly()) {
                num = text.toString().toInt()
                Text.text = num.toString()
            }
        }



    }
}
