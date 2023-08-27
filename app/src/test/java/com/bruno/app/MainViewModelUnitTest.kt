package com.bruno.app

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@OptIn(kotlinx.coroutines.ExperimentalCoroutinesApi::class)
class MainViewModelUnitTest {

    private lateinit var viewModel: MainViewModel

    @get:Rule
    val instantTaskRule = InstantTaskExecutorRule()
    private val dispatcher = StandardTestDispatcher()

    @Before
    fun setup() {
        Dispatchers.setMain(dispatcher)
        viewModel = MainViewModel()
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun mainViewModel_checkInitialValue() = runTest {
        val value = viewModel.result.value?.toString()

        assertEquals("",value)
    }

    @Test
    fun mainViewModel_checkDifferentValues() = runTest {
        val str1 = "A"
        val str2 = "B"

        viewModel.compareStrings(str1,str2)

        val value = viewModel.result.value?.toString()

        assertEquals("Los textos no son iguales",value)
    }

    @Test
    fun mainViewModel_checkEqualValues() = runTest {
        val str1 = "A"
        val str2 = "A"

        viewModel.compareStrings(str1,str2)

        val value = viewModel.result.value?.toString()

        assertEquals("Los textos son iguales",value)
    }

}