package pawelsadanowicz.movieplayground.domain.util

import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import pawelsadanowicz.movieplayground.util.rx.AppSchedulers

abstract class DefaultUseCase<P, R>(private val appSchedulers: AppSchedulers) {

    private val disposable = CompositeDisposable()

    protected abstract fun run(params: P): Observable<R>

    fun execute(params: P, observer: Observer<R>) {
        disposable.add(run(params)
                .subscribeOn(appSchedulers.io())
                .observeOn(appSchedulers.ui())
                .subscribeWith(observer) as Disposable)
    }

    fun unsubscribe() {
        if (!disposable.isDisposed) {
            disposable.dispose()
        }
    }

    fun isDisposed(): Boolean = disposable.isDisposed()
}
