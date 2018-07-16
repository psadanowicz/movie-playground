package pawelsadanowicz.movieplayground.feature.dashboard

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import pawelsadanowicz.movieplayground.BaseActivity
import pawelsadanowicz.movieplayground.R
import pawelsadanowicz.movieplayground.databinding.ActivityDashboardBinding
import pawelsadanowicz.movieplayground.domain.movies.usecase.GetPopularMoviesUseCase
import pawelsadanowicz.movieplayground.feature.dashboard.view.adapter.DashboardRecyclerViewAdapter
import pawelsadanowicz.movieplayground.feature.dashboard.view.viewmodel.DashboardViewModel
import pawelsadanowicz.movieplayground.feature.dashboard.view.viewmodel.adapter.DashboardAdapter
import pawelsadanowicz.movieplayground.feature.dashboard.view.viewmodel.factory.DashboardViewModelFactory
import pawelsadanowicz.movieplayground.util.error.ErrorProvider
import javax.inject.Inject

class DashboardActivity : BaseActivity() {

    @Inject
    lateinit var getPopularMoviesUseCase: GetPopularMoviesUseCase
    @Inject
    lateinit var errorProvider: ErrorProvider

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityDashboardBinding>(this, R.layout.activity_dashboard)
        val viewModel = ViewModelProviders.of(this, DashboardViewModelFactory(getPopularMoviesUseCase, errorProvider)).get(DashboardViewModel::class.java)
        val adapter = DashboardAdapter(this, viewModel)
        binding.adapter = adapter
        binding.recyclerViewAdapter = DashboardRecyclerViewAdapter()
        binding.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
    }
}
