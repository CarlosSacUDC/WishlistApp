
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.wishlistapp.Wishlist
import com.example.wishlistapp.R

class ListAdapter(private val wishlist: List<Wishlist>) : RecyclerView.Adapter<ListAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val name: TextView
        val price: TextView
        val link: TextView

        init {
            name = itemView.findViewById(R.id.nameTv)
            price = itemView.findViewById(R.id.priceTv)
            link = itemView.findViewById(R.id.linkTv)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.wishlist_item, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return wishlist.size
    }

    override fun onBindViewHolder(holder: ListAdapter.ViewHolder, position: Int) {
        val wishlist: Wishlist = wishlist[position]

        holder.name.text=wishlist.item
        holder.price.text=wishlist.price
        holder.link.text=wishlist.link
    }
}