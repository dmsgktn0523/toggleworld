package com.hello.toggleworld

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.hello.toggleworld.databinding.Frag1Binding
import com.hello.toggleworld.databinding.WordsRecyclerViewBinding
import androidx.recyclerview.widget.LinearLayoutManager


class Fragment1 : Fragment() {
    private lateinit var binding: Frag1Binding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = Frag1Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnBottomFragment3.setOnClickListener {
            replaceFragment(Frag1AddingWord())
        }

        // savedWordsList 생성
        val savedWordsList = ArrayList<savedWords>()
        savedWordsList.add(savedWords("apple", "사과", "Apple and banana"))
        savedWordsList.add(savedWords("clutter-free", "어수선한 것이 없는", ""))
        savedWordsList.add(savedWords("deployment", "전개, 배치", "the goverment's troop deployment is set against to Iraq"))

        // CustomAdapter 설정
        val customAdapter = CustomAdapter(savedWordsList)
        binding.wordsRecyclerView.adapter = customAdapter


        // LinearLayoutManager 설정
        val layoutManager = LinearLayoutManager(requireContext())
        binding.wordsRecyclerView.layoutManager = layoutManager

    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager: FragmentManager = parentFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.main_frame, fragment)
        fragmentTransaction.addToBackStack(null) // 이전 Fragment로 돌아갈 수 있게 스택에 추가
        fragmentTransaction.commit()
    }









//
//    fun addWordToList(word: String, meaning: String) {
//        // Frag1AddingWord 으로부터 전달받은 단어와 뜻을 words_list에 추가하는 로직을 구현
//        val fragment1 = parentFragmentManager.findFragmentByTag("fragment1") as? Fragment1
//        fragment1?.addWordToList(word, meaning)
//    }



}

