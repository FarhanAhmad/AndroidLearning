package com.black.androidlearning.data.usecases

import com.black.androidlearning.data.AppRepo
import com.black.androidlearning.model.CountryDTO
import com.black.androidlearning.ui.model.CountryListItem
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Before

import org.junit.Assert.*
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify

/**
 * Created by farhanahmad on 3/5/20.
 */
class GetCountryListUseCaseTest {

    lateinit var appRepo:AppRepo

    val tempList = arrayListOf<CountryDTO>()

    @Before
    fun setUp() {

        appRepo = Mockito.mock(AppRepo::class.java)


        tempList.add(CountryDTO("Abc","cdf",0L,"img"))

    }

    @After
    fun tearDown() {
    }

    @Test
    fun testUseCaseList() = runBlocking{

        `when`(appRepo.getCountryList()).thenReturn(tempList)


        val useCase = GetCountryListUseCase(appRepo)


        val list = useCase.execute()

        assert(list != null)

        if(list!=null)
            assert(list[0].name == tempList[0].name)

    }

    @Test
    fun testUseCaseExecute() = runBlockingTest{

        val useCase = GetCountryListUseCase(appRepo)


        useCase.execute()

        verify(appRepo).getCountryList()

    }
}