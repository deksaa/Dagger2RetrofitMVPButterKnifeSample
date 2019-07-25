package co.destanerik.mvpsample.util.intentutil

import android.app.Activity
import android.content.Intent

class IntentHelper(activity: Activity) {

    private val mSourceActivity = activity

    fun openActivity(activityClass: Class<*>) {
            val intent = Intent(mSourceActivity, activityClass)
            mSourceActivity.startActivity(intent)
    }
}