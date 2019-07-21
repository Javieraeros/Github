package es.fjruiz.github.di.component

import dagger.Module
import dagger.android.ContributesAndroidInjector
import es.fjruiz.github.view.fragment.OrganizationFragment

@Module
abstract class FragmentBuilder {

    @ContributesAndroidInjector
    internal abstract fun bindOrganizationFragment(): OrganizationFragment
}