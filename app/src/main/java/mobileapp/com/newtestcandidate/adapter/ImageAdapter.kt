/*
 * Copyright (C) 2015 Paul Burke
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package mobileapp.com.newtestcandidate.adapter

import android.content.Context
import android.graphics.Bitmap
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.google.gson.JsonArray
import kotlinx.android.synthetic.main.image_view_item.view.*
import mobileapp.com.newtestcandidate.R
import mobileapp.com.newtestcandidate.extensions.toBitmap
import org.json.JSONArray


class ImageAdapter(private var mContext: Context)
    : RecyclerView.Adapter<ImageAdapter.ViewHolder>() {


    private var dataList: JSONArray = JSONArray()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(mContext)
                .inflate(R.layout.image_view_item, parent, false)
        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val positionImage = if (position % 2 == 0) 0 else 1
        holder.bindView(dataList[positionImage].toString().toBitmap())

    }

        override fun getItemCount(): Int = if (dataList.length()>0) 50 else 0
//    override fun getItemCount(): Int = if (dataList.isNotEmpty()) 50 else 0


    fun setData(list: JSONArray) {
        dataList = (list)
        notifyDataSetChanged()
    }

    class ViewHolder(private val view: View)
        : RecyclerView.ViewHolder(view) {
        fun bindView(item: Bitmap) {
//            itemView.imv_view.setImageBitmap(item)
            Glide.with(view.context)
                    .load(item)
                    .centerCrop()
                    .into(itemView.imv_view)

        }


    }


}
