package com.example.myfirstapplication


import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.view.*
import android.view.View.OnTouchListener
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random


class Level1 : AppCompatActivity() {
    var array = Array() //вызвал класс при помощи переменной
    var count = 0


    @SuppressLint("WrongViewCast", "ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.universal)

        //создаем переменную Text levels- начало
        val textlevels = findViewById<TextView>(R.id.text_levels)
        textlevels.setText(R.string.level1)
        //создаем переменную Text levels- конец


        //путь к левой TextView
        val text_left = findViewById<TextView>(R.id.text_left)

        //путь к правой TextView
        val text_right = findViewById<TextView>(R.id.text_right)





        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //вызов диалогового окна в начале игры
            val dialog = Dialog(this) //создали далоговое окно
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE) // скрыли заголовок
            dialog.setCancelable(false) // окно нельзя закрыть системной кнопкой назад
            dialog.setContentView(R.layout.previewdialog) // путь к макету диалогового окна
            dialog.getWindow()?.setBackgroundDrawableResource(android.R.color.transparent); // прозрачный фон диалога


        // кнопка закрывающая диалоговое коно - начало

                    //обрабатываем нажатие кнопки - начало
        val btnX = dialog.findViewById<Button>(R.id.btnclose) as TextView
        btnX.setOnClickListener {

            val btnX = Intent(this@Level1, GameLevels::class.java)
            startActivity(btnX)
            finish()
        }
                    //обрабатываем нажатие кнопки - конец
        // кнопка закрывающая диалоговое коно - конец


        //кнопка продожение - начало
        val btncontinues=dialog.findViewById<Button>(R.id.btncontinue) as Button
        btncontinues.setOnClickListener{dialog.dismiss()}
        //кнопка продожение - конец

            dialog.show() // показать диалоговое окно

        //_______________________________________________________

                    val dialogEnd = Dialog(this) //создали далоговое окно
            dialogEnd.requestWindowFeature(Window.FEATURE_NO_TITLE) // скрыли заголовок
            dialogEnd.setCancelable(false) // окно нельзя закрыть системной кнопкой назад
            dialogEnd.setContentView(R.layout.dialogend) // путь к макету диалогового окна
            dialogEnd.getWindow()?.setBackgroundDrawableResource(android.R.color.transparent); // прозрачный фон диалога


        // кнопка закрывающая диалоговое коно - начало

                    //обрабатываем нажатие кнопки - начало
        val btnX2 = dialogEnd.findViewById<Button>(R.id.btnclose) as TextView
        btnX2.setOnClickListener {

            val btnX2 = Intent(this@Level1, GameLevels::class.java)
            startActivity(btnX2)
            finish()
        }
                    //обрабатываем нажатие кнопки - конец
        // кнопка закрывающая диалоговое коно - конец


        //кнопка продожение - начало
        val btncontinues2=dialogEnd.findViewById<Button>(R.id.btncontinue) as Button
        btncontinues2.setOnClickListener{dialog.dismiss()}
        //кнопка продожение - конец



        //_______________________________________________________


        //кнопка назад - начало
        val btnback = findViewById<Button>(R.id.button_back) as Button
        try {
            btnback.setOnClickListener {
                val btnback = Intent(this@Level1, GameLevels::class.java)
                startActivity(btnback)
                finish()
            }
        }catch (e: Exception){
            //кода нет
        }
        //кнопка назад - конец

        //массив дл прогресса игры- начало
        val progress = arrayOf(R.id.point1, R.id.point2, R.id.point3, R.id.point4, R.id.point5,
                R.id.point6, R.id.point7, R.id.point8, R.id.point9, R.id.point10,
                R.id.point11, R.id.point12, R.id.point13, R.id.point14, R.id.point15,
                R.id.point16, R.id.point17, R.id.point18, R.id.point19, R.id.point20)
        //массив дл прогресса игры- конец


        //подключаем анимацию - начало
        val a = AnimationUtils.loadAnimation(this, R.anim.alpha)
        //подключаем анимацию - начало


        val numLeft = Random.nextInt(10) //генерируем случайное число от 0 до 9
        val img_left = findViewById<ImageView>(R.id.img_left)
        img_left.setImageResource(array.images1[numLeft]) //достаем картинку из массива
        text_left.setText(array.text1[numLeft]) //достаем из массива текст

        var numRight = Random.nextInt(10) //генерируем случайное число от 0 до 9


        //цикл с предусловияем равенства чисел - начало
        while (numLeft==numRight) {
            numRight = Random.nextInt(10)
        }
        //цикл с предусловияем равенства чисел - начало

        val img_right = findViewById<ImageView>(R.id.img_right)
        img_right.setImageResource(array.images1[numRight]) //достаем картинку из массива
        text_right.setText(array.text1[numRight]) //достаем из массива текст

