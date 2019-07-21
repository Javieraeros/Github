package es.fjruiz.github.di.modules

import android.content.Context
import dagger.Module
import dagger.Provides
import es.fjruiz.github.BaseApp
import javax.inject.Singleton

@Module(includes= [DataModule::class])
class AppModule {

    @Provides
    @Singleton
    fun provideApplication(app: BaseApp): Context = app
}