package com.msm.composemvvmapp

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.msm.composemvvmapp.model.User
import com.msm.composemvvmapp.viewmodel.UserViewModel
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule


class UserViewModelTest {

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun testUpdateUser() = runTest {
        val userViewModel = UserViewModel()
        userViewModel.updateUser(name = "John Doe", age = 30)
        assertEquals(User(name = "John Doe", age = 30), userViewModel.user.value)

        userViewModel.updateUser("Jane Doe", 25)
        assertEquals(User("Jane Doe", 25), userViewModel.user.value)
    }
}