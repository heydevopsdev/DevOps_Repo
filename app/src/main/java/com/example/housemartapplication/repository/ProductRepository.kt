import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import com.example.housemartapplication.HelperClass
import com.example.housemartapplication.model.Category
import com.example.housemartapplication.model.Product
import com.example.housemartapplication.model.Vendor
import org.json.JSONArray
import org.json.JSONObject

class ProductRepository() {

    var productData: MutableLiveData<MutableList<Product>> = MutableLiveData()
    var vendorData: MutableLiveData<MutableList<Vendor>> = MutableLiveData()

    private val requestQueue: RequestQueue = Volley.newRequestQueue(HelperClass.context)

    init {
        fetchProducts()
    }

    fun fetchProducts() {
        Log.d("<<<>>>", "response.toString()")

        val url = "https://9258-103-58-7-103.ngrok-free.app/api/products"

        val jsonArrayRequest = JsonArrayRequest(Request.Method.GET, url, null, { response ->
            val vendorList = mutableListOf<Vendor>()
            val productList = mutableListOf<Product>()
            for (i in 0 until response.length()) {
                val item = response.getJSONObject(i)

                var jsonVendor: JSONObject = item.getJSONObject("vendor")
                var jsonCategory: JSONObject = item.getJSONObject("category")

                var vendor = Vendor(
                    jsonVendor.getInt("id").toInt(),
                    jsonVendor.getString("vendorName").toString(),
                    jsonVendor.getString("logo").toString(),
                    jsonVendor.getString("shopName").toString(),
                    jsonVendor.getString("gstNumber").toString(),
                    jsonVendor.getString("phoneNumber").toString(),
                    jsonVendor.getString("createdAt").toString(),
                    jsonVendor.getString("updatedAt").toString()
                )

                var category = Category(
                    jsonCategory.getInt("id"),
                    jsonCategory.getString("categoryName"),
                    jsonCategory.getString("categoryDescription"),
                    jsonCategory.getString("createdAt"),
                    jsonCategory.getString("updatedAt")
                )

                var listImage: MutableList<Any> = mutableListOf()
                var listVariation: MutableList<Any> = mutableListOf()
                var listReviews: MutableList<Any> = mutableListOf()

                var images : JSONArray = item.getJSONArray("images")
//
                for(i in 0 until images.length()){
                    var imagesJson : JSONObject = images.getJSONObject(i)
                    listImage.add(imagesJson.getString("imgUrl"))
                }


                var product = Product(
                    item.getInt("id"),
                    vendor,
                    item.getString("productName"),
                    item.getString("productDescription"),
                    category,
                    item.getBoolean("hasVariations"),
                    item.getDouble("unitPrice"),
                    item.getInt("stock"),
                    item.getString("size"),
                    item.getString("notes"),
                    item.getInt("status"),
                    listVariation,
                    listImage,
                    listReviews,
                    item.getString("createdAt"),
                    item.getString("updatedAt"),
                    item.getString("sku")
                )






                vendorList.add(vendor)
                productList.add(product)

            }
            vendorData.value = vendorList
            productData.value = productList
        }, { error ->
            error.printStackTrace()
        })

        requestQueue.add(jsonArrayRequest)
    }

    fun getVendorLiveData(): MutableLiveData<MutableList<Vendor>> {
        return vendorData
    }

    fun getProductLiveData(): MutableLiveData<MutableList<Product>> {
        return productData
    }
}
