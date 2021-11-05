package com.ddona.network.paser

import com.ddona.network.model.News
import org.xmlpull.v1.XmlPullParser
import org.xmlpull.v1.XmlPullParserFactory
import java.net.URL
import javax.net.ssl.HttpsURLConnection

//singleton pattern
object NewsParser {

    fun parserNews(link: String): List<News> {
        val listNews = arrayListOf<News>()

        val url = URL(link)
        val connection = url.openConnection() as HttpsURLConnection
        val inputStream = connection.inputStream

        val xmlPullParserFactory = XmlPullParserFactory.newInstance()
        val xmlPullParser = xmlPullParserFactory.newPullParser()
        xmlPullParser.setInput(inputStream, "utf-8")

        val type = xmlPullParser.eventType

        var news = News()
        var text = ""
        while (type != XmlPullParser.END_DOCUMENT) {
            //tiếp tục đọc
            when (type) {
                XmlPullParser.START_TAG -> {
                    val tag = xmlPullParser.name
                    if (tag == "item") {
                        news = News()
                    } else if (tag == "img") {
                        val img = xmlPullParser.getAttributeValue(null, "src")
                        news.image = img
                    }
                }
                XmlPullParser.TEXT -> {
                    text = xmlPullParser.text
                }
                XmlPullParser.END_TAG -> {
                    when (xmlPullParser.name) {
                        "title" -> {
                            news.title = text
                        }
                        "description" -> {
                            news.description = text
                        }
                        "link" -> {
                            news.link = text
                        }
                        "item" -> {
                            listNews.add(news)
                        }
                        "pubDate" -> {
                            news.pubDate = text
                        }
                    }
                }
            }
            xmlPullParser.next()
        }
        return listNews
    }
}