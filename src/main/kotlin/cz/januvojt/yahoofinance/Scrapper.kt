package cz.januvojt.yahoofinance

import cz.januvojt.yahoofinance.constants.HttpHeadersContent
import io.ktor.client.*
import io.ktor.client.engine.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*


internal fun getHttpClient(proxyUrl: String? = null): HttpClient {
    return if (proxyUrl == null) {
        HttpClient(CIO)
    } else {
        HttpClient(CIO) {
            engine {
                proxy = ProxyBuilder.http(urlString = proxyUrl)
            }
        }
    }
}

internal suspend fun getHtmlBody(url: String, client: HttpClient? = null): String {
    val httpClient: HttpClient = client ?: getHttpClient()

    try {
        val response = httpClient.get(url) {
            headers { append(HttpHeaders.UserAgent, HttpHeadersContent.USER_AGENT_HEADER) }
        }
        if (response.status == HttpStatusCode.OK) return response.bodyAsText()

    } finally {
        if (client == null) httpClient.close()
    }

    return "{}"
}