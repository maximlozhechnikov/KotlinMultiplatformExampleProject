package com.example.exampleproject.android.activities

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import com.example.exampleproject.android.R
import com.example.exampleproject.app.ui.presenters.WebPagePresenter
import com.example.exampleproject.app.ui.views.WebPageView

@SuppressLint("SetJavaScriptEnabled")
class WebPageActivity(): BaseActivity(R.layout.activity_webview), WebPageView {

    companion object {
        private const val KEY_WEBPAGE_URL = "urlWebPage"

        fun createIntent(context: Context, url: String): Intent =
            Intent(context, WebPageActivity::class.java).apply {
                putExtra(KEY_WEBPAGE_URL, url)
            }

    }
    override val presenter: WebPagePresenter = providePresenter<WebPagePresenter, WebPageView>(this)
    private val webView: WebView by bind(R.id.webview) {
        settings.javaScriptEnabled = true
        this.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(
                view: WebView?,
                request: WebResourceRequest?
            ): Boolean {
                request?.url?.toString()?.let(presenter::onRequestIntercepted)
                return super.shouldOverrideUrlLoading(view, request)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.onScreenLoaded(intent.getStringExtra(KEY_WEBPAGE_URL) ?: "")
    }

    override fun setWebViewUrl(url: String) {
        webView.loadUrl(url)
    }

    override fun showMainScreen() {
        startActivity(Intent(
            this,
            MainActivity::class.java
        ))
    }
}