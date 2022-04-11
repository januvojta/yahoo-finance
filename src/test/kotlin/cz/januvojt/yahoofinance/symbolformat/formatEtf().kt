package cz.januvojt.yahoofinance.symbolformat

import cz.januvojt.yahoofinance.formatCurrency
import cz.januvojt.yahoofinance.formatEtf
import org.assertj.core.api.Assertions
import kotlin.test.Test

class `formatEtf()` {
    @Test
    fun `converts to uppercase if its not `(){
        Assertions.assertThat(formatEtf("inda")).isEqualTo("INDA")
        Assertions.assertThat(formatEtf("ArkG")).isEqualTo("ARKG")
        Assertions.assertThat(formatEtf("spyd")).isEqualTo("SPYD")
    }
}