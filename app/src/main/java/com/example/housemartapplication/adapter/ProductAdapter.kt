import android.app.Activity
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.housemartapplication.R
import com.example.housemartapplication.Splash_Activity
import com.example.housemartapplication.model.Product

class ProductAdapter(private val productList: List<ProductAdapterItem>) :
    RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val productImage: AppCompatImageView = itemView.findViewById(R.id.imvProductImage)
        val productName: AppCompatTextView = itemView.findViewById(R.id.txtProductName)
        val productPrice: AppCompatTextView = itemView.findViewById(R.id.txtProductPrice)
        val productRating: AppCompatTextView = itemView.findViewById(R.id.txtProductRating)
        val productRatingCount: AppCompatTextView =
            itemView.findViewById(R.id.txtProductRatingCount)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.custom_adapter_product, parent, false)
        return ProductViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val currentItem = productList[position]

        Log.d("<<<>>>"  ,currentItem.imageResource.get(0).toString())
        Glide.with(holder.itemView.context)
            .load(currentItem.imageResource.get(0).toString()) // Assuming imageResource is a URL
            .into(holder.productImage)

        holder.productName.text = currentItem.name
        holder.productPrice.text = currentItem.price.toString()
        holder.productRating.text = currentItem.rating.toString()
        holder.productRatingCount.text = currentItem.ratingCount.toString()
    }

    override fun getItemCount() = productList.size
}
