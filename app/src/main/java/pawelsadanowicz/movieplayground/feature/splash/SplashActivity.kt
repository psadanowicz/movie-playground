package pawelsadanowicz.movieplayground.feature.splash

import android.os.Bundle
import android.os.Handler
import pawelsadanowicz.movieplayground.BaseActivity
import pawelsadanowicz.movieplayground.R
import pawelsadanowicz.movieplayground.util.navigator.ApplicationNavigator
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class SplashActivity : BaseActivity() {

    @Inject lateinit var applicationNavigator: ApplicationNavigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val handler = Handler()
        handler.postDelayed({ this.openDashboard() }, TimeUnit.SECONDS.toMillis(3))
    }

    private fun openDashboard() {
        applicationNavigator.showDashboard()
        finish()
    }
}
