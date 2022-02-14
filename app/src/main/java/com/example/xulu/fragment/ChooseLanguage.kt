package com.example.xulu.fragment

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.xulu.R
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.fragment_choose_language.*
import java.util.*


class ChooseLanguage : Fragment(), AdapterView.OnItemSelectedListener {

    var lan = arrayOf<String?>(
        "English", "Hindi",
        "Bengali", "Tamil",
        "Telugu", "Kannada"
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_choose_language, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        button.setOnClickListener(View.OnClickListener {
            val fragmentManager: FragmentManager? = fragmentManager
            val fragmentTransaction: FragmentTransaction = fragmentManager!!.beginTransaction()
            val otpFragment = OtpFragment()
            fragmentTransaction.replace(view.rootView.fragmentContainerView.id, otpFragment)
            fragmentTransaction.commit()

        })

        val spinner = ChooseLanguageSpinner
        spinner.onItemSelectedListener = this


        val adapter = ArrayAdapter<String>(requireActivity(), android.R.layout.simple_spinner_item, lan)
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)
        spinner.adapter = adapter
    }



    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

        if (position == 0) {
            setLocale("en")
        } else if (position == 1)
            setLocale("hn")
        else if (position == 2)
            setLocale("bn")

    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("Not yet implemented")
    }

    private fun setLocale(s: String) {

        val locale = Locale(s)

        Locale.setDefault(locale)
        val config = Configuration()
        config.setLocale(locale)
        context!!.resources.updateConfiguration(config, context!!.resources.displayMetrics)


    }

}