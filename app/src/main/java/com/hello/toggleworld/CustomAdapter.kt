package com.hello.toggleworld

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hello.toggleworld.databinding.WordsRecyclerViewBinding
import android.util.Log


class CustomAdapter(private val savedWordsList : ArrayList<SavedWords2>) : RecyclerView.Adapter<CustomAdapter.Holder>() {

    interface OnWordCountChangeListener {
        fun onWordCountChanged(count: Int)
    }
    override fun getItemCount(): Int = savedWordsList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = WordsRecyclerViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(savedWordsList[position], position+1)
    }

    class Holder(private val binding: WordsRecyclerViewBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(savedWords2: SavedWords2, wordNumber: Int){
            binding.textWord.text = savedWords2.word
            binding.textMeaning.text = savedWords2.meaning
            binding.textSentence.text = savedWords2.sentence

            binding.textWordNumber.text = wordNumber.toString()  // 각 아이템의 순번 표시
        }
    }

    fun addWord(savedWords2: SavedWords2) {
        savedWordsList.add(savedWords2)
        Log.d("CustomAdapter", "Added word: ${savedWords2.word}")
        notifyDataSetChanged()
        notifyItemInserted(savedWordsList.size - 1)

    }

    fun setItemCount(count: Int) {
        notifyItemInserted(count) // 아이템이 추가되었음을 알림
    }
}



