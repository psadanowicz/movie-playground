package pawelsadanowicz.movieplayground.util.rx

import io.reactivex.subscribers.DisposableSubscriber

abstract class DefaultSubscriber<T> : DisposableSubscriber<T>() {

    override fun onError(t: Throwable) {
        if (!isDisposed) {
            dispose()
        }
        onErrorReceived(t)
    }

    override fun onComplete() {
        if (!isDisposed) {
            dispose()
        }
        onCompleteReceived()
    }

    fun onCompleteReceived() {
        //default
    }

    abstract fun onErrorReceived(t: Throwable)
}
