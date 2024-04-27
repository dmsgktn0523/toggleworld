//import android.view.LayoutInflater
//import android.view.ViewGroup
//import androidx.recyclerview.widget.RecyclerView
//import com.hello.toggleworld.databinding.WordsRecyclerViewBinding
//
//class FavoriteRecyclerAdapter(val items: ArrayList<Favorite>): RecyclerView.Adapter<FavoriteRecyclerAdapter.ViewHolder>(){
//
//    interface OnItemClickListener{
//        fun OnItemClick(url:String)
//    }
//
//    var itemClickListener: OnItemClickListener?=null
//
//    inner class ViewHolder(val binding: WordsRecyclerViewBinding): RecyclerView.ViewHolder(binding.root){
//        init {
//            binding.root.setOnClickListener {
//                itemClickListener?.OnItemClick(items[adapterPosition].url)
//            }
//        }
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        val view = WordsRecyclerViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//        return ViewHolder(view)
//    }
//
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        holder.binding.apply {
//            tvTitle.text = items[position].fName
//            // 여기에 ImageView에 해당하는 코드를 추가해야 합니다.
//        }
//
//
//    }
//
//    override fun getItemCount(): Int {
//        return items.size
//    }
//}
//
//data class Favorite(val fName: String, val id1: Int, val url: String)
//
