import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.housemartapplication.model.Product
import com.example.housemartapplication.model.Vendor

class ProductViewModel() : ViewModel() {

    val repository = ProductRepository()

    var vendorData: MutableLiveData<MutableList<Vendor>> =
        repository.getVendorLiveData()

    var productData: MutableLiveData<MutableList<Product>> =
        repository.getProductLiveData()

    fun getVendorLiveData(): LiveData<MutableList<Vendor>> {
        return repository.getVendorLiveData();
    }
    fun getProductLiveData(): LiveData<MutableList<Product>> {
        return repository.getProductLiveData();
    }
}
