//package com.hello.toggleworld
//
//import android.content.Intent
//import android.graphics.Typeface
//import android.graphics.Color
//import android.os.Bundle
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.fragment.app.Fragment
//import androidx.fragment.app.FragmentManager
//import com.hello.toggleworld.databinding.Frag1Binding
//import com.hello.toggleworld.databinding.Frag1AddingWordBinding
//import com.hello.toggleworld.databinding.Frag1QuickAddBinding
//
//class Frag1AddingWord : Fragment() {
//    private lateinit var binding: Frag1AddingWordBinding
//    private lateinit var bindingFrag1QuickAdd: Frag1QuickAddBinding
//
//
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        binding = Frag1AddingWordBinding.inflate(inflater, container, false)
//        return binding.root
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        setFrag(0)
//        binding.textFrag1QuickAdd.setTypeface(null, Typeface.BOLD)
//        binding.textFrag1QuickAdd.setBackgroundColor(Color.parseColor("#6750A3"))
//        binding.textFrag1QuickAdd.setTextColor(Color.WHITE)
//
//
//        binding.textFrag1QuickAdd.setOnClickListener {
//            setFrag(0)
//            binding.textFrag1QuickAdd.setTypeface(null, Typeface.BOLD)
//          //  binding.textFrag1QuickAdd.setBackgroundColor(Color.parseColor("#6750A3"))
////.textFrag1QuickAdd.setTextColor(Color.WHITE)
//            // 다른 버튼들의 텍스트 스타일을 원래대로 변경
//            binding.textFrag1DetailAdd.setTypeface(null, Typeface.NORMAL)
//            binding.textFrag1AutoAdd.setTypeface(null, Typeface.NORMAL)
//        }
//        binding.textFrag1DetailAdd.setOnClickListener {
//            setFrag(1)
//            binding.textFrag1DetailAdd.setTypeface(null, Typeface.BOLD)
//         //   binding.textFrag1DetailAdd.setBackgroundColor(Color.parseColor("#6750A3"))
//         //   binding.textFrag1DetailAdd.setTextColor(Color.WHITE)
//            // 다른 버튼들의 텍스트 스타일을 원래대로 변경
//            binding.textFrag1QuickAdd.setTypeface(null, Typeface.NORMAL)
//            binding.textFrag1AutoAdd.setTypeface(null, Typeface.NORMAL)
//        }
//        binding.textFrag1AutoAdd.setOnClickListener {
//            setFrag(2)
//            binding.textFrag1AutoAdd.setTypeface(null, Typeface.BOLD)
//         //   binding.textFrag1AutoAdd.setBackgroundColor(Color.parseColor("#6750A3"))
//         //   binding.textFrag1AutoAdd.setTextColor(Color.WHITE)
//            // 다른 버튼들의 텍스트 스타일을 원래대로 변경
//            binding.textFrag1QuickAdd.setTypeface(null, Typeface.NORMAL)
//            binding.textFrag1DetailAdd.setTypeface(null, Typeface.NORMAL)
//        }
//
//
//    }
//
//    fun setOnWordAddedListener(listener: OnWordAddedListener) {
//        this.listener = listener
//    }
//
//    private fun replaceFragment(fragment: Fragment) {
//        val fragmentManager: FragmentManager = parentFragmentManager
//        val fragmentTransaction = fragmentManager.beginTransaction()
//        fragmentTransaction.replace(R.id.main_frame, fragment)
//        fragmentTransaction.addToBackStack(null) // 이전 Fragment로 돌아갈 수 있게 스택에 추가
//        fragmentTransaction.commit()
//    }
//
//    private fun setFrag(fragNum: Int) {
//        val ft = parentFragmentManager.beginTransaction()
//        when (fragNum) {
//            0 -> {
//                ft.replace(R.id.adding_word_frame, Frag1QuickAdd()).commit()
//            }
//
//            1 -> {
//                ft.replace(R.id.adding_word_frame, Frag1DetailAdd()).commit()
//            }
//
//            2 -> {
//                ft.replace(R.id.adding_word_frame, Frag1AutoAdd()).commit()
//            }
//        }
//    }
//}
//
//
//
////class Frag1AddingWord : Fragment() {
////    private lateinit var binding: Frag1AddingWordBinding
////
////    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
////        binding = Frag1AddingWordBinding.inflate(inflater, container, false)
////        return binding.root
////    }
////}
//
////
////class Frag1AddingWord : AppCompatActivity() {
////
////    override fun onCreate(savedInstanceState: Bundle?) {
////        val binding: Frag1AddingWordBinding
////        super.onCreate(savedInstanceState)
////        binding = Frag1AddingWordBinding.inflate(layoutInflater)
////        setContentView(binding.root)
////    }
////}
////class Frag1AddingWord : AppCompatActivity() {
////
////    override fun onCreate(savedInstanceState: Bundle?) {
////        val binding: Frag1AddingWordBinding
////        super.onCreate(savedInstanceState)
////        binding = Frag1AddingWordBinding.inflate(layoutInflater)
////        setContentView(binding.root)
////    }
////}
//
