package com.hello.toggleworld

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.hello.toggleworld.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        val binding: ActivityMainBinding
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)




        binding.btnFragment1.setOnClickListener {
            setFrag(0)
        }
        binding.btnFragment2.setOnClickListener {
            setFrag(1)
        }

//        binding.btnBottomFragment3.setOnClickListener {
//            setFrag(2)
//        }

        setFrag(0)


    }


    private fun setFrag(fragNum: Int) {
        val ft = supportFragmentManager.beginTransaction()
        when (fragNum) {
            0 -> {
                ft.replace(R.id.main_frame, Fragment1()).commit()
            }
            1 -> {
                ft.replace(R.id.main_frame, Fragment2()).commit()
            }
            2 ->{
                ft.replace(R.id.main_frame, Frag1AddingWord()).commit()
            }
        }
    }

    override fun onBackPressed() {
        val fragment = supportFragmentManager.findFragmentById(R.id.main_frame)
        if (fragment is Fragment2) {
            fragment.goBack()
        } else {
            super.onBackPressed()
        }
    }




}