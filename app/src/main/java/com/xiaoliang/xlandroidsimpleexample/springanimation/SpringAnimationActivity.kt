package com.xiaoliang.xlandroidsimpleexample.springanimation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import androidx.dynamicanimation.animation.DynamicAnimation
import androidx.dynamicanimation.animation.SpringAnimation
import androidx.dynamicanimation.animation.SpringForce
import com.xiaoliang.xlandroidsimpleexample.R
import kotlinx.android.synthetic.main.activity_spring_animation.*


//弹簧动画实例
class SpringAnimationActivity : AppCompatActivity() {

    var offsetX = 0f
    var offsetY = 0f
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spring_animation)

        spring_animation_button.setOnTouchListener { buuton, event ->
            when(event.action){
                MotionEvent.ACTION_DOWN ->{
                    offsetX = event.rawX
                    offsetY =event.rawY
                }
                MotionEvent.ACTION_MOVE ->{
                    buuton.translationX = event.rawX - offsetX
                    buuton.translationY = event.rawY - offsetY
                }
                MotionEvent.ACTION_UP ->{
                    SpringAnimation(buuton,DynamicAnimation.TRANSLATION_Y).apply {
                        SpringForce().apply {
                            stiffness = SpringForce.STIFFNESS_VERY_LOW
                        }
                        animateToFinalPosition(0f)
                    }
                    SpringAnimation(buuton,DynamicAnimation.TRANSLATION_Y).apply {
                        SpringForce().apply {
                            stiffness = SpringForce.STIFFNESS_VERY_LOW
                        }
                        animateToFinalPosition(0f)
                    }
                }
            }
            true
        }




    }
}