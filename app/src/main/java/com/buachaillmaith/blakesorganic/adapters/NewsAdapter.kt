package com.buachaillmaith.blakesorganic.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import android.widget.ImageView
import com.buachaillmaith.blakesorganic.R
import com.buachaillmaith.blakesorganic.models.Article
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_article_preview.view.*

class NewsAdapter(var todos:List<Article>) : RecyclerView.Adapter<NewsAdapter.ArticleViewHolder>() {

    inner class ArticleViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

//    private val differCallback = object : DiffUtil.ItemCallback<Article>() {
//        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
//            return oldItem.url == newItem.url
//        }
//
//        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
//            return oldItem == newItem
//        }
//    }

//    val differ = AsyncListDiffer(this, differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        return ArticleViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_article_preview,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
//        return differ.currentList.size
        return todos.size
    }

    private var onItemClickListener: ((Article) -> Unit)? = null

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
//        val article = differ.currentList[position]
        val article = todos[position]
        holder.itemView.apply {
//            Glide.with(this).load(article.urlToImage).into(ivArticleImage)
//            ivArticleImage.setImageResource(R.drawable.ic_favorite)
//            ivArticleImage.setImageResource(R.drawable._50ml_kefir_550x825)
            ivArticleImage.setImageResource(article.imageDraw)
//            tvSource.text = article.source.name
            tvTitle.text = article.title
            tvDescription.text = article.description
//            tvPublishedAt.text = article.publishedAt

            setOnClickListener {
                onItemClickListener?.let { it(article) }
            }
        }
    }

    fun setOnItemClickListener(listener: (Article) -> Unit) {
        onItemClickListener = listener
    }

}













