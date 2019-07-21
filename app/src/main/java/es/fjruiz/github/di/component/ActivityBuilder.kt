package es.fjruiz.github.di.component

import dagger.Module
import dagger.android.ContributesAndroidInjector
import es.fjruiz.github.view.activity.MainActivity

@Module
abstract class ActivityBuilder {
    /**
     * @ContributesAndroidInjector can use (module = ModuleProvider.class)
     * but in this example we wont need it, so we use a null Provider
     */

    @ContributesAndroidInjector
    abstract fun bindMainActivity(): MainActivity
}