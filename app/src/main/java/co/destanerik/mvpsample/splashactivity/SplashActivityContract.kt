package co.destanerik.mvpsample.splashactivity

interface SplashActivityContract {

    interface View{

        fun finishActivity()

        fun initViews()

        fun setDateTimeOfDayTextView(dateTime: String)

    }

    interface Presenter{

        fun setView(view: View)

        fun initializeSplashScreen()
    }
}