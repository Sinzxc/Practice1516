package com.example.pet

import android.content.Intent
import android.content.res.Resources.Theme
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Switch
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.res.ResourcesCompat.ThemeCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val standardSwitch:Switch = findViewById(R.id.switch1)
        standardSwitch.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
        }
    }
    fun  click(view: View){
        val nameText: EditText = findViewById(R.id.editTextText)
        val yearhText: EditText = findViewById(R.id.editTextNumber)
        val monthText: EditText = findViewById(R.id.editTextNumber2)
        if(nameText.text.toString()!=""&&yearhText.text.toString()!=""&&monthText.text.toString()!="")
        {
            val name = nameText.text.toString()
            val year = yearhText.text.toString().toInt()
            val month = monthText.text.toString().toInt()
            val pet: Pet = Pet(name, year, month)
            val intent: Intent = Intent(this@MainActivity,
                MainActivity2::class.java)
            intent.putExtra(pet.javaClass.simpleName, pet)
            startActivity(intent);
        }
        else
        {
            Toast.makeText(this,"Не заполнены поля",Toast.LENGTH_SHORT);
        }

    }

}