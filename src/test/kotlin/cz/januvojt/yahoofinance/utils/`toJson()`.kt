package cz.januvojt.yahoofinance.utils

import cz.januvojt.yahoofinance.toJson
import kotlinx.serialization.Serializable
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.api.Test

class `toJson()` {
    @Test
    fun `decodes value into provided KClass `() {
        assertThat("""{"test":"test","number":"1"}""".toJson(cz.januvojt.yahoofinance.utils.Test::class))
            .isEqualTo(cz.januvojt.yahoofinance.utils.Test("test", 1))
    }

    @Test
    fun `throws Exception when not in Json format `() {
        assertThatExceptionOfType(Exception::class.java).isThrownBy {
            """"test":"test","number":"1"""".toJson(cz.januvojt.yahoofinance.utils.Test::class)
        }

        assertThatExceptionOfType(Exception::class.java).isThrownBy {
            """{"test""test","number""1"}""".toJson(cz.januvojt.yahoofinance.utils.Test::class)
        }
        assertThatExceptionOfType(Exception::class.java).isThrownBy {
            """{test:test,number:1}""".toJson(cz.januvojt.yahoofinance.utils.Test::class)
        }
    }

    @Test
    fun `throws Exception when cannot decode into provided KClass `() {
        assertThatExceptionOfType(Exception::class.java).isThrownBy {
            assertThat("""{"test":"test"}""".toJson(cz.januvojt.yahoofinance.utils.Test::class))
                .isEqualTo(cz.januvojt.yahoofinance.utils.Test("test", 1))
        }
    }
}

@Serializable
private data class Test(val test: String, val number: Int)

