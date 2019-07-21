package es.fjruiz.github.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

abstract class BaseActivity : AppCompatActivity(), HasAndroidInjector {

    //region Static
    companion object {
        val TAG = BaseActivity::class.java.simpleName
    }
    //endregion

    //region Inject
    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>
    //endregion

    //region Bind

    //endregion

    //region Fields

    //endregion

    //region Constructors & Initialization
    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
    }
    //endregion

    //region Methods for/from SuperClass/Interfaces

    override fun androidInjector(): AndroidInjector<Any> = dispatchingAndroidInjector
    //endregion

    //region Methods

    //endregion

    //region Private methods

    //endregion

    //region Inner and Anonymous Classes

    //endregion

    //region Getter & Setter

    //endregion

}