import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.example.housemartapplication.R
import com.example.housemartapplication.model.Shop

class ShopAdapter(private val shopList: List<Shop>) :
    RecyclerView.Adapter<ShopAdapter.ShopViewHolder>() {

    class ShopViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val shopImage: AppCompatImageView = itemView.findViewById(R.id.imvShop)
        val shopName: AppCompatTextView = itemView.findViewById(R.id.txtShopName)
        val shopDistance: AppCompatTextView = itemView.findViewById(R.id.txtShopDistance)
        val shopRating: AppCompatTextView = itemView.findViewById(R.id.txtShopRating)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.layout_shops, parent, false)
        return ShopViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ShopViewHolder, position: Int) {
        val currentItem = shopList[position]
        holder.shopImage.setImageResource(currentItem.imageResource)
        holder.shopName.text = currentItem.name
        holder.shopDistance.text = currentItem.distance
        holder.shopRating.text = currentItem.rating
    }

    override fun getItemCount() = shopList.size
}
