package com.hello.toggleworld

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.hello.toggleworld.databinding.Frag1Binding
import com.hello.toggleworld.databinding.Frag1AddingWordBinding

class Fragment1 : Fragment() {
    private lateinit var binding: Frag1Binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = Frag1Binding.inflate(inflater, container, false)
        return binding.root
    }
}

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        binding.btnBottom3.setOnClickListener {
//            moveToAnotherPage()
//        }
//    }
//
//    private fun moveToAnotherPage() {
//        val intent = Intent(activity, Frag1AddingWord::class.java)
//        startActivity(intent)
//    }
//
//}