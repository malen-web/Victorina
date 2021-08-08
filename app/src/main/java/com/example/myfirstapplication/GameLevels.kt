package com.example.myfirstapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.lang.Exception


@SuppressLint("WrongViewCast")
class GameLevels : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.gamelevels)

        val w = window
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)


//кнопка назад - начало
        val mainActivityBack = findViewById<Button>(R.id.button_back) as Button
        mainActivityBack.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@GameLevels, MainActivity::class.java)
            startActivity(intent)
            finish()
        })
//кнопкка назад- конец


//кнопка перехода к первому уровню - начало
        val buttonlevel1= findViewById<TextView>(R.id.textView1)
        buttonlevel1.setOnClickListener {
            try {
                val golevel = Intent(this, Level1::class.java)
                startActivity(golevel)
                finish()
            }
            catch(e: Exception){
                //пусто
            }
        }
//кнопка перехода к первому уровню - конец

        //кнопка перехода к второму уровню - начало
        val buttonlevel2= findViewById<TextView>(R.id.textView2)
        buttonlevel2.setOnClickListener {
            try {
                val golevel2 = Intent(this, Level2::class.java)
                startActivity(golevel2)
                finish()
            }
            catch(e: Exception){
                //пусто
            }
        }
//кнопка перехода к второму уровню - конец



    }


    
//системная кнопка "назад" - начало
    override fun onBackPressed() {
        val intent = Intent(this@GameLevels, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
//системная кнопка "назад" - начало


}