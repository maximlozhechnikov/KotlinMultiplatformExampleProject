package com.example.exampleproject.android.activities

import android.content.Intent
import android.widget.TextView
import com.example.exampleproject.android.R
import com.example.exampleproject.app.ui.presenters.MainPresenter
import com.example.exampleproject.app.ui.views.MainView
import com.example.exampleproject.domain.entities.VkUser

class MainActivity: BaseActivity(R.layout.activity_main), MainView {
    override val presenter = providePresenter<MainPresenter, MainView>(this)
    private val firstNameTextView: TextView by bind(R.id.textview_firstname)
    private val lastNameTextView: TextView by bind(R.id.textview_lastname)

    override fun setUserInfo(user: VkUser) {
        firstNameTextView.text = user.firstName
        lastNameTextView.text = user.lastName
    }

    override fun showLoginScreen() {
        startActivity(WebPageActivity.createIntent(this,
            "https://oauth.vk.com/authorize?client_id=8135391&display=page&response_type=token"))
    }
}