package com.krystalove.newyeartask.View

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import com.krystalove.newyeartask.R
import kotlinx.android.synthetic.main.activity_web_view.*


class WebViewActivity : AppCompatActivity() {

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)

        val url = intent.getStringExtra("URL")
        webView.webViewClient = MyWebViewClient()
        webView.settings.javaScriptEnabled = true
        webView.loadUrl(url)
    }

}
private class MyWebViewClient: WebViewClient() {
    override fun shouldOverrideUrlLoading(view: WebView?, request:WebResourceRequest): Boolean {
        view!!.loadUrl(request.url.toString())
        return true
    }
}