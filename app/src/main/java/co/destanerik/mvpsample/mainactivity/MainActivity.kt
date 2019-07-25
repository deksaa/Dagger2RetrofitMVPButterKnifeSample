package co.destanerik.mvpsample.mainactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import co.destanerik.mvpsample.R
import co.destanerik.mvpsample.app.AppModule
import co.destanerik.mvpsample.util.dateutil.DateTimeHelperModule
import co.destanerik.mvpsample.util.intentutil.IntentModule
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainActivityContract.View {

    @BindView(R.id.dateNowTV)
    lateinit var dateTV: TextView

    @BindView(R.id.historyOfTheDayTV)
    lateinit var historyOfTheDayTV: TextView

    @BindView(R.id.getDataBT)
    lateinit var getDataBT: Button

    @BindView(R.id.progressBar)
    lateinit var progressBarPB : ProgressBar

    @Inject
    lateinit var mMainPresenter : MainActivityPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        DaggerMainActivityComponent.builder()
            .appModule(AppModule(this))
            .intentModule(IntentModule(activity = this))
            .dateTimeHelperModule(DateTimeHelperModule())
            .build().inject(this)

        mMainPresenter.mView = this
        mMainPresenter.initializeMainActivityScreen()
    }

    override fun initViews() {
        ButterKnife.bind(this)
    }

    override fun setDateTimeOfDayTextView(date: String) {
        dateTV.text = "Today: $date"
    }

    override fun setHistoryOfDayTextView(text: String) {
        historyOfTheDayTV.text = text
    }

    override fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun showHistoryOfDayMessage() {
        historyOfTheDayTV.visibility = View.VISIBLE
    }

    override fun hideHistoryOfDayMessage() {
        historyOfTheDayTV.visibility = View.INVISIBLE
    }

    override fun showProgress() {
        progressBarPB.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        progressBarPB.visibility = View.INVISIBLE
    }

    @OnClick(R.id.getDataBT)
    fun getData()
    {
        mMainPresenter.getData()
    }
}
