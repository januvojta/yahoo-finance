package cz.januvojt.yahoofinance

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlin.reflect.KClass

private const val USER_AGENT_HEADER = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.95 Safari/537.36"


internal suspend fun getHtml(url: String, client: HttpClient? = null): String {
    val httpClient: HttpClient = client ?: HttpClient(CIO)

    val response = httpClient.get(url){
        headers{
            append(HttpHeaders.UserAgent, USER_AGENT_HEADER)
        }
    }
    if (response.status == HttpStatusCode.OK) {
        return response.bodyAsText()
    }
    return "{}"
}

internal inline fun <reified T : Any> String.toJson(clazz: KClass<T>): T {
    return Json.decodeFromString<T>(this.toString())
}

internal fun String.toJsonElement(): JsonElement {
    return Json.parseToJsonElement(this.toString())
}


