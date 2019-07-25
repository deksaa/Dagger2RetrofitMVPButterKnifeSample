package co.destanerik.mvpsample.splashactivity

import co.destanerik.mvpsample.util.handlerutil.HandlerManager
import dagger.Module
import dagger.Provides

@Module
class SplashActivityModule {

    @Provides
    fun provideHandlerManager(): HandlerManager{
        return HandlerManager()
    }

}