        //обрабатываем нажатие на левую картинку - начало
        img_left.setOnTouchListener(object : OnTouchListener {
            @Override
            override fun onTouch(view: View?, event: MotionEvent): Boolean {
                //условие касания картинки - начало
                if (event.action == MotionEvent.ACTION_DOWN) {
                    //если коснулся картинки - начало
                    img_right.setEnabled(false) //блокируем правую катинку
                    if (numLeft > numRight) {
                        img_left.setImageResource(R.drawable.img_true)
                    } else {
                        img_left.setImageResource(R.drawable.img_false)
                    }
                    //если коснулся картинки конец
                } else if (event.action == MotionEvent.ACTION_UP) {
                    //если отпустил палец - начало
                    if (numLeft > numRight) {
                        //если левая картинка больше
                        if (count < 20) {
                            count += 1
                        }

                        //закрашиваем прогрес серым цветом начало
                        for (i in 0..19) {
                            val tv: TextView = findViewById(progress[i])
                            tv.setBackgroundResource(R.drawable.style_points)
                        }
                        //закрашиваем прогрес серым цветом конец

                        //определяем правильные ответы и закрашиваем зеленым начало
                        for (i in 0 until count) {
                            val tv: TextView = findViewById(progress[i])
                            tv.setBackgroundResource(R.drawable.style_points_green)
                        }
                        //определяем правильные ответы и закрашиваем зеленым конец
                    } else {
                        //если левая картинка меньше
                        if (count > 0) {
                            if (count == 1) {
                                count = 0
                            } else {
                                count - 2
                            }
                        }
                        //закрашиваем прогрес серым цветом начало
                        for (i in 0..18) {
                            val tv: TextView = findViewById(progress[i])
                            tv.setBackgroundResource(R.drawable.style_points)
                        }
                        //закрашиваем прогрес серым цветом конец

                        //определяем правильные ответы и закрашиваем зеленым начало
                        for (i in 0 until count) {
                            val tv: TextView = findViewById(progress[i])
                            tv.setBackgroundResource(R.drawable.style_points_green)
                        }
                        //определяем правильные ответы и закрашиваем зеленым конец
                    }
                    //если отпустил палец - крнец
                    if (count == 20) {
                        //ВЫХОД ИЗ УРОВНЯ
                        dialogEnd.show()

                    } else {
                        val numLeft = Random.nextInt(10) // генерирунм случайное число от 0 до 9
                        img_left.setImageResource(array.images1.get(numLeft)) //достаем измасива картинку
                        img_left.setAnimation(a)
                        text_left.setText(array.text1.get(numLeft)) //достаем из массива текст
                        numRight = Random.nextInt(10) // генерирунм случайное число от 0 до 9

                        //цикл с предусловием, проверяющий равенство чисел - начало
                        while (numLeft == numRight) {
                            numRight = Random.nextInt(10)
                        }
                        //цикл с предусловием, проверяющий равенство чисел - конец
                        img_right.setImageResource(array.images1.get(numRight)) // достаем измасива картинку
                        img_right.setAnimation(a)
                        text_right.setText(array.text1.get(numRight)) //достаем измасива текст
                        img_right.setEnabled(true) //включаем обратно правую картинку
                    }
                }
                //условие касания картинки - конец
                return true
            }
        })

        img_right.setOnTouchListener(object : OnTouchListener {
            @Override
            override fun onTouch(view: View?, event: MotionEvent): Boolean {
                //условие касания картинки - начало
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    //если коснулся картинки - начало
                    img_left.isEnabled = false //блокируем правую катинку
                    if (numLeft < numRight) {
                        img_right.setImageResource(R.drawable.img_true)
                    } else {
                        img_right.setImageResource(R.drawable.img_false)
                    }
                    //если коснулся картинки конец
                } else if (event.action == MotionEvent.ACTION_UP) {
                    //если отпустил палец - начало
                    if (numLeft < numRight) {
                        //если левая картинка больше
                        if (count < 20) {
                            count += 1
                        }

                        //закрашиваем прогрес серым цветом начало
                        for (i in 0..19) {
                            val tv: TextView = findViewById(progress[i])
                            tv.setBackgroundResource(R.drawable.style_points)
                        }
                        //закрашиваем прогрес серым цветом конец

                        //определяем правильные ответы и закрашиваем зеленым начало
                        for (i in 0 until count) {
                            val tv: TextView = findViewById(progress[i])
                            tv.setBackgroundResource(R.drawable.style_points_green)
                        }
                        //определяем правильные ответы и закрашиваем зеленым конец
                    } else {
                        //если левая картинка меньше
                        if (count > 0) {
                            if (count == 1) {
                                count = 0
                            } else {
                                count - 2
                            }
                        }
                        //закрашиваем прогрес серым цветом начало
                        for (i in 0..18) {
                            val tv: TextView = findViewById(progress[i])
                            tv.setBackgroundResource(R.drawable.style_points)
                        }
                        //закрашиваем прогрес серым цветом конец

                        //определяем правильные ответы и закрашиваем зеленым начало
                        for (i in 0 until count) {
                            val tv: TextView = findViewById(progress[i])
                            tv.setBackgroundResource(R.drawable.style_points_green)
                        }
                        //определяем правильные ответы и закрашиваем зеленым конец
                    }
                    //если отпустил палец - крнец
                    if (count == 20) {
                        //ВЫХОД ИЗ УРОВНЯ
                        dialogEnd.show()
                    } else {
                        val numLeft = Random.nextInt(10) // генерирунм случайное число от 0 до 9
                        img_left.setImageResource(array.images1.get(numLeft)) //достаем измасива картинку
                        img_left.setAnimation(a)
                        text_left.setText(array.text1.get(numLeft)) //достаем из массива текст
                        numRight = Random.nextInt(10) // генерирунм случайное число от 0 до 9

                        //цикл с предусловием, проверяющий равенство чисел - начало
                        while (numLeft == numRight) {
                            numRight = Random.nextInt(10)
                        }
                        //цикл с предусловием, проверяющий равенство чисел - конец
                        img_right.setImageResource(array.images1.get(numRight)) // достаем измасива картинку
                        img_right.setAnimation(a)
                        text_right.setText(array.text1.get(numRight)) //достаем измасива текст
                        img_left.isEnabled = true //включаем обратно правую картинку
                    }
                }
                //условие касания картинки - конец
                return true
            }
        })
