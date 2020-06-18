package com.application.e_news.roomDB

import androidx.room.TypeConverter
import com.application.e_news.models.Source

class ArticleEntityConverter {

    @TypeConverter
    fun fromSource(source: Source): String {
        return source.name
    }

    @TypeConverter
    fun toSource(str: String): Source {
        return Source(str, str)
    }

    @TypeConverter
    fun fromAuthor(author: Any): String {
        return author.toString()
    }

    @TypeConverter
    fun toAuthor(author: String): Any {
        return author
    }
}