package com.ddona.network.paser

import com.ddona.network.model.Photo
import org.json.JSONArray
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.net.URL

object PhotoParser {

    fun getAllPhoto(link: String): List<Photo> {
        val photos = arrayListOf<Photo>()

        val url = URL(link)
        val connection = url.openConnection()
        val inputStream = connection.getInputStream()

        val br = BufferedReader(InputStreamReader(inputStream))
        val data = StringBuilder()//hold all string
        var line = br.readLine()
        while (line != null) {
            data.append(line)
            line = br.readLine()
        }

        val tempPhotos = JSONArray(data.toString())
        for (i in 0 until tempPhotos.length()) {
            val tempPhoto = tempPhotos[i] as JSONObject
            val albumId = tempPhoto.getInt("albumId")
            val id = tempPhoto.getInt("id")
            val title = tempPhoto.getString("title")
            val pUrl = tempPhoto.getString("url")
            val thumbnailUrl = tempPhoto.getString("thumbnailUrl")
            photos.add(Photo(albumId, id, thumbnailUrl, title, pUrl))
        }

        return photos
    }
}