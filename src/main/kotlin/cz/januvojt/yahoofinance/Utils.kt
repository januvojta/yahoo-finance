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

internal suspend fun getHtml(url: String, client: HttpClient? = null): String {
    val httpClient: HttpClient = client ?: HttpClient(CIO)

    val response = httpClient.get(url)
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


