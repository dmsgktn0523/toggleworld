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


class Fragment1 : Fragment(), QuickAdd.OnWordAddedListener {
    private lateinit var binding: Frag1Binding
    private val savedWordsList = ArrayList<SavedWords2>() // Declare savedWordsList
    private lateinit var customAdapter: CustomAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = Frag1Binding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        customAdapter = CustomAdapter(savedWordsList)
        binding.wordsRecyclerView.adapter = customAdapter


//        savedWordsList.add(SavedWords2("clutter-free", "어수선한 것이 없는", ""))


        // LinearLayoutManager 설정
        val layoutManager = LinearLayoutManager(requireContext())
        binding.wordsRecyclerView.layoutManager = layoutManager

        binding.btnBottomFragment3.setOnClickListener {
            val quickAddFragment = QuickAdd()
            quickAddFragment.setOnWordAddedListener(this)
            // FragmentTransaction 시작
            val transaction = requireActivity().supportFragmentManager.beginTransaction()

            // QuickAdd 페이지를 FragmentContainer에 추가
            transaction.replace(R.id.main_frame, quickAddFragment)

            // 사용자가 뒤로가기 버튼을 누를 때 이전 Fragment로 돌아갈 수 있도록 addToBackStack() 호출
            transaction.addToBackStack(null)

            // FragmentTransaction을 커밋하여 변경사항을 적용
            transaction.commit()
        }



        // savedWordsList 생성
////        savedWordsList.add(SavedWords2("clutter-free", "어수선한 것이 없는", ""))
////        savedWordsList.add(SavedWords2("deployment", "전개, 배치", "the goverment's troop deployment is set against to Iraq"))
//
//        // CustomAdapter 설정
//        customAdapter = CustomAdapter(savedWordsList)
//        binding.wordsRecyclerView.adapter = customAdapter
//
//
//        // LinearLayoutManager 설정
//        val layoutManager = LinearLayoutManager(requireContext())
//        binding.wordsRecyclerView.layoutManager = layoutManager
//
////        val frag1QuickAdd = Frag1QuickAdd()
////        frag1QuickAdd.setOnWordAddedListener((this))
//
//        val word = arguments?.getString("word")
//        val meaning = arguments?.getString("meaning")
//        if (word != null && meaning != null) {
////             Bundle에서 단어와 의미를 추출하고 RecyclerView에 추가하는 작업 수행
//            savedWordsList.add(SavedWords2(word, meaning, ""))
//            customAdapter.notifyDataSetChanged() // RecyclerView 갱신
//
//        }



    }



    override fun onWordAdded(word: String, meaning: String, sentence: String) {
        // 단어와 뜻을 받아 처리하는 로직 구현
        savedWordsList.add(SavedWords2(word, meaning, sentence))
        customAdapter.notifyDataSetChanged()

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
