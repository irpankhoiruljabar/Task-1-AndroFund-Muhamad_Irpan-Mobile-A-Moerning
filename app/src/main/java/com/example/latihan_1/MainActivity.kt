package com.example.latihan_1

import CFragment1
import CFragment2
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var tv: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv = findViewById(R.id.textView2)

        val username = intent.getParcelableExtra<User>("User")?.username
        val password = intent.getParcelableExtra<User>("User")?.password
        tv.text = "Username $username dan Password $password"

        val btnImplicit: Button = findViewById(R.id.btn_impli)
        btnImplicit.setOnClickListener(this)


        val btnFragment1: Button = findViewById(R.id.btn_fragment1)
        btnFragment1.setOnClickListener(this)

        val btnFragment2: Button = findViewById(R.id.btn_fragment2)
        btnFragment2.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn_impli -> {
                val intent = Intent()
                intent.putExtra("history", "anda sudah login")
                setResult(RESULT_OK, intent)
                finish()
            }
            R.id.btn_fragment1 -> {
                val fragment1 = CFragment1()
                val fragmentManager: FragmentManager = supportFragmentManager
                val transaction: FragmentTransaction = fragmentManager.beginTransaction()
                transaction.replace(R.id.fragment_container, fragment1)
                transaction.addToBackStack(null)
                transaction.commit()
            }
            R.id.btn_fragment2 -> {
                val fragment2 = CFragment2()
                val fragmentManager: FragmentManager = supportFragmentManager
                val transaction: FragmentTransaction = fragmentManager.beginTransaction()
                transaction.replace(R.id.fragment_container, fragment2)
                transaction.addToBackStack(null)
                transaction.commit()
            }
        }
    }
}