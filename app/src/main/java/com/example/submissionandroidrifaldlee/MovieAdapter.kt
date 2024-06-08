package com.example.submissionandroidrifaldlee

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MovieAdapter(val listMovie: ArrayList<Movie>) : RecyclerView.Adapter<MovieAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (title, rating, year, genre, duration, country, synopsis, poster) = listMovie[position]
        holder.imgPoster.setImageResource(poster)
        holder.tvTitle.text = title
        holder.tvRating.text = rating
        holder.tvYear.text = year
        holder.tvGenre.text = genre
        holder.tvDuration.text = duration
        holder.tvCountry.text = country
        holder.tvSynopsis.text = synopsis

        holder.itemView.setOnClickListener {
            val intentDetail = Intent(holder.itemView.context, DetailMovie::class.java)
            intentDetail.putExtra("key_movie", listMovie[holder.adapterPosition])
            holder.itemView.context.startActivity(intentDetail)
        }
    }

    override fun getItemCount(): Int = listMovie.size

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPoster: ImageView = itemView.findViewById(R.id.imageView)
        val tvTitle: TextView = itemView.findViewById(R.id.item_title)
        val tvRating: TextView = itemView.findViewById(R.id.item_rating)
        val tvYear: TextView = itemView.findViewById(R.id.item_year)
        val tvGenre: TextView = itemView.findViewById(R.id.item_genre)
        val tvDuration: TextView = itemView.findViewById(R.id.item_duration)
        val tvCountry: TextView = itemView.findViewById(R.id.item_country)
        val tvSynopsis: TextView = itemView.findViewById(R.id.item_synopsis)
    }
}

