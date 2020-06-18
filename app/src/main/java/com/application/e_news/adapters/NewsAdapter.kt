package com.application.e_news.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.application.e_news.R
import com.application.e_news.models.Article
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_article.view.*

class NewsAdapter : RecyclerView.Adapter<NewsAdapter.NewsArticleViewHolder>() {

    inner class NewsArticleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    private val differCallBack = object : DiffUtil.ItemCallback<Article>() {
        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem == newItem
        }
    }

    private val differ = AsyncListDiffer(this, differCallBack)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsArticleViewHolder {
        return NewsArticleViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.fragment_article,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: NewsArticleViewHolder, position: Int) {
        val article = differ.currentList[position]
        holder.itemView.apply {
            Glide.with(this).load(article.urlToImage).into(article_news)
            tv_title.text = article.title
            tv_author.text = article.author.toString()
            tv_publishedAt.text = article.publishedAt
            tv_source.text = article.source.name
            tv_description.text = article.description
            tv_content.text = article.content.toString()
        }
    }
}