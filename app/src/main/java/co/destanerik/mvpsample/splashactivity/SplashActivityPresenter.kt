package co.destanerik.mvpsample.splashactivity

import co.destanerik.mvpsample.mainactivity.MainActivity
import co.destanerik.mvpsample.util.dateutil.DateTimeHelper
import co.destanerik.mvpsample.util.handlerutil.HandlerCallback
import co.destanerik.mvpsample.util.handlerutil.HandlerManager
import co.destanerik.mvpsample.util.intentutil.IntentHelper
import javax.inject.Inject

class SplashActivityPresenter @Inject constructor() : SplashActivityContract.Presenter {

    private lateinit var mView: SplashActivityContract.View

    @Inject
    lateinit var mHandlerManager: HandlerManager

    @Inject
    lateinit var mIntentHelper: IntentHelper

    @Inject
    lateinit var mDateTimeHelper: DateTimeHelper

    override fun setView(view: SplashActivityContract.View) {
        mView = view
    }

    override fun initializeSplashScreen() {
        mView.initViews()
        mView.setDateTimeOfDayTextView(getDateTimeOfDay())

        this.mHandlerManager.providePostDelayedHandler(object : HandlerCallback
        {
            override fun onCompleted()
            {
                mIntentHelper.openActivity(MainActivity::class.java)
                mView.finishActivity()
            }
        }, 2000)
    }

    private fun getDateTimeOfDay() : String {
        return mDateTimeHelper.getCurrentDateTime()
    }

}