package com.example.myfirstapplication

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.view.WindowInsets


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       val buttonStart = findViewById<Button>(R.id.buttonStart) as Button
        buttonStart.setOnClickListener {
            val intent = Intent(this@MainActivity, GameLevels::class.java)
            startActivity(intent)
            finish()
        }




         val w = window
         w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
    }

    //выход из игры
    private var backPressedTime:Long = 0
    private lateinit var backToast:Toast
    override fun onBackPressed() {
        backToast = Toast.makeText(this, "Нажмите еще раз \"Назад\", чтобы выйти.", Toast.LENGTH_LONG)
        if (backPressedTime + 2000 > System.currentTimeMillis()) {
            backToast.cancel()
            super.onBackPressed()
            return
        } else {
            backToast.show()
        }
        backPressedTime = System.currentTimeMillis()

    }

    

}