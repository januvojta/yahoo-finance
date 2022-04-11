package cz.januvojt.yahoofinance.symbolformat

import cz.januvojt.yahoofinance.formatCrypto
import org.assertj.core.api.Assertions.assertThat
import kotlin.test.Test


internal class `formatCrypto()`{
    @Test
    fun `converts to uppercase if its not `(){
        assertThat(formatCrypto("btc-usd")).isEqualTo("BTC-USD")
        assertThat(formatCrypto("LINK-USD")).isEqualTo("LINK-USD")
        assertThat(formatCrypto("Link-CzK")).isEqualTo("LINK-CZK")
    }

}