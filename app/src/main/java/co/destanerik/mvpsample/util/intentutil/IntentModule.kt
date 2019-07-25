package co.destanerik.mvpsample.util.intentutil

import android.app.Activity
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class IntentModule(activity: Activity) {

    private val mActivity = activity

    @Provides
    fun provideIntentHelper(): IntentHelper{
        return IntentHelper(mActivity)
    }
}