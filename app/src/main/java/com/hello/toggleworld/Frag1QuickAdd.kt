package com.hello.toggleworld

import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import com.hello.toggleworld.databinding.Frag1QuickAddBinding
import com.hello.toggleworld.SavedWords2
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.jsoup.Jsoup
import java.io.IOException
import android.util.Log




class Frag1QuickAdd : Fragment() {
    private lateinit var binding: Frag1QuickAddBinding
//    private val savedWordsList = ArrayList<SavedWords>()
    private var onWordAddedListener : OnWordAddedListener? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = Frag1QuickAddBinding.inflate(inflater, container, false)
        return binding.root
    }

    interface OnReturnButtonClickListener {
        fun onReturnButtonClick()
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnQuickReturn.setOnClickListener {
            // Call the interface method when the button is clicked
            (activity as? OnReturnButtonClickListener)?.onReturnButtonClick()
        }

        binding.imgSearch.setOnClickListener {
            val word = binding.textWordSpellingInput.text.toString()
            if (word.isNotEmpty()) {
                // Perform translation
                translateWord(word)
            } else {
                Snackbar.make(view, "Please enter a word", Snackbar.LENGTH_SHORT).show()
            }
        }

        binding.btnAdd.setOnClickListener {
            //단어를 추가하면, frag1의 savedWordsList에 그 단어가 저장

            val word = binding.textWordSpellingInput.text.toString()
            val meaning = binding.textWordMeanInput.text.toString()
//            val sentence = binding.textWordMeanInput.text.toString()

//            Log.d("Frag1QuickAdd", "Word: $word, Meaning: $meaning")

            val savedWords2 = SavedWords2(word, meaning, "")
            onWordAddedListener?.onWordAdded(savedWords2)

            binding.textWordSpellingInput.text.clear()
            binding.textWordMeanInput.text.clear()


        }

    }

    fun setOnWordAddedListener(listener: OnWordAddedListener) {
        this.onWordAddedListener = listener
    }


    interface OnWordAddedListener {
        fun onWordAdded(savedWords2: SavedWords2)
    }



    private fun translateWord(word: String) {
        GlobalScope.launch(Dispatchers.IO) {
            try {
                val url = "https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=0&ie=utf8&query=$word+%EB%9C%BB"
                val document = Jsoup.connect(url).get()
                val translation = document.select("p.mean.api_txt_lines").first()?.text() // Adjust this selector according to the HTML structure of Google Translate page

                // Update UI on the main thread
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
}

fun String.toEditable(): Editable = Editable.Factory.getInstance().newEditable(this)
