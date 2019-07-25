package co.destanerik.mvpsample.util.handlerutil

import android.os.Handler

class HandlerManager {

    companion object{
        val DURATION = 1500L
    }

    fun providePostDelayedHandler(callback: HandlerCallback, duration: Long)
    {
        Handler().postDelayed({ callback.onCompleted() }, duration)
    }
}