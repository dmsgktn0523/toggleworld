package com.hello.toggleworld

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.hello.toggleworld.databinding.Frag1Binding
import com.hello.toggleworld.databinding.Frag1AddingWordBinding

class Frag1AddingWord : Fragment() {
    private lateinit var binding: Frag1AddingWordBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = Frag1AddingWordBinding.inflate(inflater, container, false)
        return binding.root
    }
}

//class Frag1AddingWord : Fragment() {
//    private lateinit var binding: Frag1AddingWordBinding
//
//    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//        binding = Frag1AddingWordBinding.inflate(inflater, container, false)
//        return binding.root
//    }
//}

//
//class Frag1AddingWord : AppCompatActivity() {
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        val binding: Frag1AddingWordBinding
//        super.onCreate(savedInstanceState)
//        binding = Frag1AddingWordBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//    }
//}
//class Frag1AddingWord : AppCompatActivity() {
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        val binding: Frag1AddingWordBinding
//        super.onCreate(savedInstanceState)
//        binding = Frag1AddingWordBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//    }
//}