package com.example.kmmsimple.androidApp

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.kmmsimple.shared.iviapi.collections.Movie
import com.example.kmmsimple.shared.iviapi.collections.PaidType
import com.example.kmmsimple.shared.iviapi.collections.PaidTypes
import com.example.kmmsimple.shared.iviapi.collections.Type
import com.example.kmmsimple.shared.iviapi.pages.Block

class PagesAdapter(var blocks: List<Block>) : RecyclerView.Adapter<BlockHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        LayoutInflater.from(parent.context)
            .inflate(R.layout.block_item, parent, false)
            .run { BlockHolder(this) }

    override fun onBindViewHolder(holder: BlockHolder, position: Int) {
        val b = blocks[position]
        holder.text().text = b.title
        b.collection?.apply {
            holder.adapter.movies = this.result ?: listOf()
            holder.adapter.notifyDataSetChanged()
        }

    }

    override fun getItemCount() = blocks.size

}

class BlockHolder(val item: View) : RecyclerView.ViewHolder(item) {
    val adapter = CollectionAdapter(listOf())

    init {
        val r = recycler()
        r.layoutManager = LinearLayoutManager(item.context).apply { orientation = LinearLayoutManager.HORIZONTAL }
        r.adapter = adapter
    }

    fun text() = item.findViewById<TextView>(R.id.text)
    fun recycler() = item.findViewById<RecyclerView>(R.id.recycler)
}

class CollectionAdapter(var movies: List<Movie>) : RecyclerView.Adapter<MovieHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        LayoutInflater.from(parent.context)
            .inflate(R.layout.movie_item, parent, false)
            .run { MovieHolder(this) }

    override fun onBindViewHolder(holder: MovieHolder, position: Int) {
        val m = movies[position]
        holder.title().text = m.title
        holder.restrict().text = "${m.restrict}+"
        val paid = m.contentPaidTypes
        holder.paidType().text = m.paidSubtitle()
        holder.paidType().setTextColor(
            when(m.primaryType()) {
                PaidTypes.AVOD -> Color.WHITE
                PaidTypes.SVOD -> holder.item.context.getColor(R.color.svod)
                PaidTypes.EST -> holder.item.context.getColor(R.color.est)
                PaidTypes.TVOD -> holder.item.context.getColor(R.color.est)
                else -> Color.WHITE
            }
        )
        m.posterOriginals?.filter { it.type== Type.Poster }?.first()?.run { this.path+"/234x360/" }?.let {
            holder.image().load(it)
        }
    }

    override fun getItemCount() = movies.size

}

class MovieHolder(val item: View) : RecyclerView.ViewHolder(item) {
    fun title() = item.findViewById<TextView>(R.id.title)
    fun paidType() = item.findViewById<TextView>(R.id.paid_type)
    fun restrict() = item.findViewById<TextView>(R.id.restrict)
    fun image() = item.findViewById<ImageView>(R.id.image)
}
