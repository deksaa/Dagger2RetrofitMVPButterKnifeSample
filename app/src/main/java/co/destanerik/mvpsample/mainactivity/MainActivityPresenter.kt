package co.destanerik.mvpsample.mainactivity

import co.destanerik.mvpsample.constants.ErrorMessages
import co.destanerik.mvpsample.model.DailyStory
import co.destanerik.mvpsample.repository.DailyStoryRepository
import co.destanerik.mvpsample.service.ResponseCallback
import co.destanerik.mvpsample.util.dateutil.DateTimeHelper
import co.destanerik.mvpsample.util.intentutil.IntentHelper
import retrofit2.Call
import javax.inject.Inject

class MainActivityPresenter @Inject constructor() : MainActivityContract.Presenter {

    lateinit var mView: MainActivityContract.View

    @Inject
    lateinit var mRepo : DailyStoryRepository

    @Inject
    lateinit var mIntentHelper: IntentHelper

    @Inject
    lateinit var mDateTimeHelper: DateTimeHelper

    override fun setView(view: MainActivityContract.View) {
        mView = view
    }

    override fun initializeMainActivityScreen() {
        mView.initViews()
        mView.hideProgress()
        mView.setDateTimeOfDayTextView(getDateOfDay())
    }

    override fun getData() {

        mView.hideHistoryOfDayMessage()
        mView.showProgress()

        mRepo.getDailyStory(mDateTimeHelper.getCurrentDay(), mDateTimeHelper.getCurrentMonth(), object : ResponseCallback<DailyStory>{
            override fun onSuccess(call: Call<DailyStory>, response: DailyStory) {
                mView.setHistoryOfDayTextView(response.text ?: ErrorMessages.GENERAL_ERROR)
                mView.hideProgress()
                mView.showHistoryOfDayMessage()
            }

            override fun onFailure(call: Call<DailyStory>, t: Throwable) {
                mView.setHistoryOfDayTextView(ErrorMessages.GENERAL_ERROR)
                mView.hideProgress()
                mView.showHistoryOfDayMessage()
            }
        })
    }

    override fun getDateOfDay(): String {
        return mDateTimeHelper.getCurrentDate()
    }



}