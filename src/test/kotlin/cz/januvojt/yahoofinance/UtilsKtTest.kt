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

class UtilsKtTest {
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
    fun `getHtml() returns body on OK status`(): Unit = runBlocking {
        assertThat(getHtml("url", clientOk)).isEqualTo(body)
    }

    @Test
    fun `getHtml() returns empty Json on not OK status`(): Unit = runBlocking {
        assertThat(getHtml("url", clientError)).isEqualTo("{}")
    }

    @Test
    fun `getHtml() throws Exception on no connection or wrong url`(): Unit {
        assertThatExceptionOfType(ConnectException::class.java).isThrownBy {
            runBlocking {
                getHtml("url")
            }
        }
        assertThatExceptionOfType(URLParserException::class.java).isThrownBy {
            runBlocking {
                getHtml("")
            }
        }
        assertThatExceptionOfType(UnresolvedAddressException::class.java).isThrownBy {
            runBlocking {
                getHtml("test://test.test")
            }
        }
    }


}




