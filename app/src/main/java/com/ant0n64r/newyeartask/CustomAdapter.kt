package com.ant0n64r.newyeartask

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.lang_items_layout.view.*
import android.support.constraint.ConstraintLayout
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.widget.CardView


class CustomAdapter(val langList: List<ProgrammingLanguage>) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.lang_items_layout, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return langList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val lang: ProgrammingLanguage = langList[position]

        holder.name.text = lang.name
        holder.authors.text = lang.authors
        holder.year.text = lang.year.toString()
        holder.paradigms.text = lang.paradigms.toString()
        holder.logo.setImageBitmap(lang.logo)
        holder.indexTIOBE.text = lang.indexTIOBE.toString()
        holder.constr.setOnClickListener {
            Utils.startActivity(holder.card.context,WebActivity::class.java,lang.link)
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name = itemView.findViewById(R.id.name) as TextView
        val authors = itemView.findViewById(R.id.authors) as TextView
        val year = itemView.findViewById(R.id.year) as TextView
        val paradigms = itemView.findViewById(R.id.paradigms) as TextView
        val logo = itemView.findViewById(R.id.logo) as ImageView
        val indexTIOBE = itemView.findViewById(R.id.indexTIOBE) as TextView
        val card = itemView.findViewById(R.id.cardView) as CardView
        val constr = itemView.findViewById(R.id.constr) as ConstraintLayout
    }

    class Utils {

        companion object {
            fun startActivity(context: Context, clazz: Class<*>,extra:String) {

                val intent = Intent(context, clazz)

                intent.putExtra("LINK",extra)
                // start your next activity

                context.startActivity(intent)

            }
        }

    }
}