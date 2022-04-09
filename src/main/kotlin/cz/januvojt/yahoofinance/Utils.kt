package cz.januvojt.yahoofinance

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*

suspend fun getHtml(url: String, client: HttpClient? = null): String {
    val httpClient: HttpClient = client ?: HttpClient(CIO)

    val response = httpClient.get(url)
    if (response.status == HttpStatusCode.OK) {
        return response.bodyAsText()
    }
    return "{}"
}


