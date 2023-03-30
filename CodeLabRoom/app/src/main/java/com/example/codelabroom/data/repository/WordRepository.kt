package com.example.codelabroom.data.repository

import androidx.annotation.WorkerThread
import com.example.codelabroom.data.Word
import com.example.codelabroom.data.WordDao
import kotlinx.coroutines.flow.Flow


// Declares the DAO as a private property in the constructor. Pass in the DAO
// instead of the whole database, because you only need access to the DAO
class WordRepository (private val wordDao: WordDao){

    // Room executes all queries on a separate thread.
    // Observed Flow will notify the observer when the data has changed.
    val allWords: Flow<List<Word>> = wordDao.getAlphabetizedWords()

    // By default Room runs suspend queries off the main thread, therefore, we don't need to
    // implement anything else to ensure we're not doing long running database work
    // off the main thread.

    // 코루틴에서 사용되는 Suspend 함수로 이 어노태이션은 경고를 무시하기 위해서 사용된다.
    @Suppress("RedundantSuspendModifier")
    // 메인 스레드가 아닌 백그라운드 스레드에서 실행
    @WorkerThread
    suspend fun insert(word: Word) {
        wordDao.insert(word)
    }
}