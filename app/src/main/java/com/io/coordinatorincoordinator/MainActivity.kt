package com.io.coordinatorincoordinator

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.appbar.CollapsingToolbarLayout


class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val tt = findViewById<TextView>(R.id.toolbar_title)
//        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        val title = findViewById<TextView>(R.id.title_res)
        val collapsingToolbarLayout: CollapsingToolbarLayout = findViewById(R.id.colaps)
        val coord: CoordinatorLayout = findViewById(R.id.coord)


        val appBarLayout: AppBarLayout = findViewById(R.id.appbar_layout)

//        val out: Animation = AlphaAnimation(1.0f, 0.0f)
//        out.repeatCount = Animation.INFINITE
//        out.repeatMode = Animation.REVERSE
//        out.duration = 1000
//        tt.startAnimation(out)

        appBarLayout.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { appBarLayout, verticalOffset ->

            Log.e("verticalOffset", verticalOffset.toString())
            Log.e("appBarLayout", appBarLayout.totalScrollRange.toString())

            if (verticalOffset == 0) {
                tt.visibility = View.GONE
            } else {
                tt.visibility = View.VISIBLE
                tt.text = title.text.toString()
            }

            return@OnOffsetChangedListener
        })

    }


}