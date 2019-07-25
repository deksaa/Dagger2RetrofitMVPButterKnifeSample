package co.destanerik.mvpsample.mainactivity

interface MainActivityContract {

    interface View{

        fun finishActivity(){}

        fun initViews()

        fun setDateTimeOfDayTextView(date: String)

        fun setHistoryOfDayTextView(text: String)

        fun showToast(message: String)

        fun showProgress()

        fun hideProgress()

        fun showHistoryOfDayMessage()

        fun hideHistoryOfDayMessage()

    }

    interface Presenter{

        fun setView(view: View)

        fun initializeMainActivityScreen()

        fun getDateOfDay() : String

        fun getData()
    }

}