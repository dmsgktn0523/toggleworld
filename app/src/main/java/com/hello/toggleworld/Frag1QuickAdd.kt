package com.hello.toggleworld

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.hello.toggleworld.databinding.Frag1Binding
import com.hello.toggleworld.databinding.Frag1QuickAddBinding

class Frag1QuickAdd : Fragment() {
    private lateinit var binding: Frag1QuickAdd

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.frag1_quick_add, container,false)

        return view
    }
}