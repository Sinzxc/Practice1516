package com.example.pet

import android.content.res.Resources.Theme
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Switch
import android.widget.TextView
import androidx.appcompat.app.AppCompatDelegate

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val textView: TextView = findViewById(R.id.textView2);
        var pet:Pet=Pet();
        val arguments: Bundle? = intent.extras
        if (arguments != null) {
            pet =
                arguments.getParcelable<Pet>(pet.javaClass.simpleName) as Pet;
            textView.text=pet.write();
        }

    }
}