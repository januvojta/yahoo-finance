package cz.januvojt.yahoofinance.utils

import cz.januvojt.yahoofinance.toJsonElement
import kotlinx.serialization.json.int
import kotlinx.serialization.json.jsonArray
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class `toJsonElement()` {

    @Test
    fun `decodes value into Json element `() {
        assertThat("""{"test":"test it","number":"1"}""".toJsonElement().jsonObject["test"]?.jsonPrimitive?.content)
            .isEqualTo("test it")

        assertThat("""{"test":"test it","number":"1"}""".toJsonElement().jsonObject["number"]?.jsonPrimitive?.int)
            .isEqualTo(1)

        assertThat("""{"test":"test it","number":1}""".toJsonElement().jsonObject["number"]?.jsonPrimitive?.int)
            .isEqualTo(1)
    }

    @Test
    fun `throws Exception when not in Json format `() {
        Assertions.assertThatExceptionOfType(Exception::class.java).isThrownBy {
            """"test":"test","number":"1"""".toJsonElement()
        }

        Assertions.assertThatExceptionOfType(Exception::class.java).isThrownBy {
            """{"test""test","number""1"}""".toJsonElement()
        }

        Assertions.assertThatExceptionOfType(Exception::class.java).isThrownBy {
            """{test:test,number:1}""".toJsonElement()
        }
    }
}