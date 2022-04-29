package com.example.exampleproject.app.ui.presenters

import com.example.exampleproject.app.ui.views.MainView
import com.example.exampleproject.domain.Injector
import kotlinx.coroutines.launch

class MainPresenter(view: MainView, injector: Injector): BasePresenter<MainView>(view, injector) {

    init {
        launch {
            vkRepository.getCurrentUserData()?.let(view::setUserInfo)
        }
    }

}