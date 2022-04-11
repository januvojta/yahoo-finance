package cz.januvojt.yahoofinance

import cz.januvojt.yahoofinance.model.Rating
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlin.reflect.KClass

internal inline fun <reified T : Any> JsonElement.toObject(clazz: KClass<T>): T {
    return Json.decodeFromString<T>(this.toString())
}

internal fun String.toJsonElement(): JsonElement {
    return Json.parseToJsonElement(this.toString())
}

internal fun String.toRating(): Rating {
    val split = this.toString().split(" - ")
    return if (split.size == 2) {
        Rating(split[0].toDouble(), split[1])
    } else {
        Rating(null, null)
    }
}

