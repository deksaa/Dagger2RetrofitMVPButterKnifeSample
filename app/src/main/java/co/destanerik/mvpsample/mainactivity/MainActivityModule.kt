package co.destanerik.mvpsample.mainactivity

import co.destanerik.mvpsample.repository.DailyStoryRepository
import dagger.Module
import dagger.Provides

@Module
class MainActivityModule {

    @Provides
    fun provideDailyStoryRepository() : DailyStoryRepository
    {
        return DailyStoryRepository()
    }

}