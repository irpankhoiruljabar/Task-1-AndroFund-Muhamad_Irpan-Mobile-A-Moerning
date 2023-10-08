package com.example.latihan_1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts

class LoginActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var etusername: EditText
    private lateinit var etpassword: EditText
    private lateinit var history: TextView


    val resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        result ->
        if (result.resultCode == Activity.RESULT_OK){
            val data:Intent? = result.data
            val returnString:String? = data?.getStringExtra("history")
            history.text = returnString
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        etusername = findViewById(R.id.edit_username)
        etpassword = findViewById(R.id.edit_password)
        history = findViewById(R.id.history)

        val bundle = intent.extras
        if (bundle != null) {
            etusername.setText(bundle.getString("username"))
            etpassword.setText(bundle.getString("password"))
        }

        val btnLogin: Button = findViewById(R.id.btn_login)
        btnLogin.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when(v.id) {
            R.id.btn_login -> {
                val intent = Intent(this@LoginActivity , MainActivity::class.java)
                intent.putExtra("User", User(etusername.text.toString(), etpassword.text.toString()))

               resultLauncher.launch(intent)
            }

        }
    }
}