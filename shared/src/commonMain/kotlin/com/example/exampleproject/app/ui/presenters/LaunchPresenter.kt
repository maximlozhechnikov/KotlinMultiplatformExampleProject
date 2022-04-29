package com.example.exampleproject.app.ui.presenters

import com.example.exampleproject.app.ui.views.LaunchView
import com.example.exampleproject.domain.Injector
import kotlinx.datetime.Clock

class LaunchPresenter constructor(view: LaunchView, injector: Injector): BasePresenter<LaunchView>(view, injector) {

    fun onAnimationEnd() {
        println("token ${profileStorage.token}")
        println("expiry ${profileStorage.expiresDateInTimestamp} and current ${Clock.System.now().epochSeconds}")
        profileStorage.token?.let {
            if ((profileStorage.expiresDateInTimestamp ?: -1) < Clock.System.now().epochSeconds) {
                profileStorage.token = null
                profileStorage.expiresDateInTimestamp = null
                view.showLoginScreen()
            } else {
                view.showMainScreen()
            }
        } ?: view.showLoginScreen()
    }
}