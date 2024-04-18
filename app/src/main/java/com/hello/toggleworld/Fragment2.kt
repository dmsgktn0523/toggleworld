package com.hello.toggleworld

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

import android.webkit.WebChromeClient
import android.webkit.WebViewClient
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.hello.toggleworld.databinding.Frag2Binding
import android.content.Intent


class Fragment2 : Fragment() {
    lateinit var binding: Frag2Binding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//        val view = inflater.inflate(R.layout.frag2, container, false)
        binding = Frag2Binding.inflate(inflater, container, false)
        return binding.root
    }

//    웹 뷰 넣기 (사전)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.dictionaryWebNaver.settings.javaScriptEnabled = true
        // 웹 뷰에서 새 창을 뜨지 않도록
        binding.dictionaryWebNaver.webViewClient = WebViewClient()
        binding.dictionaryWebNaver.webChromeClient = WebChromeClient()
        binding.dictionaryWebNaver.loadUrl("https://en.dict.naver.com/#/main")
    }
    fun goBack() {
        if (binding.dictionaryWebNaver.canGoBack()) {
            binding.dictionaryWebNaver.goBack()
        }
    }

}