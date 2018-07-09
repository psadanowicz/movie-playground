package pawelsadanowicz.movieplayground.util.navigator

import android.app.Activity
import android.content.Intent

import pawelsadanowicz.movieplayground.feature.dashboard.DashboardActivity

class AndroidApplicationNavigator(private val activity: Activity) : ApplicationNavigator {

    override fun showDashboard() {
        val intent = Intent(activity, DashboardActivity::class.java)
        activity.startActivity(intent)
    }
}
