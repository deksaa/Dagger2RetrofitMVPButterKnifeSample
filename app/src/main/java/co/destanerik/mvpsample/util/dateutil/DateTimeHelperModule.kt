package co.destanerik.mvpsample.util.dateutil

import dagger.Module
import dagger.Provides

@Module
class DateTimeHelperModule {

    @Provides
    fun provideDateTimeHelper(): DateTimeHelper{
        return DateTimeHelper()
    }
}