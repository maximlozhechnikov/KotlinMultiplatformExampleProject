package com.example.exampleproject.android.activities

import android.animation.Animator
import android.content.Intent
import android.os.Bundle
import com.airbnb.lottie.LottieAnimationView
import com.example.exampleproject.android.R
import com.example.exampleproject.app.ui.presenters.LaunchPresenter
import com.example.exampleproject.app.ui.views.LaunchView

class LaunchActivity : BaseActivity(R.layout.activity_launch), LaunchView {
    override val presenter = providePresenter<LaunchPresenter, LaunchView>(this)
    private val lottieAnimationView: LottieAnimationView by bind(R.id.lottieanimationview)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lottieAnimationView.addAnimatorListener(object: Animator.AnimatorListener {
            override fun onAnimationStart(p0: Animator?) {
                //nothing
            }

            override fun onAnimationEnd(p0: Animator?) {
                presenter.onAnimationEnd()
            }

            override fun onAnimationCancel(p0: Animator?) {
                //nothing
            }

            override fun onAnimationRepeat(p0: Animator?) {
                //nothing
            }

        })
    }

    override fun showLoginScreen() {
        startActivity(WebPageActivity.createIntent(
            this,
            "https://oauth.vk.com/authorize?client_id=8135391&display=page&response_type=token"
        ))
    }

    override fun showMainScreen() {
        startActivity(Intent(this, MainActivity::class.java))
    }


}