//        img_left.setOnTouchListener(object : OnTouchListener {
//            @Override
//            override fun onTouch(view: View?, event: MotionEvent): Boolean {
//                if (event.action == MotionEvent.ACTION_DOWN) {
//                img_right.isEnabled= false
//                    if (numLeft > numRight) {
//                        img_left.setImageResource(R.drawable.img_true)
//                    } else {
//                        img_left.setImageResource(R.drawable.img_false)
//                    }
//
//                } else if (event.action == MotionEvent.ACTION_UP) {
//                    //если отпустил палец-начало
//                    if (numLeft > numRight) {
//                        //если левая картинка больше
//                        if (count < 20) {
//                            count = +1
//                        }
//                        //закрашиваем прогресс серым цветом - начало
//                        for (i in 0 until 20) {
//                            val tv = findViewById<TextView>(progress[i])
//                            tv.setBackgroundResource(R.drawable.style_points)
//                        }
//
//                        //определяем правильные ответы и закрашиваем зеленым - начало
//                        for (i in 0 until count) {
//                            val tv = findViewById<TextView>(progress[i])
//                            tv.setBackgroundResource(R.drawable.style_points_green)
//                        }
//                        //определяем правильные ответы и закрашиваем зеленым - конец
//
//                        //закрашиваем прогресс серым цветом - конец
//                    } else {
//                        //если левая картинка меньше
//                        if (count > 0) {
//                            if (count == 1) {
//                                count = 0
//                            } else {
//                                count -= 2
//                            }
//                        }
//                        //закрашиваем прогресс серым цветом - начало
//                        for (i in 0 until 19) {
//                            val tv = findViewById<TextView>(progress[i])
//                            tv.setBackgroundResource(R.drawable.style_points)
//                        }
//
//                        //определяем правильные ответы и закрашиваем зеленым - начало
//                        for (i in 0 until count) {
//                            val tv = findViewById<TextView>(progress[i])
//                            tv.setBackgroundResource(R.drawable.style_points_green)
//                        }
//                        //определяем правильные ответы и закрашиваем зеленым - начало
//                    }
//                    //если отпустил палец-конец
//                    if (count == 20) {
//                        //ВЫХОД ИЗ УРОВНЯ
//
//                    } else {
//                        val numLeft = Random.nextInt(10) //генерируем случайное число от 0 до 9
////                    val img_left = findViewById<ImageView>(R.id.img_left)
//                        img_left.setImageResource(array.images1[numLeft]) //достаем картинку из массива
//                        img_left.startAnimation(a)
//                        text_left.setText(array.text1[numLeft]) //достаем из массива текст
//
//                        var numRight = Random.nextInt(10) //генерируем случайное число от 0 до 9
//
//
//                        //цикл с предусловияем равенства чисел - начало
//                        while (numLeft == numRight) {
//                            numRight = Random.nextInt(10)
//                        }
//                        //цикл с предусловияем равенства чисел - начало
//
////                    val img_right = findViewById<ImageView>(R.id.img_right)
//                        img_right.setImageResource(array.images1[numRight]) //достаем картинку из массива
//                        img_right.startAnimation(a)
//                        text_right.setText(array.text1[numRight]) //достаем из массива текст
//                        img_right.isEnabled = true
//
//                    }
//                }
//
//               return true
//            }
//
//            })
//______________________________________________________________________________





        //обрабатываем нажатие на левую картинку - конец



    }
    //системная кнопка "назад" - начало
    override fun onBackPressed() {
        try {
        val btnsystenback = Intent(this@Level1, GameLevels::class.java)
        startActivity(btnsystenback)
        finish()
        }catch (e: Exception){
            //кода нет
        }
    }
//системная кнопка "назад" - начало
}