package pawelsadanowicz.movieplayground.feature.dashboard.view.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import pawelsadanowicz.movieplayground.databinding.ViewDashboardItemBinding
import pawelsadanowicz.movieplayground.feature.dashboard.view.viewmodel.MovieViewModel

class DashboardRecyclerViewAdapter : RecyclerView.Adapter<DashboardRecyclerViewAdapter.ViewHolder>() {

    private val viewModels = arrayListOf<MovieViewModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ViewDashboardItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return viewModels.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val viewModel = viewModels.get(position)
        holder.binding.viewModel = viewModel;
    }

    fun setViewModels(viewModels: List<MovieViewModel>) {
        this.viewModels.clear()
        this.viewModels.addAll(viewModels)
        notifyDataSetChanged()
    }

    inner class ViewHolder(val binding: ViewDashboardItemBinding) : RecyclerView.ViewHolder(binding.root)
}
