package com.hello.toggleworld

import android.graphics.Typeface
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.hello.toggleworld.databinding.ActivityMainBinding
import com.hello.toggleworld.databinding.Frag1QuickAddBinding


class MainActivity : AppCompatActivity(), Frag1QuickAdd.OnReturnButtonClickListener, Frag1DetailAdd.OnReturnButtonClickListener, Frag1AutoAdd.OnReturnButtonClickListener {



    override fun onCreate(savedInstanceState: Bundle?) {
        val binding: ActivityMainBinding
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //bindingFrag1QuickAdd = Frag1QuickAddBinding.inflate(inflater, container, false)



        binding.btnFragment1.setOnClickListener {
            setFrag(0)
        }
        binding.btnFragment2.setOnClickListener {
            setFrag(1)
        }

        //bindingFrag1QuickAdd.btnReturn.setOnClickListener {
        //    setFrag(0)
        //}


//        binding.btnBottomFragment3.setOnClickListener {
//            setFrag(2)
//        }

        setFrag(0)


    }
    override fun onReturnButtonClick() {
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
                ft.replace(R.id.main_frame, QuickAdd()).commit()
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