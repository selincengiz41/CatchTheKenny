package com.selincengiz.catchthekenny

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlin.random.Random as Random

class MainActivity : AppCompatActivity() {
    var score:Int=0
    var imageArray=ArrayList<ImageView>()
    var handler:Handler= Handler()
    var runnable:Runnable= Runnable {  }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        imageArray.add(imageView1)
        imageArray.add(imageView2)
        imageArray.add(imageView3)
        imageArray.add(imageView4)
        imageArray.add(imageView5)
        imageArray.add(imageView6)
        imageArray.add(imageView7)
        imageArray.add(imageView8)
        imageArray.add(imageView9)
        imageArray.add(imageView10)
        imageArray.add(imageView11)
        imageArray.add(imageView12)
        imageArray.add(imageView13)
        imageArray.add(imageView14)
        imageArray.add(imageView15)
        imageArray.add(imageView16)

hideImages()
        object : CountDownTimer(15000,1000){
            override fun onTick(p0: Long) {
                textView2.text="Time :${p0/1000}"

            }

            override fun onFinish() {
                textView2.text="Time :0"

                handler.removeCallbacks(runnable)
                for(image in imageArray){
                    image.visibility=View.INVISIBLE

                }
                val alert= AlertDialog.Builder(this@MainActivity)
                alert.setTitle("GAME OVER")
                alert.setMessage("Do you want to play again?")
                alert.setPositiveButton("Yes"){dialog,which->
                    val intent= Intent(applicationContext,MainActivity::class.java)
                    finish()
                    startActivity(intent)
                }
                alert.setNegativeButton("No"){dialog ,which->
                    Toast.makeText(applicationContext,"Fail",Toast.LENGTH_LONG).show()

                }
                alert.show()
            }

        }.start()


    }
    fun hideImages(){
        runnable=object :Runnable{
            override fun run() {
                for(image in imageArray){
                    image.visibility=View.INVISIBLE

                }

                val myRandomValues = Random.nextInt(0, 16)

                imageArray[myRandomValues].visibility=View.VISIBLE
                handler.postDelayed(runnable,500)

            }

        }
        handler.post(runnable)

    }
    fun increaseScore(view: View){
score++
        textView.text="Score :$score"
    }
    }


