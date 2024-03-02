package com.mikerusetsky.livefootball.ui.Home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.mikerusetsky.livefootball.R
import com.mikerusetsky.livefootball.databinding.MatchItemBinding
import com.mikerusetsky.livefootball.domain.Match
import java.text.SimpleDateFormat
import java.util.Locale

class MatchAdapter: ListAdapter<Match, MatchAdapter.ViewHolder>(DiffUtil()) {

    inner class ViewHolder(private val view: View): RecyclerView.ViewHolder(view) {

        private val binding by viewBinding { MatchItemBinding.bind(view) }

        fun bind(item: Match) {
            val leftTeam = item.teams[0]
            val rightTeam = item.teams[1]

            binding.leftTeamName.text = leftTeam.name
            Glide.with(view.context)
                .load(leftTeam.image)
                .into(binding.leftTeamIcon)

            binding.rightTeamName.text = rightTeam.name
            Glide.with(view.context)
                .load(rightTeam.image)
                .into(binding.rightTeamIcon)

            binding.time.text = SimpleDateFormat("mm:HH", Locale.getDefault()).format(item.startingAt)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.match_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = currentList[position]
        holder.bind(item)
    }


}

class DiffUtil(): DiffUtil.ItemCallback<Match>() {
    override fun areItemsTheSame(oldItem: Match, newItem: Match): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Match, newItem: Match): Boolean {
        return oldItem == newItem
    }

}