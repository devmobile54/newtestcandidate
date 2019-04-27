package mobileapp.com.newtestcandidate.activity

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import mobileapp.com.newtestcandidate.R
import mobileapp.com.newtestcandidate.adapter.MenuAdapter
import android.app.Activity
import android.content.pm.PackageManager
import android.os.Build
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat


class MainActivity : AppCompatActivity() {

    private val menuList: List<String> by lazy { listOf("json", "alert", "image","camera") }


    private lateinit var adapterList: MenuAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init() {

        adapterList = MenuAdapter(this, onClick)

        with(recycler_view) {
            adapter = adapterList
            layoutManager = LinearLayoutManager(this@MainActivity)
        }

        getData()
    }


    private fun getData() {
        adapterList.setData(menuList)
    }

    @SuppressLint("ObsoleteSdkInt")
    private val onClick: (positon: Int) -> Unit = { position ->
        when (position) {
            0 -> {
                startPage(DataListActivity::class.java)
            }
            1 -> {
                startPage(AlertDialogActivity::class.java)
            }
            2 -> {
                startPage(ImageActivity::class.java)
            }
            3->{
//  TODO("Open Camera")
                if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
                        != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(this,
                            arrayOf(Manifest.permission.CAMERA),
                            0)

                }else{
                    val intent = Intent("android.media.action.IMAGE_CAPTURE")
                    startActivityForResult(intent, 0)
                }
            }
        }

    }

    private fun startPage(act: Class<*>) {
        val intentAct = Intent(this, act)
        startActivity(intentAct)
    }

    public override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        if (resultCode == Activity.RESULT_OK && requestCode == 0) {
            val result = data.toURI()
        }
    }
}
