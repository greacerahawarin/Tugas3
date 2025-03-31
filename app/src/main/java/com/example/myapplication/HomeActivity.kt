package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.MultiAutoCompleteTextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.databinding.ActivityHomeBinding
import com.example.myapplication.databinding.ActivityRegisBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imageView4.setOnClickListener {
            val intentMain = Intent(this, PageActivity::class.java)
            startActivity(intentMain)
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
