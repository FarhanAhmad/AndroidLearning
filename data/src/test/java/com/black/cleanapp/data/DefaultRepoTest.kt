package com.black.cleanapp.data

import com.black.cleanapp.data.model.CountryDTO
import com.black.cleanapp.data.model.CountryFlag
import com.black.cleanapp.data.model.CountryName
import com.black.cleanapp.data.remote.CountriesNetworkService
import com.black.cleanapp.data.repository.DefaultAppRepository
import com.black.cleanapp.domain.repository.AppRepo
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import net.bytebuddy.matcher.ElementMatchers.returns
import org.junit.Before
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class DefaultRepoTest {

    lateinit var appRepo: AppRepo

    val networkService = mockk<CountriesNetworkService>()

    @Before
    fun setup() {
        appRepo = DefaultAppRepository(networkService)
    }

    @Test
    fun testEmptyResponse() = runTest {
        coEvery { networkService.getCountryList() } returns listOf()

        assert(appRepo.getCountryList().isEmpty())
    }

    @Test
    fun testMappingIsCorrect() = runTest {
        coEvery {
            networkService.getCountryList()
        } returns listOf(
            CountryDTO(
                name = CountryName("abc"),
                flag = CountryFlag("someUrl"),
            )
        )

        val list = appRepo.getCountryList()

        assert(list.isNotEmpty())
        assert(list.first().name == "abc")
    }
}