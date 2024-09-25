package com.practikaltask

import com.practikaltask.domain.PracticalTaskAPi
import com.practikaltask.presentation.main.model.PhotosData
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

class ApiServiceTest {
    @Mock
    lateinit var apiService: PracticalTaskAPi

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun testApiCallSuccess() = runBlocking {
        val mockResponse = ArrayList<PhotosData>() // Populate this with expected data

        // Mock the behavior of the API service
        `when`(apiService.fetchPhotos()).thenReturn(mockResponse)

        // Call the API
        val response = apiService.fetchPhotos()

        // Add assertions here
        assertNotNull(response)
        assertEquals(mockResponse, response)
    }

    @Test(expected = Exception::class)
    fun testApiCallFailure(): Unit = runBlocking {
        // Mock an exception to be thrown
        `when`(apiService.fetchPhotos()).thenThrow(Exception("Network Error"))

        // Call the API (this should throw the exception)
        apiService.fetchPhotos()
    }
}