package com.hello.toggleworld

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.text.Editable
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import com.hello.toggleworld.databinding.Frag1QuickAddBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.jsoup.Jsoup
import java.io.IOException

class Frag1QuickAdd : Fragment() {
    private lateinit var binding: Frag1QuickAddBinding
    private var onWordAddedListener: OnWordAddedListener? = null

    interface OnWordAddedListener {
        fun onWordAdded(word: String, meaning: String, sentence: String)
    }


    interface OnReturnButtonClickListener {
        fun onReturnButtonClick()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = Frag1QuickAddBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnQuickReturn.setOnClickListener {
            (activity as? OnReturnButtonClickListener)?.onReturnButtonClick()
        }

        binding.imgSearch.setOnClickListener {
            val word = binding.textWordSpellingInput.text.toString()
            if (word.isNotEmpty()) {
                translateWord(word)
            } else {
                Snackbar.make(view, "Please enter a word", Snackbar.LENGTH_SHORT).show()
            }
        }

        binding.btnAdd.setOnClickListener {
            val word = binding.textWordSpellingInput.text.toString()
            val meaning = binding.textWordMeanInput.text.toString()
            val sentence = binding.textWordMeanInput.text.toString()  // Seems incorrect; probably a copy-paste error?
            if (word.isEmpty()) {
                Snackbar.make(view, "단어를 입력해주세요", Snackbar.LENGTH_SHORT).show()
            } else {
                onWordAddedListener?.onWordAdded(word, meaning, sentence)
                binding.textWordSpellingInput.text.clear()
                binding.textWordMeanInput.text.clear()
            }
        }
    }

    fun setOnWordAddedListener(listener: OnWordAddedListener) {
        this.onWordAddedListener = listener
    }

    private fun translateWord(word: String) {
        GlobalScope.launch(Dispatchers.IO) {
            try {
                val url = "https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=0&ie=utf8&query=$word+%EB%9C%BB"
                val document = Jsoup.connect(url).get()
                val translation = document.select("p.mean.api_txt_lines").first()?.text()

                withContext(Dispatchers.Main) {
                    binding.textWordMeanInput.text = translation?.toEditable() ?: " ".toEditable()
                }
            } catch (e: IOException) {
                withContext(Dispatchers.Main) {
                    Snackbar.make(binding.root, "Translation failed", Snackbar.LENGTH_SHORT).show()
                }
            }
        }
    }

    fun String.toEditable(): Editable = Editable.Factory.getInstance().newEditable(this)
}
