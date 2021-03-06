package sdk.demo.test

import com.damco.weather.sdk.WeatherSDK
import com.damco.weather.sdk.data.model.weather.WeatherResponse
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class WeatherUnitTest {

    private lateinit var weatherSDK: WeatherSDK
    private var apiKey = "ae1c4977a943a50eaa7da25e6258d8b2"

    @Before
    fun init() {
        weatherSDK = WeatherSDK.getInstance(apiKey)
    }

    @Test
    fun testConvertFahrenheitToCelsius() {
        val actual: Double = weatherSDK.celsiusToFahrenheit(10.1)
        val expected = -12.16666
        Assert.assertEquals(
            "Conversion from C to F",
            expected.toDouble(),
            actual.toDouble(),
            0.001
        )
    }

    @Test
    fun testConvertCelsiusToFahrenheit() {
        val actual: Double = weatherSDK.fahrenheitToCelsius(11.2)
        val expected = 52.16
        Assert.assertEquals(
            "Conversion from F to C",
            expected.toDouble(),
            actual.toDouble(),
            0.001
        )
    }

    @Test
    fun testLatLng() {
        var status = weatherSDK.validateLatLng(22.11, 44.12)
        Assert.assertEquals(true, status)
    }

    @Test
    fun testWeatherResponse() {
        var apiResponse = ""
        if (weatherSDK == null) {
            weatherSDK = WeatherSDK.getInstance(apiKey)
            Thread.sleep(1000)
        }
        weatherSDK.getCurrentWeather(27.34345, 77.343543,
            WeatherSDK.TempUnit.CELSIUS,
            object : WeatherSDK.WeatherDataListener {
                override fun onWeatherResponse(response: WeatherResponse) {
                    apiResponse = response.toString()
                }

                override fun onErrorFetchingData(error: Throwable) {
                }
            })
        Thread.sleep(1000)
        Assert.assertEquals(true, apiResponse.isNotEmpty())

    }
}