package com.hello.toggleworld

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.hello.toggleworld.databinding.Frag1Binding
import androidx.recyclerview.widget.LinearLayoutManager
import com.hello.toggleworld.SavedWords2
import android.util.Log


class Fragment1 : Fragment(), Frag1QuickAdd.OnWordAddedListener {
    private lateinit var binding: Frag1Binding
    private val savedWordsList = ArrayList<SavedWords2>() // Declare savedWordsList
    private lateinit var customAdapter: CustomAdapter

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
        savedWordsList.add(SavedWords2("apple", "사과", "Apple and banana"))
//        savedWordsList.add(SavedWords2("clutter-free", "어수선한 것이 없는", ""))
//        savedWordsList.add(SavedWords2("deployment", "전개, 배치", "the goverment's troop deployment is set against to Iraq"))

        // CustomAdapter 설정
        customAdapter = CustomAdapter(savedWordsList)
        binding.wordsRecyclerView.adapter = customAdapter


        // LinearLayoutManager 설정
        val layoutManager = LinearLayoutManager(requireContext())
        binding.wordsRecyclerView.layoutManager = layoutManager

        val frag1QuickAdd = Frag1QuickAdd()
        frag1QuickAdd.setOnWordAddedListener((this))

    }
    override fun onWordAdded(savedWords2: SavedWords2) {
        // 추가된 단어를 Fragment1의 savedWordsList에 추가
        savedWordsList.add(savedWords2)
        customAdapter.addWord(savedWords2)
        Log.d("Fragment1", "onWordAdded: $savedWords2")
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

