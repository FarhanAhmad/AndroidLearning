package com.black.androidlearning

import android.app.Application
import android.content.Context
import com.black.androidlearning.data.AppRepo
import com.black.androidlearning.di.modules
import junit.framework.Assert.assertNotNull
import okhttp3.OkHttpClient
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.koin.dsl.module.module
import org.koin.standalone.StandAloneContext.startKoin
import org.koin.standalone.StandAloneContext.stopKoin
import org.koin.standalone.get
import org.koin.test.KoinTest
import org.koin.test.checkModules
import org.mockito.Mockito.mock

/**
 * Created by farhanahmad on 25/4/20.
 */
class KoinTests : KoinTest {

    @Before
    fun setup() {

    }

    @After
    fun shutdown() {
        stopKoin()
    }

    @Test
    fun testKoinDependencyGraph() {

        val mockApplication = module(override = true) {
            single { mock(Application::class.java) }
            single { mock(Context::class.java) }
        }

        val moduleList = modules + mockApplication

        checkModules(moduleList)

    }

    @Test
    fun testAppRepoInject() {

        val mockAppRepoModule = module {
            single("HttpClient") { OkHttpClient() }
        }
        startKoin(listOf(mockAppRepoModule))

        val httpClient:OkHttpClient = get("HttpClient")

        assertNotNull(httpClient)
    }

}