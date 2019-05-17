package com.nt.nike

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_login.*


class LoginActivity : AppCompatActivity() {

    private var animationBtLogin: Animation? = null
    private var animationApplogo: Animation? = null
    private var animationEditUserID: Animation? = null
    private var animationEditPassword: Animation? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        animationApplogo = AnimationUtils.loadAnimation(
            applicationContext, R.anim.top_to_original
        )
        animationEditUserID = AnimationUtils.loadAnimation(
            applicationContext, R.anim.top_to_original
        )
        animationEditPassword = AnimationUtils.loadAnimation(
            applicationContext, R.anim.top_to_original
        )

        animationBtLogin = AnimationUtils.loadAnimation(
            applicationContext, R.anim.bottom_to_original
        )

        onBounce(ivApplogo, animationApplogo!!)

        animationApplogo!!.setAnimationListener(object : Animation.AnimationListener {

            override fun onAnimationStart(animation: Animation) {

            }

            override fun onAnimationRepeat(animation: Animation) {}

            override fun onAnimationEnd(animation: Animation) {

                ivApplogo.clearAnimation()
                onBounce(editUserID, animationEditUserID!!)
                editUserID.visibility = View.VISIBLE

            }

        })

        animationEditUserID!!.setAnimationListener(object : Animation.AnimationListener {

            override fun onAnimationStart(animation: Animation) {

            }

            override fun onAnimationRepeat(animation: Animation) {}

            override fun onAnimationEnd(animation: Animation) {

                editUserID.clearAnimation()
                onBounce(editPassword, animationEditPassword!!)
                editPassword.visibility = View.VISIBLE

            }

        })

        animationEditPassword!!.setAnimationListener(object : Animation.AnimationListener {

            override fun onAnimationStart(animation: Animation) {

            }

            override fun onAnimationRepeat(animation: Animation) {}

            override fun onAnimationEnd(animation: Animation) {

                editPassword.clearAnimation()
                onBounce(btLogin, animationBtLogin!!)
                btLogin.visibility = View.VISIBLE
            }

        })

        btLogin.setOnClickListener {
            val intent = Intent(this@LoginActivity, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
            this@LoginActivity.finish()
        }
    }

    private fun onBounce(view: View, myAnim: Animation) {
        val interpolator = MyBounceInterpolator(0.2, 4.0)
        myAnim.interpolator = interpolator
        view.animation = myAnim
    }
}
