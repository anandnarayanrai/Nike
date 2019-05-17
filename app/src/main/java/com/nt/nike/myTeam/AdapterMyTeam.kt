package com.nt.nike.myTeam

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nt.nike.R

class AdapterMyTeam(var context: Context) :
    RecyclerView.Adapter<AdapterMyTeam.ViewHolder>() {
    private var mCallback: OnCallback? = null


    fun setCallback(mCallback: OnCallback) {
        this.mCallback = mCallback
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        var view = LayoutInflater.from(p0.context).inflate(R.layout.layout_myteam_rv, p0, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return 10
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, postion: Int) {
        /*var itemList = itemList[postion]
        viewHolder.ivIcon.setImageResource(itemList.icon)
        viewHolder.tvTitle.text = itemList.title
        viewHolder.tvTitleSlogan.text = itemList.titleSlogan

        viewHolder.itemView.setOnClickListener {
            mCallback!!.onViewClick(itemList.title, postion)
        }*/

    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    interface OnCallback {
        fun onViewClick(message: String, postion: Int)
    }

}