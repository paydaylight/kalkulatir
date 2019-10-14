package com.example.kalkulatir

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_some.*

class SomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_some)

        btnSubmit.setOnClickListener{
            if(inputPidor.text.toString().isNotEmpty()) {
                Toast.makeText(this, inputPidor.text.toString(), Toast.LENGTH_SHORT).show()
            }
        }
    }
}
