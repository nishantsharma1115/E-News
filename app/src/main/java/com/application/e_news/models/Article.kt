package com.application.e_news.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "news_articles"
)
data class Article(
    @PrimaryKey(autoGenerate = true)
    val id : Int? = null,
    val author: Any,
    val content: Any,
    val description: String,
    val publishedAt: String,
    val source: Source,
    val title: String,
    val url: String,
    val urlToImage: String
)