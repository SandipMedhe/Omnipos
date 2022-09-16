package com.example.task.di

import android.app.Application
import androidx.room.Room
import com.example.task.data.repository.BusinessAddressRepositoryImpl
import com.example.task.data.repository.BusinessDetailsRepositoryImpl
import com.example.task.data.repository.UserRepositoryImpl
import com.example.task.data.source.UserDatabase
import com.example.task.domain.repository.BusinessAddressRepository
import com.example.task.domain.repository.BusinessDetailsRepository
import com.example.task.domain.repository.UserRepository
import com.example.task.util.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
//AppModule to provide the dependencies of repository and created instance of database
@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    //This function provide the user database to the user
    @Provides
    @Singleton
    fun provideUserDatabase(app: Application) = Room.databaseBuilder(
        app,
        UserDatabase::class.java,
        DATABASE_NAME
    ).build()

    //this function provide the repository to all places where we have injected the @Inject annotation for repository
    @Provides
    @Singleton
    fun provideRepository(db: UserDatabase): UserRepository {
        return UserRepositoryImpl(db.userDao)
    }

    @Provides
    @Singleton
    fun provideDetailsRepository(db: UserDatabase): BusinessDetailsRepository {
        return BusinessDetailsRepositoryImpl(db.bsDetailsDao)
    }

    @Provides
    @Singleton
    fun provideAddressRepository(db: UserDatabase): BusinessAddressRepository {
        return BusinessAddressRepositoryImpl(db.bsAddressDao)
    }

}