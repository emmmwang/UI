package com.example.ui

import android.view.View

class MyView {
    //1.定义接受回调的函数
    var callBack: ((String) -> Unit)? =null     //unit  和Java的void类型差不多函数不需要返回值

    //2.事件触发
    fun performClick(){
        callBack?.let {
            it("user:wxw") }
    }


}