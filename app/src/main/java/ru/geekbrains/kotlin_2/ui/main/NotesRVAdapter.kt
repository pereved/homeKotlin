package ru.geekbrains.kotlin_2.ui.main

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_note.view.*
import ru.geekbrains.kotlin_2.R
import ru.geekbrains.kotlin_2.data.entity.Note

class NotesRVAdapter : RecyclerView.Adapter<NotesRVAdapter.ViewHolder>() {

    var notes: List<Note> = listOf()
        set(value){
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_note,
                parent,
                false
            )
        )

    override fun getItemCount() = notes.size

    override fun onBindViewHolder(vh: ViewHolder, pos: Int) = vh.bind(notes[pos])

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        fun bind(note: Note) = with(itemView) {
            tv_title.text = note.title
            tv_text.text = note.text
            itemView.setBackgroundColor(note.color)
        }
    }
}