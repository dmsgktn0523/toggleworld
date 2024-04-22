package com.hello.toggleworld

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.hello.toggleworld.databinding.ActivityMainBinding
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnBottomFragment3.setOnClickListener {
            replaceFragment(Frag1AddingWord())
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager: FragmentManager = parentFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.main_frame, fragment)
        fragmentTransaction.addToBackStack(null) // 이전 Fragment로 돌아갈 수 있게 스택에 추가
        fragmentTransaction.commit()
    }



}

