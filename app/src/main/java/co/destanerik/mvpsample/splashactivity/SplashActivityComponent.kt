package co.destanerik.mvpsample.splashactivity

import co.destanerik.mvpsample.app.AppModule
import co.destanerik.mvpsample.util.dateutil.DateTimeHelperModule
import co.destanerik.mvpsample.util.intentutil.IntentModule
import dagger.Component

@Component(modules = [(AppModule::class),
                        (IntentModule::class),
                        (SplashActivityModule::class),
                        (DateTimeHelperModule::class)])
interface SplashActivityComponent {
    fun inject(splashActivity: SplashActivity)
}