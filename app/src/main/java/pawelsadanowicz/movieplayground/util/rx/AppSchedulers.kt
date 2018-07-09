package pawelsadanowicz.movieplayground.util.rx

import io.reactivex.Scheduler

interface AppSchedulers {

    fun ui(): Scheduler

    fun io(): Scheduler

    fun computation(): Scheduler
}
