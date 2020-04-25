package com.black.androidlearning.utils

import android.util.Log

/**
 * Created by farhanahmad on 25/4/20.
 */

object Logger {
    fun i(tag: String, msg: String) {
        Log.i(tag, msg)
    }

    fun e(tag: String, msg: String) {
        Log.e(tag, msg)
    }
}