package cz.januvojt.yahoofinance.symbolformat

import cz.januvojt.yahoofinance.formatEquity
import org.assertj.core.api.Assertions.assertThat
import kotlin.test.Test

internal class `formatEquity()` {

    @Test
    fun `converts to uppercase if its not `() {
        assertThat(formatEquity("msft")).isEqualTo("MSFT")
        assertThat(formatEquity("AAPL")).isEqualTo("AAPL")
        assertThat(formatEquity("Nvda")).isEqualTo("NVDA")
    }
}