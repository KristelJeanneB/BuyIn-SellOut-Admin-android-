package com.kristeljeanne.bautista.block1.p1.buyinselloutadmin
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

data class CardItem(val id: Int, val text: String, val imageResource: Int)

class CardItemAdapter(
    private val data: List<CardItem>,
    private val itemClickListener: (Int) -> Unit
) :
    RecyclerView.Adapter<CardItemAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cardView: CardView = itemView.findViewById(R.id.cardView)
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
        val textView: TextView = itemView.findViewById(R.id.textView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        holder.imageView.setImageResource(item.imageResource)
        holder.textView.text = item.text
        holder.cardView.setOnClickListener {
            itemClickListener(item.id)
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }
}