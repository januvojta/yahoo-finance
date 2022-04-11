package cz.januvojt.yahoofinance

import cz.januvojt.yahoofinance.constants.URLs
import cz.januvojt.yahoofinance.model.*
import kotlinx.serialization.json.jsonArray
import kotlinx.serialization.json.jsonObject

class YahooFinance {

    suspend fun getCryptoSummary(symbol: String): CryptoSummary? {
        val formattedSymbol = formatCrypto(symbol)
        val text = getHtmlBody(URLs.YAHOO_FINANCE_SUMMARY + formattedSymbol)
        val json = text.toJsonElement()
            .jsonObject["quoteResponse"]
            ?.jsonObject?.get("result")
            ?.jsonArray?.get(0) ?: return null

        return serializeCrypto(json)
    }

    suspend fun getCurrencySummary(symbol: String): CurrencySummary? {
        val formattedSymbol = formatCurrency(symbol)
        val text = getHtmlBody(URLs.YAHOO_FINANCE_SUMMARY + formattedSymbol)
        val json = text.toJsonElement()
            .jsonObject["quoteResponse"]
            ?.jsonObject?.get("result")
            ?.jsonArray?.get(0) ?: return null

        return serializeCurrency(json)
    }

    suspend fun getEquitySummary(symbol: String): EquitySummary? {
        val formattedSymbol = formatEquity(symbol)
        val text = getHtmlBody(URLs.YAHOO_FINANCE_SUMMARY + formattedSymbol)
        val json = text.toJsonElement()
            .jsonObject["quoteResponse"]
            ?.jsonObject?.get("result")
            ?.jsonArray?.get(0) ?: return null

        return serializeEquity(json)
    }

    suspend fun getEtfSummary(symbol: String): EtfSummary? {
        val formattedSymbol = formatEtf(symbol)
        val text = getHtmlBody(URLs.YAHOO_FINANCE_SUMMARY + formattedSymbol)
        val json = text.toJsonElement()
            .jsonObject["quoteResponse"]
            ?.jsonObject?.get("result")
            ?.jsonArray?.get(0) ?: return null

        return serializeEtf(json)
    }

    suspend fun getFutureSummary(symbol: String): FutureSummary? {
        val formattedSymbol = formatFuture(symbol)
        val text = getHtmlBody(URLs.YAHOO_FINANCE_SUMMARY + formattedSymbol)
        val json = text.toJsonElement()
            .jsonObject["quoteResponse"]
            ?.jsonObject?.get("result")
            ?.jsonArray?.get(0) ?: return null

        return serializeFuture(json)
    }

    suspend fun getIndexSummary(symbol: String): IndexSummary? {
        val formattedSymbol = formatIndex(symbol)
        val text = getHtmlBody(URLs.YAHOO_FINANCE_SUMMARY + formattedSymbol)
        val json = text.toJsonElement()
            .jsonObject["quoteResponse"]
            ?.jsonObject?.get("result")
            ?.jsonArray?.get(0) ?: return null

        return serializeIndex(json)
    }
}