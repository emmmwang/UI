package com.example.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

/**
 *  android:background="@mipmap/timg"    背景（图片资源  固定的颜色值 xml文件配置）
    android:alpha="0.5"                 透明度  1不透明  0全透明
    android:clickable="true"            设置这个控件是否可以被点击（和用户交互）
    android:focusable="true"            设置是否可以获得焦点
    android:tag="1"                     标签，就是一个字符串，1，记录数据 2，通过标签获取控件
    android:onClick="changeBg"          给控件添加点击事件 不建议使用（不稳定）

 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //当有id时 可以直接通过id访问控件-----kotlin

        //当id不明确时 可以通过tag访问控件
        val mView:View = container.findViewWithTag<View>("1")
        mView.alpha=1f
        mView.background=getDrawable(R.color.colorAccent)
    }

    //通过onClick设置点击事件
    fun changeBg(view: View) {
        view.background=getDrawable(R.color.colorPrimary)
    }
}