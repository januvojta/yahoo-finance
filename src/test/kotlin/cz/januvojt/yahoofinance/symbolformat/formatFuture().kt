package cz.januvojt.yahoofinance.symbolformat

import cz.januvojt.yahoofinance.formatCurrency
import cz.januvojt.yahoofinance.formatFuture
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class `formatFuture()` {
    @Test
    fun `appends =F if its not there `(){
        Assertions.assertThat(formatFuture("GC")).isEqualTo("GC=F")
        Assertions.assertThat(formatFuture("CL=F")).isEqualTo("CL=F")
        Assertions.assertThat(formatFuture("KC=F")).isEqualTo("KC=F")
    }

    @Test
    fun `converts to uppercase if its not `(){
        Assertions.assertThat(formatFuture("si=F")).isEqualTo("SI=F")
        Assertions.assertThat(formatFuture("ct=f")).isEqualTo("CT=F")
        Assertions.assertThat(formatFuture("Ng=f")).isEqualTo("NG=F")
        Assertions.assertThat(formatFuture("TTF=F")).isEqualTo("TTF=F")
    }
}