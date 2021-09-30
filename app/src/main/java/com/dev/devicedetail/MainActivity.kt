package com.dev.devicedetail

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvMain: TextView = findViewById(R.id.tv_main)

        val text = "Get Your Device Info"

        val thread: Thread = object : Thread() {
            var i = 0
            override fun run() {
                try {
                    i = 0
                    while (i < text.length) {
                        sleep(150)
                        runOnUiThread { tvMain.text = text.substring(0, i) }
                        i++
                    }
                } catch (e: InterruptedException) {
                }
            }
        }

        thread.start()

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, DeviceDetailActivity::class.java)
            startActivity(intent)
            finish()
        }, 4000)

    }

}