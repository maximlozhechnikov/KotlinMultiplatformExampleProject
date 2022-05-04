package com.example.exampleproject.app.ui.presenters

import com.example.exampleproject.app.ui.views.MainView
import com.example.exampleproject.domain.Injector
import com.petersamokhin.vksdk.core.error.VkResponseException
import kotlinx.coroutines.launch

class MainPresenter(view: MainView, injector: Injector): BasePresenter<MainView>(view, injector) {

    init {
        launch {
            try{ vkRepository.getCurrentUserData()?.let(view::setUserInfo) }
            catch (e: VkResponseException) {
                profileStorage.token = null
                profileStorage.expiresDateInTimestamp = null
                view.showLoginScreen()
            }
        }
    }

}