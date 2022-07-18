package com.example.trendingprojects.repositories.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.trendingprojects.databinding.ItemTrendingProjectsBinding
import com.example.trendingprojects.repositories.domain.ProjectsUiModel

class TrendingProjectsAdapter :
    RecyclerView.Adapter<TrendingProjectsAdapter.TrendingProjectsViewHolder>() {

    var projectList: List<ProjectsUiModel> = emptyList()
        set(value) = run {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrendingProjectsViewHolder {
        return TrendingProjectsViewHolder(
            ItemTrendingProjectsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: TrendingProjectsViewHolder, position: Int) {
        holder.bind(projectList[position])
    }

    override fun getItemCount() = projectList.size

    class TrendingProjectsViewHolder(private val binding: ItemTrendingProjectsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(model: ProjectsUiModel) {
            binding.model = model
            binding.executePendingBindings()
        }
    }
}