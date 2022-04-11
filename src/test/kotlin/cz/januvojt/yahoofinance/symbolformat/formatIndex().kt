package cz.januvojt.yahoofinance.symbolformat

import cz.januvojt.yahoofinance.formatCurrency
import cz.januvojt.yahoofinance.formatIndex
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class `formatIndex()` {
    @Test
    fun `appends prefix ^ if its not there `(){
        Assertions.assertThat(formatIndex("IXIC")).isEqualTo("^IXIC")
        Assertions.assertThat(formatIndex("DJI")).isEqualTo("^DJI")
        Assertions.assertThat(formatIndex("^GSPC")).isEqualTo("^GSPC")
    }

    @Test
    fun `converts to uppercase if its not `(){
        Assertions.assertThat(formatIndex("^MsCnUsdP")).isEqualTo("^MSCNUSDP")
        Assertions.assertThat(formatIndex("^Uraxp")).isEqualTo("^URAXP")
        Assertions.assertThat(formatIndex("^xeo")).isEqualTo("^XEO")
        Assertions.assertThat(formatIndex("^RUT")).isEqualTo("^RUT")
    }
}