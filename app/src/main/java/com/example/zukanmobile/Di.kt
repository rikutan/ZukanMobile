package com.example.zukanmobile

import com.google.firebase.Firebase
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.firestore
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.storage
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    // Firestoreのインスタンス依存注入 -----------------------------------------------------------------
    @Provides
    @Singleton
    fun provideFirestore(): FirebaseFirestore = Firebase.firestore

    // Storageのインスタンス依存注入 -------------------------------------------------------------------
    @Provides
    @Singleton
    fun provideStorage(): FirebaseStorage = Firebase.storage
}