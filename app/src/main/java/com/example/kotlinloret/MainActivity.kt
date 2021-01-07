package com.example.kotlinloret

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlinloret.presentation.main.LoginError
import com.example.kotlinloret.presentation.main.LoginSuccess
import com.example.kotlinloret.presentation.main.MainViewModel
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import org.koin.android.ext.android.inject
import kotlinx.android.synthetic.main.activity_main.*
import androidx.lifecycle.Observer
import com.example.kotlinloret.R

class MainActivity : AppCompatActivity() {
    val mainViewModel: MainViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel.loginLiveData.observe(this, Observer {
            when(it){
                is LoginSuccess -> {
                    //TODO Navigate
                }
                LoginError -> {
                    MaterialAlertDialogBuilder(this)
                            .setTitle("Erreur")
                            .setMessage("Compte inconnu")
                            .setPositiveButton("Ok") { dialog, which ->
                                dialog.dismiss()
                            }
                            .show()

                }
            }
        })
        login_button.setOnClickListener {
            mainViewModel.onClickedLogin(login_edit.text.toString().trim(), password_edit.text.toString())
        }
    }
}

