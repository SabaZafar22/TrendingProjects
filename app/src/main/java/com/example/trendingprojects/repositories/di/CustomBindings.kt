package com.example.trendingprojects.repositories.di

import android.view.View
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.trendingprojects.repositories.domain.TrendingProjectUiState
import com.example.trendingprojects.repositories.ui.TrendingProjectsAdapter

@BindingAdapter("app:visible")
fun View.visibleIfTrue(show: Boolean) {
    this.visibility = if (show) View.VISIBLE else View.GONE
}

@BindingAdapter(value = ["app:set_project_list"])
fun RecyclerView.setProductList(state: TrendingProjectUiState?) {
    state?.let {
        if (it is TrendingProjectUiState.Success) {
            (adapter as TrendingProjectsAdapter).projectList = it.projects
        }
    }
}