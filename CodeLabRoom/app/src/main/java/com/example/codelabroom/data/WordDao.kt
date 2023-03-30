package com.example.codelabroom.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

/**
 * [DAO] 는 인터페이스 입니다. DAO는 인터페이스 또는 추상 클래스이여야 합니다
 *
 * @Upate 주석도 있음
 *
 * */

@Dao
interface WordDao {

    /**
     * 모든 단어를 알파뱃 순으로 정렬
     * */
    @Query("SELECT * FROM word_table ORDER BY word ASC")
    fun getAlphabetizedWords(): Flow<List<Word>>

    /**
     * 단어 삽입
     * 선택된 onConflict 전략은 이미 목록에 있는 단어와 정확하게 같다면 새 단어를 무시합니다.
     * */
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(word: Word)

    /**
     * 모든 단어 삭제
     * */
    @Query("DELETE FROM word_table")
    suspend fun deleteAll()


    /**
     * 데이터 변경 사항 관찰
     * */
//    @Query("SELECT * FROM word_table ORDER BY word ASC")
//    fun getAlphabetizedWords(): Flow<List<Word>>
}