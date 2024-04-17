package com.example.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        openFragment(MyFirstFragment())

//        val btn_home = findViewById<Button>(R.id.home)
//        val btn_profile = findViewById<Button>(R.id.profile)
//        val btn_cart = findViewById<Button>(R.id.cart)

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_nav)

        bottomNav.setOnNavigationItemSelectedListener {
            val id = it.itemId
            when(id){
                R.id.home -> {
                    Toast.makeText(this, "Home Selected",Toast.LENGTH_SHORT).show()
                    openFragment(MyFirstFragment())
                }
                R.id.profile -> {
                    Toast.makeText(this, "Profile Selected", Toast.LENGTH_SHORT).show()
                    openFragment(MySecondFragment())
                }
                R.id.cart -> {
                    Toast.makeText(this,"Cart Selected", Toast.LENGTH_SHORT).show()
                    openFragment(MyThirdFragment())
                }
            }

            return@setOnNavigationItemSelectedListener true
        }


//        supportFragmentManager.beginTransaction().replace(R.id.fcv1, MyFirstFragment()).commit()
    }

    private fun openFragment(fragment:Fragment){
        supportFragmentManager.beginTransaction()
            .replace(R.id.fcv1, fragment)
            .commit()
    }
}