package es.fjruiz.github.di.component

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import es.fjruiz.github.BaseApp
import es.fjruiz.github.di.modules.AppModule
import javax.inject.Singleton

@Singleton
@Component(modules= [AppModule::class, FragmentBuilder::class , AndroidInjectionModule::class, ActivityBuilder::class])
interface AppComponent {

    @Component.Builder
    interface Builder
    {
        @BindsInstance
        fun application(application: BaseApp): Builder

        fun build(): AppComponent
    }

    fun inject (app: BaseApp)
}