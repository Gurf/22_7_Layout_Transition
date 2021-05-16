package ru.ustyuzhinskiydev.a22_7_layout_transition

import android.animation.AnimatorInflater
import android.animation.LayoutTransition
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button_container.layoutTransition.enableTransitionType(LayoutTransition.CHANGING)

        add_button.setOnClickListener {
            val button = Button(this)
            button.text = "Button"
            button.scaleX = 0f
            button.scaleY = 0f
            button_container.layoutTransition.setAnimator(
                LayoutTransition.APPEARING,
                AnimatorInflater.loadAnimator(this, R.animator.animator_res)
            )
            button_container.addView(button)
          
//            button_container.layoutTransition.enableTransitionType(LayoutTransition.CHANGING)//у нашего контейнера с атрибутом android:animateLayoutChanges="true" получаем layoutTransition и устанавливаем ему дополнительное свойство
        }






        remove_button.setOnClickListener {
            if (button_container.childCount != 0) {
                button_container.removeViewAt(button_container.childCount - 1)
            }
        }
    }
}