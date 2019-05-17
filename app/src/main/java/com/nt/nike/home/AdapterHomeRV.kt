package com.nt.nike.home

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nt.nike.R

class AdapterHomeRV(var context: Context, private var viewList: ArrayList<Int>) :
    RecyclerView.Adapter<AdapterHomeRV.ViewHolder>() {

    private val TOPPERFORMERVIEW = 1
    private val BETOPPERFORMERVIEW = 2

    private var mCallback: OnCallback? = null


    fun setCallback(mCallback: OnCallback) {
        this.mCallback = mCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolder {
        /*var view = LayoutInflater.from(parent.context).inflate(R.layout.layout_home_rv_top_performer, parent, false)
        return ViewHolder(view)*/
        val inflater = LayoutInflater.from(parent.context)
        return when (p1) {
            TOPPERFORMERVIEW -> ViewHolderAdmin(inflater.inflate(R.layout.layout_home_rv_top_performer, null))
            else -> ViewHolderUser(inflater.inflate(R.layout.layout_home_rv_be_top_performer, null))
        }
    }

    override fun getItemCount(): Int {
        return viewList.size
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, postion: Int) {

        when (viewHolder.itemViewType) {
            TOPPERFORMERVIEW -> {
                val viewHolderAdmin = viewHolder as ViewHolderAdmin
                // viewHolderAdmin.tvAdminMessage.text = chat.message
            }
            else -> {
                val viewHolderUser = viewHolder as ViewHolderUser
                //viewHolderUser.tvUserMessage.text = chat.message

            }
        }

        /*var itemList = itemList[postion]
        viewHolder.ivIcon.setImageResource(itemList.icon)
        viewHolder.tvTitle.text = itemList.title
        viewHolder.tvTitleSlogan.text = itemList.titleSlogan

        viewHolder.itemView.setOnClickListener {
            mCallback!!.onViewClick(itemList.title, postion)
        }*/

    }

    override fun getItemViewType(position: Int): Int {
        return when (viewList[position]) {
            1 -> TOPPERFORMERVIEW
            else -> BETOPPERFORMERVIEW
        }

    }

    open inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    }


    inner class ViewHolderAdmin(itemView: View) : ViewHolder(itemView) {
        // var tvAdminMessage: TextView = itemView.findViewById(R.id.tvAdminMessage)
    }

    inner class ViewHolderUser(itemView: View) : ViewHolder(itemView) {
        //var tvUserMessage: TextView = itemView.findViewById(R.id.tvUserMessage)
    }

    interface OnCallback {
        fun onViewClick(message: String, postion: Int)
    }

}