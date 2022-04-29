package com.example.exampleproject.app.ui.presenters

import com.example.exampleproject.app.extensions.query
import com.example.exampleproject.app.ui.views.WebPageView
import com.example.exampleproject.domain.Injector
import kotlinx.datetime.Clock

class WebPagePresenter(view: WebPageView, injector: Injector): BasePresenter<WebPageView>(view, injector) {
    companion object {
        private const val KEY_QUERY_TOKEN = "access_token"
        private const val KEY_QUERY_EXPIRY_DATE = "expires_in"
    }

    fun onScreenLoaded(url: String) {
        if (url.isNotBlank()) {
            view.setWebViewUrl(url)
        } else {
            throw IllegalStateException("it cannot be null or empty url, man")
        }
    }

    fun onRequestIntercepted(url: String) {
        println(url)
        if (url.contains("blank.html#")) {
            url.query(KEY_QUERY_TOKEN)?.let{ token ->
                url.query(KEY_QUERY_EXPIRY_DATE)?.toLongOrNull()?.let { expires ->
                    profileStorage.token = token
                    profileStorage.expiresDateInTimestamp = Clock.System.now().epochSeconds + expires
                    view.showMainScreen()
                }
            }
        }
    }
}