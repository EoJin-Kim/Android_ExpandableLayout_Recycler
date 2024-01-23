package com.example.android_expandablelayout_recycler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addFragment(Test1Fragment())
    }

    fun addFragment(fragment : Fragment){
        supportFragmentManager.beginTransaction()
            .add(R.id.fragmentContainerView, fragment)
            .addToBackStack(fragment.javaClass.simpleName)
            .commit()
    }
}