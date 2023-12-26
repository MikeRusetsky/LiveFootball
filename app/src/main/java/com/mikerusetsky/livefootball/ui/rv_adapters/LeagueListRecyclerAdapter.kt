package com.mikerusetsky.livefootball.ui.rv_adapters

import android.widget.AdapterView.OnItemClickListener
import androidx.recyclerview.widget.RecyclerView

abstract class LeagueListRecyclerAdapter (private val clickListener: OnItemClickListener) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

}