package mobileapp.com.newtestcandidate.activity

import android.graphics.Bitmap
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_image.*
import mobileapp.com.newtestcandidate.R
import mobileapp.com.newtestcandidate.adapter.ImageAdapter
import mobileapp.com.newtestcandidate.extensions.toBitmap
import mobileapp.com.newtestcandidate.utils.Utils
import org.json.JSONObject

class ImageActivity : AppCompatActivity() {

    private lateinit var adapterImage: ImageAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image)
        init()
    }

//  TODO("Performance tuning ")
    private fun init() {
        adapterImage = ImageAdapter(this)
        recycler_view.adapter = adapterImage
        recycler_view.layoutManager = GridLayoutManager(this, 3)
        getData()
    }


    private fun getData() {
        val jsonString = Utils.loadJSONFromAsset("Base64.json", this)
        val data = JSONObject(jsonString)
        adapterImage.setData(data.getJSONArray("data"))
    }


}
