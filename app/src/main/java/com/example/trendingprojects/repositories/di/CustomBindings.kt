package com.example.trendingprojects.repositories.di

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.trendingprojects.R
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
            (adapter as TrendingProjectsAdapter?)?.projectList = it.projects
        }
    }
}
@BindingAdapter(value = ["app:set_text"])
fun TextView.setProductList(state: TrendingProjectUiState?) {
    state?.let {
        if (it is TrendingProjectUiState.Failure) {
           this.text = it.message
        }
    }
}


@BindingAdapter(value = ["app:image_url"], requireAll = false)
fun ImageView.loadCircularImage(
    imageUrl: String?
) {
    imageUrl.let {
        val glide = Glide.with(context).load(imageUrl)
            .error(R.drawable.round_background).placeholder(R.drawable.round_background)
        glide.apply(RequestOptions.circleCropTransform()).into(this)
    }
}