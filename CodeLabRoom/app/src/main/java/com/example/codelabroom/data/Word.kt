package com.example.codelabroom.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
* [Entity] 는 SQLite 테이블을 나타낸다
*
* */
@Entity(tableName = "word_table")
class Word(
    @PrimaryKey
    @ColumnInfo(name = "word") val word: String
    )
