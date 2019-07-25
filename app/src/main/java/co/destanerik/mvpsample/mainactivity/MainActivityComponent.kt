package co.destanerik.mvpsample.mainactivity

import co.destanerik.mvpsample.app.AppModule
import co.destanerik.mvpsample.splashactivity.SplashActivityModule
import co.destanerik.mvpsample.util.dateutil.DateTimeHelper
import co.destanerik.mvpsample.util.dateutil.DateTimeHelperModule
import co.destanerik.mvpsample.util.intentutil.IntentHelper
import co.destanerik.mvpsample.util.intentutil.IntentModule
import dagger.Component

@Component(modules = [(AppModule::class),
                        (IntentModule::class),
                        (DateTimeHelperModule::class),
                        (MainActivityModule::class)])
interface MainActivityComponent {
    fun inject(mainActivity : MainActivity)
}