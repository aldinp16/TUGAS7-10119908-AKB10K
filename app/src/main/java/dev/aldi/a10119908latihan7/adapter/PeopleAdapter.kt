package dev.aldi.a10119908latihan7.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import dev.aldi.a10119908latihan7.R
import dev.aldi.a10119908latihan7.model.People

class PeopleAdapter(peoples: List<People>): RecyclerView.Adapter<PeopleAdapter.ViewHolder>() {
    private val peoples = peoples

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view: View = inflater.inflate(R.layout.item_list, parent, false)
        return ViewHolder(view);
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val people: People = peoples[position]
        holder.peopleName.text = people.name
        holder.peopleGender.text = people.gender
        holder.peopleBirthyear.text = people.birthYear
        holder.height.text = "Height: ${people.height}"
        holder.mass.text = "Mass ${people.mass}"
        holder.hairColor.text = "Hair Color: ${people.hairColor}"
        holder.skinColor.text = "Skin Color: ${people.skinColor}"
        holder.eyeColor.text = "Eye Color: ${people.eyeColor}"
    }

    override fun getItemCount(): Int {
        return peoples.size
    }

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val peopleName: TextView = view.findViewById(R.id.people_name)
        val peopleGender: TextView = view.findViewById(R.id.people_gender)
        val peopleBirthyear: TextView = view.findViewById(R.id.people_birthyear)
        val height: TextView = view.findViewById(R.id.height)
        val mass: TextView = view.findViewById(R.id.mass)
        val hairColor: TextView = view.findViewById(R.id.hair_color)
        val skinColor: TextView = view.findViewById(R.id.skin_color)
        val eyeColor: TextView = view.findViewById(R.id.eye_color)
    }
}