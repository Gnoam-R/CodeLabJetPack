package com.example.repository_ex_04_05.data

/**
 * Videos represent a devbyte that can be played.
 */
data class DevByteVideo(val title: String,
                        val description: String,
                        val url: String,
                        val updated: String,
                        val thumbnail: String) {

    /**
     * Short description is used for displaying truncated descriptions in the UI
     */

//    val shortDescription: String
//        get() = description.smartTruncate(200)
}