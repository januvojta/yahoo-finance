package cz.januvojt.yahoofinance.utils

import cz.januvojt.yahoofinance.getHttpClient
import org.assertj.core.api.Assertions.assertThat
import kotlin.test.Test

class `getHttpClient()` {

    @Test
    fun `sets proxy to value passed in argument `() {
        val client = getHttpClient("https://proxysite.com")
        assertThat(client.engine.config.proxy).isNotNull()
        assertThat(client.engine.config.proxy?.address().toString())
            .startsWith("proxysite.com")
    }

    @Test
    fun `sets no proxy if proxyUrl is null `(){
        val client = getHttpClient()
        assertThat(client.engine.config.proxy).isNull()
    }
}