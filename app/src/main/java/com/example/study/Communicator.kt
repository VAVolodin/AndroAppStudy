package com.example.study

import android.view.View

interface Communicator {
    fun passString(key: String,strArray:Array<String>)
}

interface Datatransfer {

    fun passData(view: View)
}