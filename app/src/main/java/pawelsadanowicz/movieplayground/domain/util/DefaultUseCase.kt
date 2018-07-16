package pawelsadanowicz.movieplayground.domain.util

import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import pawelsadanowicz.movieplayground.util.rx.AppSchedulers

abstract class DefaultUseCase<P, R>(private val appSchedulers: AppSchedulers) {

    private val disposable = CompositeDisposable()

    protected abstract fun run(params: P): Observable<R>

    fun execute(params: P, observer: DisposableObserver<R>) {
        disposable.add(build(params).subscribeWith(observer))
    }

    fun execute(params: P, onNext: (R) -> Unit, onError: (Throwable) -> Unit) {
        disposable.add(build(params).subscribe(onNext, onError))
    }

    fun execute(params: P, onNext: (R) -> Unit, onError: (Throwable) -> Unit, onComplete: () -> Unit) {
        disposable.add(build(params).subscribe(onNext, onError, onComplete))
    }

    fun unsubscribe() {
        if (!disposable.isDisposed) {
            disposable.dispose()
        }
    }

    fun isDisposed(): Boolean = disposable.isDisposed

    private fun build(params: P): Observable<R> = run(params)
            .subscribeOn(appSchedulers.io())
            .observeOn(appSchedulers.ui())

}
