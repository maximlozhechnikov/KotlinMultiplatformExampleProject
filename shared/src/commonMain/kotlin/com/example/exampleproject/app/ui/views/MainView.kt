package com.example.exampleproject.app.ui.views

import com.example.exampleproject.domain.entities.VkUser

interface MainView: BaseView {

    fun setUserInfo(user: VkUser)

    fun showWebViewScreen()
}