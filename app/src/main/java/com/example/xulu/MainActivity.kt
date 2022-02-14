package com.example.xulu

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity;
import com.example.xulu.fragment.ChooseLanguage

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar!!.hide()

        addFragment()


    }

    private fun addFragment() {

        val fragmentmanager = supportFragmentManager
        val fragmnetTransaction = fragmentmanager.beginTransaction()
        val chooseLanguage = ChooseLanguage()
            fragmnetTransaction.add(R.id.fragmentContainerView,chooseLanguage)
            fragmnetTransaction.commit()


    }
}