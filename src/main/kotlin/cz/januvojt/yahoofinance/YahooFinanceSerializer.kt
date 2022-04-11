package cz.januvojt.yahoofinance

import cz.januvojt.yahoofinance.constants.SummaryTypes
import cz.januvojt.yahoofinance.dto.*
import cz.januvojt.yahoofinance.model.*
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive


internal fun isOfTypeCrypto(jsonElement: JsonElement): Boolean {
    return isOfType(jsonElement, SummaryTypes.CRYPTO)
}

internal fun isOfTypeCurrency(jsonElement: JsonElement): Boolean {
    return isOfType(jsonElement, SummaryTypes.CURRENCY)
}

internal fun isOfTypeEquity(jsonElement: JsonElement): Boolean {
    return isOfType(jsonElement, SummaryTypes.EQUITY)
}

internal fun isOfTypeEtf(jsonElement: JsonElement): Boolean {
    return isOfType(jsonElement, SummaryTypes.ETF)
}

internal fun isOfTypeFuture(jsonElement: JsonElement): Boolean {
    return isOfType(jsonElement, SummaryTypes.FUTURE)
}

internal fun isOfTypeIndex(jsonElement: JsonElement): Boolean {
    return isOfType(jsonElement, SummaryTypes.INDEX)
}

private fun isOfType(jsonElement: JsonElement, type: String): Boolean {
    return jsonElement.jsonObject["quoteType"]?.jsonPrimitive?.content == type
}

internal fun serializeCrypto(jsonElement: JsonElement): CryptoSummary? {
    return if (isOfTypeCrypto(jsonElement)) jsonElement.toObject(CryptoSummaryDTO::class).toCryptoSummary() else null
}

internal fun serializeCurrency(jsonElement: JsonElement): CurrencySummary? {
    return if (isOfTypeCurrency(jsonElement)) jsonElement.toObject(CurrencySummaryDTO::class)
        .toCurrencySummary() else null
}

internal fun serializeEquity(jsonElement: JsonElement): EquitySummary? {
    return if (isOfTypeEquity(jsonElement)) jsonElement.toObject(EquitySummaryDTO::class).toEquitySummary() else null
}

internal fun serializeEtf(jsonElement: JsonElement): EtfSummary? {
    return if (isOfTypeEtf(jsonElement)) jsonElement.toObject(EtfSummaryDTO::class).toEtfSummary() else null
}

internal fun serializeFuture(jsonElement: JsonElement): FutureSummary? {
    return if (isOfTypeFuture(jsonElement)) jsonElement.toObject(FutureSummaryDTO::class).toFutureSummary() else null
}

internal fun serializeIndex(jsonElement: JsonElement): IndexSummary? {
    return if (isOfTypeIndex(jsonElement)) jsonElement.toObject(IndexSummaryDTO::class).toIndexSummary() else null
}
