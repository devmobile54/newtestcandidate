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

import android.annotation.SuppressLint
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.text_view_item.view.*
import mobileapp.com.newtestcandidate.R
import mobileapp.com.newtestcandidate.model.DataModel
import org.json.JSONObject


class ListAdapter(private var mContext: Context, val callback: () -> Unit)
    : RecyclerView.Adapter<ListAdapter.ViewHolder>() {


    private lateinit var dataList: MutableList<DataModel>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(mContext)
                .inflate(R.layout.text_view_item, parent, false)
        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(dataList[position])

    }

    override fun getItemCount(): Int = dataList.size

    fun setData(list: List<DataModel>) {
        dataList = mutableListOf()
        dataList.addAll(list)
        notifyDataSetChanged()
    }

    class ViewHolder(view: View)
        : RecyclerView.ViewHolder(view) {
        @SuppressLint("SetTextI18n")
        fun bindView(item: DataModel) {
            itemView.tv_content.text = "${adapterPosition+1} : ${item.docType}"
        }


    }


}
