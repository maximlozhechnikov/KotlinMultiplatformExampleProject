package com.example.exampleproject.android.activities

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

    override fun showWebViewScreen() {
        TODO("Not yet implemented")
    }
}