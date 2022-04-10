package cz.januvojt.yahoofinance

import io.ktor.client.*
import io.ktor.client.engine.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*


private const val USER_AGENT_HEADER =
    "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.95 Safari/537.36"


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

internal suspend fun getHtml(url: String, client: HttpClient? = null): String {
    val httpClient: HttpClient = client ?: getHttpClient()

    try {
        val response = httpClient.get(url) {
            headers { append(HttpHeaders.UserAgent, USER_AGENT_HEADER) }
        }
        if (response.status == HttpStatusCode.OK) return response.bodyAsText()

    } finally {
        if (client == null) httpClient.close()
    }

    return "{}"
}