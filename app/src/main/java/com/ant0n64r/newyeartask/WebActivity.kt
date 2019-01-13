package com.ant0n64r.newyeartask

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_web.*
import kotlinx.android.synthetic.main.activity_web.view.*

class WebActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)

        webView.setWebViewClient(WebViewClient())
        webView.loadUrl(intent.getStringExtra("LINK"))
    }
}
