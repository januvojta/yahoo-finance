package cz.januvojt.yahoofinance

import io.ktor.client.*
import io.ktor.client.engine.mock.*
import io.ktor.http.*
import io.ktor.utils.io.*
import kotlinx.coroutines.runBlocking
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import java.net.ConnectException
import java.nio.channels.UnresolvedAddressException
import kotlin.test.Test

internal class `getHtml()` {
    private val body = """{"name", "value"}"""

    private val clientOk = HttpClient(MockEngine { _ ->
        respond(
            content = ByteReadChannel(body),
            status = HttpStatusCode.OK,
        )
    })

    private val clientError = HttpClient(MockEngine { _ ->
        respond(
            content = ByteReadChannel(body),
            status = HttpStatusCode.NotFound,
        )
    })

    @Test
    fun `returns body on OK status `(): Unit = runBlocking {
        assertThat(getHtml("mock.url", clientOk)).isEqualTo(body)
    }

    @Test
    fun `returns empty Json on not OK status `(): Unit = runBlocking {
        assertThat(getHtml("mock.url", clientError)).isEqualTo("{}")
    }

    @Test
    fun `throws Exception on no connection or wrong url `(): Unit {
        assertThatExceptionOfType(Exception::class.java).isThrownBy {
            runBlocking {
                getHtml("url")
            }
        }
        assertThatExceptionOfType(Exception::class.java).isThrownBy {
            runBlocking {
                getHtml("")
            }
        }
        assertThatExceptionOfType(Exception::class.java).isThrownBy {
            runBlocking {
                getHtml("test://test.test")
            }
        }
    }

}




