package pawelsadanowicz.movieplayground.util.rx

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class DefaultAppSchedulers : AppSchedulers {

    override fun ui(): Scheduler {
        return AndroidSchedulers.mainThread()
    }

    override fun io(): Scheduler {
        return Schedulers.io()
    }

    override fun computation(): Scheduler {
        return Schedulers.computation()
    }
}
