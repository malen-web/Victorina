package com.example.myfirstapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.content.SharedPreferences
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

        var save: SharedPreferences = getSharedPreferences("Save", MODE_PRIVATE)
        val level = save.getInt("Level", 1)


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
                if (level>=1) {
                    val golevel = Intent(this, Level1::class.java)
                    startActivity(golevel)
                    finish()
                }else{
                    //пусто
                }
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
                if (level>=2) {

                    val golevel2 = Intent(this, Level2::class.java)
                    startActivity(golevel2)
                    finish()
                }else{}
            }
            catch(e: Exception){
                //пусто
            }
        }
//кнопка перехода к второму уровню - конец

        //кнопка перехода к третьему уровню - начало
        val buttonlevel3= findViewById<TextView>(R.id.textView3)
        buttonlevel3.setOnClickListener {
            try {
                if (level>=3) {
                    val golevel3 = Intent(this, Level3::class.java)
                    startActivity(golevel3)
                    finish()
                }else{}
            }
            catch(e: Exception){
                //пусто
            }
        }
//кнопка перехода к третьему уровню - конец

        //кнопка перехода к четвертому уровню - начало
        val buttonlevel4= findViewById<TextView>(R.id.textView4)
        buttonlevel4.setOnClickListener {
            try {
                if (level>=4) {
                    val golevel4 = Intent(this, Level4::class.java)
                    startActivity(golevel4)
                    finish()
                }else{}
            }
            catch(e: Exception){
                //пусто
            }
        }
//кнопка перехода к четвертому уровню - конец

        val x = arrayOf(
            R.id.textView1,
                R.id.textView2,
                R.id.textView3,
                R.id.textView4
                )
        for(i in 1 until  level){
            val tv: TextView = findViewById(x[i])
            tv.setText(""+(i+1))
        }




    }


    
//системная кнопка "назад" - начало
    override fun onBackPressed() {
        val intent = Intent(this@GameLevels, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
//системная кнопка "назад" - начало


}