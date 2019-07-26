package es.fjruiz.github.di.modules

import dagger.Module
import dagger.Provides
import es.fjruiz.data.net.RestApi
import es.fjruiz.data.net.RestApiImpl
import es.fjruiz.data.repository.UserRepositoryImpl
import es.fjruiz.data.repository.datasource.UserDataStoreFactory
import es.fjruiz.domain.repository.UserRepository
import javax.inject.Singleton

// TODO: 26/07/19 Don't make dependency injection in app module, try to move to another module
@Module
class DataModule {

    //region Api

    @Provides
    @Singleton
    fun provideRestApi(): RestApi {
        return RestApiImpl()
    }
    //endregion

    //region Cache

    //endregion

    //region DataStore

    //endregion

    //region

    //region Repository
    @Provides
    @Singleton
    fun provideUserRepository(dataStoreFactory: UserDataStoreFactory): UserRepository {
        return UserRepositoryImpl(dataStoreFactory)
    }
    //endregion

    //region Storage

    //endregion


}