package pawelsadanowicz.movieplayground.domain

import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.doReturn
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.times
import com.nhaarman.mockito_kotlin.verify
import io.reactivex.Observable
import io.reactivex.observers.TestObserver
import io.reactivex.schedulers.Schedulers
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.mockito.Mockito
import pawelsadanowicz.movieplayground.domain.util.DefaultUseCase
import pawelsadanowicz.movieplayground.util.rx.AppSchedulers

class DefaultUseCaseTest {

    @Test
    fun shouldProperlyReturnValue() { //todo find better way to test this
        val appSchedulers = mock<AppSchedulers> {
            on { io() } doReturn Schedulers.trampoline()
            on { ui() } doReturn Schedulers.trampoline()
        }
        val useCase = TestUseCase(appSchedulers)
        val observer = TestObserver<String>()
        useCase.execute(0, observer)
        observer.assertComplete()
        observer.assertNoErrors()
        observer.assertResult("")
    }

    @Test
    fun shouldProperlyUnsubscribeUseCase() {
        val appSchedulers = mock<AppSchedulers> {
            on { io() } doReturn Schedulers.trampoline()
            on { ui() } doReturn Schedulers.trampoline()
        }
        val useCase = TestUseCase(appSchedulers)
        useCase.execute(0, TestObserver())
        assertThat(useCase.isDisposed()).isFalse()
        useCase.unsubscribe()
        assertThat(useCase.isDisposed()).isTrue()
    }

    class TestUseCase(appSchedulers: AppSchedulers) : DefaultUseCase<Int, String>(appSchedulers) {
        override fun run(params: Int): Observable<String> {
            return Observable.just("")
        }
    }
}
