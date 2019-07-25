package co.destanerik.mvpsample.app

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(context: Context) {

    private val mContext = context

    @Provides
    fun provideContext(): Context{
        return this.mContext
    }

}