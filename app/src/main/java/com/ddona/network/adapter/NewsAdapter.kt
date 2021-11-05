package com.ddona.network.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ddona.network.databinding.ItemNewsBinding
import com.ddona.network.model.News

class NewsAdapter(private val listNews: List<News>) :
    RecyclerView.Adapter<NewsAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listNews[position])
    }

    override fun getItemCount() = listNews.size

    class ViewHolder(private val binding: ItemNewsBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(news: News) {
            Glide.with(binding.imgPreview)
                .load(news.image)
                .centerCrop()
                .into(binding.imgPreview)
            binding.tvTitle.text = news.title
            binding.tvDescription.text = news.description
            binding.tvDate.text = news.pubDate
        }
    }
}