package com.example.repository_ex_04_05.data

import androidx.lifecycle.LiveData

interface Repository {
    var videos : LiveData<List<DevByteVideo>>
}