package cz.januvojt.yahoofinance.symbolformat

import cz.januvojt.yahoofinance.formatCurrency
import org.assertj.core.api.Assertions.assertThat
import kotlin.test.Test

internal class `formatCurrency()` {
    @Test
    fun `appends =X if its not there `(){
        assertThat(formatCurrency("CZK")).isEqualTo("CZK=X")
        assertThat(formatCurrency("JPYHKD")).isEqualTo("JPYHKD=X")
        assertThat(formatCurrency("EURRUB=X")).isEqualTo("EURRUB=X")
        assertThat(formatCurrency("NZD=X")).isEqualTo("NZD=X")
    }

    @Test
    fun `converts to uppercase if its not `(){
        assertThat(formatCurrency("czk=x")).isEqualTo("CZK=X")
        assertThat(formatCurrency("jpyhkd=X")).isEqualTo("JPYHKD=X")
        assertThat(formatCurrency("EURRUB=X")).isEqualTo("EURRUB=X")
        assertThat(formatCurrency("NZD=x")).isEqualTo("NZD=X")
    }
}