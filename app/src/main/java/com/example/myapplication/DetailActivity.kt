package com.example.myapplication

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val img: ImageView = findViewById(R.id.imageView6)
        val nama: TextView = findViewById(R.id.textView3)
        val detail: TextView = findViewById(R.id.textView8)


        val data = intent.getParcelableExtra<ItemData>("item")


        data?.let {
            img.setImageResource(it.img)
            nama.text = it.nama
            detail.text = it.detail
        }
    }
}
