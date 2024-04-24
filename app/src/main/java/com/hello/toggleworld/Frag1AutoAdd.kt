package com.hello.toggleworld

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.hello.toggleworld.databinding.Frag1AutoAddBinding
import com.hello.toggleworld.databinding.Frag1Binding
import com.hello.toggleworld.databinding.Frag1DetailAddBinding
import com.hello.toggleworld.databinding.Frag1QuickAddBinding

class Frag1AutoAdd : Fragment() {
    private lateinit var binding: Frag1AutoAddBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = Frag1AutoAddBinding.inflate(inflater, container, false)
        return binding.root
    }


    interface OnReturnButtonClickListener {
        fun onReturnButtonClick()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.btnAutoReturn.setOnClickListener {
            // Call the interface method when the button is clicked
            (activity as? OnReturnButtonClickListener)?.onReturnButtonClick()
        }
    }
}


