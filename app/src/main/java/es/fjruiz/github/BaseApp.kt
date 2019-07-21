package es.fjruiz.github

import android.app.Activity
import android.app.Application
import android.os.Bundle
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import es.fjruiz.github.di.component.DaggerAppComponent
import javax.inject.Inject

class BaseApp : Application(),
    Application.ActivityLifecycleCallbacks,
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

    override fun onActivityPaused(activity: Activity?) {

    }

    override fun onActivityResumed(activity: Activity?) {

    }

    override fun onActivityStarted(activity: Activity?) {

    }

    override fun onActivityDestroyed(activity: Activity?) {

    }

    override fun onActivitySaveInstanceState(activity: Activity?, outState: Bundle?) {

    }

    override fun onActivityStopped(activity: Activity?) {

    }

    override fun onActivityCreated(activity: Activity?, savedInstanceState: Bundle?) {

    }

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