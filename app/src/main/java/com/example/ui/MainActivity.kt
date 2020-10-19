package com.example.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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
class MainActivity : AppCompatActivity()
        /*View.OnClickListener*/
{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //当有id时 可以直接通过id访问控件-----kotlin

        //当id不明确时 可以通过tag访问控件
        val mView:View = container.findViewWithTag<View>("1")
        mView.alpha=1f
        mView.background=getDrawable(R.color.colorAccent)

        //2.通过实现接口来实现监听事件  回调给这个类的对象本身      自己来监听事件
        //mView.setOnClickListener(this)

        //3.声明一个类  实现一个对应的接口和方法                  别人监听
        //mView.setOnClickListener(MyListener())

        //4.匿名内部类                                           若监听者里面有很多方法就用这种
        /*
        mView.setOnClickListener(object :View.OnClickListener{
            override fun onClick(v: View?) {
                v?.background=getDrawable(R.color.colorPrimary)
            }

        })*/

        //5.如果实现的接口只有一个  可以使用lambda表达式
        /*
        mView.setOnClickListener({v:View?->
            v?.background=getDrawable(R.color.colorPrimary)
        })*/

        //6.如果这个方法的最后一个参数是lambda表达式 呢么这个表达式可以放在括号外边
        /*
        mView.setOnClickListener{v:View?->
            v?.background=getDrawable(R.color.colorPrimary)
        }*/

        //c创建对象
        val myView=MyView()
        //接收回调
        myView.callBack={
            Log.v("wxw","主页接受到回调的数据：$it")
        }

        //7.如果方法只有一个参数  参数可以省略
        mView.setOnClickListener{
            it.background=getDrawable(R.color.colorPrimary)
            myView.performClick()
        }
    }

    inner class MyListener:View.OnClickListener{
        override fun onClick(v: View?) {
            v?.background=getDrawable(R.color.colorPrimary)
        }

    }

    /**
     *  //通过onClick设置点击事件
    fun changeBg(view: View) {
    view.background=getDrawable(R.color.colorPrimary)
    }
      */


   /*
    override fun onClick(v: View?) {

        v?.background=getDrawable(R.color.colorPrimary)
    }
*/

}