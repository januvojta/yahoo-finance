package cz.januvojt.yahoofinance.model

import kotlinx.serialization.Serializable

@Serializable
data class IndexSummary(
    val ask: Double? = null,
    val askSize: Int? = null,
    val averageDailyVolume10Day: Long? = null,
    val averageDailyVolume3Month: Long? = null,
    val bid: Double? = null,
    val bidSize: Int? = null,
    val currency: String? = null,
    val customPriceAlertConfidence: String? = null,
    val esgPopulated: Boolean? = null,
    val exchange: String? = null,
    val exchangeDataDelayedBy: Long? = null,
    val exchangeTimezoneName: String? = null,
    val exchangeTimezoneShortName: String? = null,
    val fiftyDayAverage: Double? = null,
    val fiftyDayAverageChange: Double? = null,
    val fiftyDayAverageChangePercent: Double? = null,
    val fiftyTwoWeekHigh: Double? = null,
    val fiftyTwoWeekHighChange: Double? = null,
    val fiftyTwoWeekHighChangePercent: Double? = null,
    val fiftyTwoWeekLow: Double? = null,
    val fiftyTwoWeekLowChange: Double? = null,
    val fiftyTwoWeekLowChangePercent: Double? = null,
    val fiftyTwoWeekRange: String? = null,
    val firstTradeDateMilliseconds: Long? = null,
    val fullExchangeName: String? = null,
    val gmtOffSetMilliseconds: Long? = null,
    val language: String? = null,
    val longName: String? = null,
    val market: String? = null,
    val marketState: String? = null,
    val messageBoardId: String? = null,
    val priceHint: Int? = null,
    val quoteSourceName: String? = null,
    val quoteType: String? = null,
    val region: String? = null,
    val regularMarketChange: Double? = null,
    val regularMarketChangePercent: Double? = null,
    val regularMarketDayHigh: Double? = null,
    val regularMarketDayLow: Double? = null,
    val regularMarketDayRange: String? = null,
    val regularMarketOpen: Double? = null,
    val regularMarketPreviousClose: Double? = null,
    val regularMarketPrice: Double? = null,
    val regularMarketTime: Long? = null,
    val regularMarketVolume: Long? = null,
    val shortName: String? = null,
    val sourceInterval: Int? = null,
    val symbol: String? = null,
    val tradeable: Boolean? = null,
    val triggerable: Boolean? = null,
    val twoHundredDayAverage: Double? = null,
    val twoHundredDayAverageChange: Double? = null,
    val twoHundredDayAverageChangePercent: Double? = null,
    val typeDisp: String? = null,
)