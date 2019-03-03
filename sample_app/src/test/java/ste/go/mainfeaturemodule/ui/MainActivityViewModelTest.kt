package ste.go.mainfeaturemodule.ui

import io.reactivex.Single
import io.reactivex.observers.TestObserver
import io.reactivex.schedulers.Schedulers
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import ste.go.datalayermodule.network.api.model.Data
import ste.go.datalayermodule.network.api.model.DataObject
import ste.go.datalayermodule.repository.Repository
import ste.go.basemodule.util.SchedulerProvider

//https://medium.com/@rahul.singh/clean-architecture-kotlin-dagger-2-rxjava-mvvm-and-unit-testing-dc05dcdf3ce6
/**
 * Unit test for [MainActivityViewModel].
 */
class MainActivityViewModelTest {

    @Mock
    private lateinit var mockRepository: Repository

    private val schedulerProvider = SchedulerProvider(Schedulers.trampoline(), Schedulers.trampoline())

    private lateinit var mainActivityViewModel: MainActivityViewModel

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        mainActivityViewModel = MainActivityViewModel(mockRepository, schedulerProvider)
    }

    @Test
    fun showDataFromApi() {
        Mockito.`when`(mockRepository.getDataFromApi(1)).thenReturn(Single.just(Data(DataObject("test"))))

        val testObserver = TestObserver<Data>()

        mainActivityViewModel.showDataFromApi()
                .subscribe(testObserver)

        testObserver.assertNoErrors()
        testObserver.assertValue { Data -> Data?.data?.name.equals("test") }
    }
}