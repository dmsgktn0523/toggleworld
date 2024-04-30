package com.hello.toggleworld

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hello.toggleworld.databinding.WordsRecyclerViewBinding
import android.util.Log


class CustomAdapter(val savedWordsList : ArrayList<SavedWords2>) : RecyclerView.Adapter<CustomAdapter.Holder>() {
    override fun getItemCount(): Int {
        return savedWordsList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomAdapter.Holder {
        val binding = WordsRecyclerViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: CustomAdapter.Holder, position: Int) {
        holder.word.text = savedWordsList[position].word
        holder.meaning.text = savedWordsList[position].meaning
        holder.sentence.text = savedWordsList[position].sentence
    }

    inner class Holder(val binding: WordsRecyclerViewBinding) : RecyclerView.ViewHolder(binding.root) {
        val word = binding.textWord
        val meaning = binding.textMeaning
        val sentence = binding.textSentence
    }

    fun addWord(savedWords2: SavedWords2) {
        savedWordsList.add(savedWords2)
        Log.d("CustomAdapter", "Added word: ${savedWords2.word}")
        notifyDataSetChanged()

    }
}



