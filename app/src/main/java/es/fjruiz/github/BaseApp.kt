package es.fjruiz.github

import android.app.Activity
import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import es.fjruiz.github.di.component.DaggerAppComponent
import javax.inject.Inject

class BaseApp : Application(),
    HasActivityInjector {

    //region Static
    companion object {
        val TAG = BaseApp::class.java.simpleName
    }
    //endregion

    //region Inject
    @Inject
    lateinit var activityInjector : DispatchingAndroidInjector<Activity>
    //endregion

    //region Bind

    //endregion

    //region Fields

    //endregion

    //region Constructors & Initialization
    override fun onCreate() {
        injectMembers()
        super.onCreate()
    }
    //endregion

    //region Methods for/from SuperClass/Interfaces
    override fun activityInjector(): AndroidInjector<Activity> = activityInjector

    //endregion

    //region Methods

    //endregion

    //region Private methods
    private fun injectMembers() {
        DaggerAppComponent
            .builder()
            .application(this)
            .build().inject(this)
    }
    //endregion

    //region Inner and Anonymous Classes

    //endregion

    //region Getter & Setter

    //endregion

}