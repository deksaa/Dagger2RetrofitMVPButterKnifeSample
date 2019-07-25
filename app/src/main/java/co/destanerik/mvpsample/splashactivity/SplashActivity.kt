package co.destanerik.mvpsample.splashactivity

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import butterknife.BindView
import butterknife.ButterKnife
import co.destanerik.mvpsample.R
import co.destanerik.mvpsample.util.dateutil.DateTimeHelperModule
import co.destanerik.mvpsample.util.intentutil.IntentModule
import javax.inject.Inject

class SplashActivity : AppCompatActivity(), SplashActivityContract.View {

    @BindView(R.id.datetimeOfTheDayTV)
    lateinit var dateTimeTV: TextView

    @Inject
    lateinit var mPresenter: SplashActivityPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_activity)

        DaggerSplashActivityComponent.builder()
            .intentModule(IntentModule(activity = this))
            .dateTimeHelperModule(DateTimeHelperModule())
            .splashActivityModule(SplashActivityModule())
            .build().inject(this)

        this.mPresenter.setView(this)
        this.mPresenter.initializeSplashScreen()
    }

    override fun initViews() {
        ButterKnife.bind(this)
    }

    override fun finishActivity() {
        this.finish()
    }

    override fun setDateTimeOfDayTextView(dateTime: String) {
        dateTimeTV.text = dateTime
    }
}