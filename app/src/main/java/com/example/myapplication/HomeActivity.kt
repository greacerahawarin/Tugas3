package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.MultiAutoCompleteTextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val buttonShare = findViewById<Button>(R.id.button3)
        val textInput = findViewById<MultiAutoCompleteTextView>(R.id.multiAutoCompleteTextView)


        buttonShare.setOnClickListener {
            val textToShare = textInput.text.toString()

            if (textToShare.isNotEmpty()) {
                val intentSendTo = Intent(Intent.ACTION_SEND)
                intentSendTo.putExtra(Intent.EXTRA_TEXT, textToShare)
                intentSendTo.type = "text/plain"

                startActivity(Intent.createChooser(intentSendTo, "Share To"))
            }
        }
    }

}
