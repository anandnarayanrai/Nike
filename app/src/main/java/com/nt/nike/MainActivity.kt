package com.nt.nike

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.ImageView
import com.nt.nike.home.HomeFragment
import com.nt.nike.myTeam.MyTeamFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.layout_header.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private val TAG = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        layoutHome.setOnClickListener(this)
        layoutTeam.setOnClickListener(this)
        layoutMessage.setOnClickListener(this)
        layoutAthletes.setOnClickListener(this)
        loadFragment(HomeFragment())
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.layoutHome -> {
                loadFragment(HomeFragment())
                isSelected(0)
            }
            R.id.layoutTeam -> {
                loadFragment(MyTeamFragment())
                isSelected(1)
            }
            R.id.layoutMessage -> {
                isSelected(2)

            }
            R.id.layoutAthletes -> {
                isSelected(3)

            }
        }
    }

    private fun loadFragment(fragment: Fragment) {
        // load fragment
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame_container, fragment)
        //transaction.addToBackStack(null)
        transaction.commit()
    }

    private fun isSelected(selectedItem: Int) {

        when (selectedItem) {
            0 -> {
                tvScreenTitle.text = "Home"
                onRotation(ivHome)
                ivHome.setImageResource(R.drawable.ic_home_selected)
                ivTeam.setImageResource(R.drawable.ic_group_unselected)
                ivMessage.setImageResource(R.drawable.ic_message_unselected)
                ivAthletes.setImageResource(R.drawable.ic_marathon_unselected)

                tvHome.setTextColor(resources.getColor(R.color.colorSelectedItem))
                tvTeam.setTextColor(resources.getColor(R.color.colorPrimaryDark))
                tvMessage.setTextColor(resources.getColor(R.color.colorPrimaryDark))
                tvAthletes.setTextColor(resources.getColor(R.color.colorPrimaryDark))
            }
            1 -> {
                tvScreenTitle.text = "My Team"
                onBounce(ivTeam)
                ivHome.setImageResource(R.drawable.ic_home_unselected)
                ivTeam.setImageResource(R.drawable.ic_group_selected)
                ivMessage.setImageResource(R.drawable.ic_message_unselected)
                ivAthletes.setImageResource(R.drawable.ic_marathon_unselected)

                tvHome.setTextColor(resources.getColor(R.color.colorPrimaryDark))
                tvTeam.setTextColor(resources.getColor(R.color.colorSelectedItem))
                tvMessage.setTextColor(resources.getColor(R.color.colorPrimaryDark))
                tvAthletes.setTextColor(resources.getColor(R.color.colorPrimaryDark))
            }
            2 -> {
                tvScreenTitle.text = "My Message"
                onRotation(ivMessage)
                ivHome.setImageResource(R.drawable.ic_home_unselected)
                ivTeam.setImageResource(R.drawable.ic_group_unselected)
                ivMessage.setImageResource(R.drawable.ic_message_selected)
                ivAthletes.setImageResource(R.drawable.ic_marathon_unselected)

                tvHome.setTextColor(resources.getColor(R.color.colorPrimaryDark))
                tvTeam.setTextColor(resources.getColor(R.color.colorPrimaryDark))
                tvMessage.setTextColor(resources.getColor(R.color.colorSelectedItem))
                tvAthletes.setTextColor(resources.getColor(R.color.colorPrimaryDark))
            }
            3 -> {
                tvScreenTitle.text = "Top Athletes"
                onBounce(ivAthletes)
                ivHome.setImageResource(R.drawable.ic_home_unselected)
                ivTeam.setImageResource(R.drawable.ic_group_unselected)
                ivMessage.setImageResource(R.drawable.ic_message_unselected)
                ivAthletes.setImageResource(R.drawable.ic_marathon_selected)

                tvHome.setTextColor(resources.getColor(R.color.colorPrimaryDark))
                tvTeam.setTextColor(resources.getColor(R.color.colorPrimaryDark))
                tvMessage.setTextColor(resources.getColor(R.color.colorPrimaryDark))
                tvAthletes.setTextColor(resources.getColor(R.color.colorSelectedItem))
            }
        }

    }

    private fun onRotation(selectedView: ImageView) {
        val rotation = AnimationUtils.loadAnimation(this, R.anim.rotation)
        selectedView.startAnimation(rotation)
    }

    private fun onBounce(selectedView: View) {
        var myAnim = AnimationUtils.loadAnimation(applicationContext, R.anim.bounce)
        val interpolator = MyBounceInterpolator(0.2, 20.0)
        myAnim.interpolator = interpolator
        selectedView.animation = myAnim
    }

}
