package cz.januvojt.yahoofinance.dto

import kotlinx.serialization.Serializable

@Serializable
data class FutureSummaryDTO(
    val ask: Double? = null,
    val askSize: Int? = null,
    override val averageDailyVolume10Day: Long? = null,
    override val averageDailyVolume3Month: Long? = null,
    val bid: Double? = null,
    val bidSize: Int? = null,
    val contractSymbol: Boolean? = null,
    override val currency: String? = null,
    override val customPriceAlertConfidence: String? = null,
    override val esgPopulated: Boolean? = null,
    override val exchange: String? = null,
    override val exchangeDataDelayedBy: Long? = null,
    override val exchangeTimezoneName: String? = null,
    override val exchangeTimezoneShortName: String? = null,
    val expireDate: Long? = null,
    val expireIsoDate: String? = null,
    override val fiftyDayAverage: Double? = null,
    override val fiftyDayAverageChange: Double? = null,
    override val fiftyDayAverageChangePercent: Double? = null,
    override val fiftyTwoWeekHigh: Double? = null,
    override val fiftyTwoWeekHighChange: Double? = null,
    override val fiftyTwoWeekHighChangePercent: Double? = null,
    override val fiftyTwoWeekLow: Double? = null,
    override val fiftyTwoWeekLowChange: Double? = null,
    override val fiftyTwoWeekLowChangePercent: Double? = null,
    override val fiftyTwoWeekRange: String? = null,
    override val firstTradeDateMilliseconds: Long? = null,
    override val fullExchangeName: String? = null,
    override val gmtOffSetMilliseconds: Long? = null,
    val headSymbolAsString: String? = null,
    override val language: String? = null,
    override val market: String? = null,
    override val marketState: String? = null,
    val openInterest: Int? = null,
    override val priceHint: Int? = null,
    override val quoteSourceName: String? = null,
    override val quoteType: String? = null,
    override val region: String? = null,
    override val regularMarketChange: Double? = null,
    override val regularMarketChangePercent: Double? = null,
    override val regularMarketDayHigh: Double? = null,
    override val regularMarketDayLow: Double? = null,
    override val regularMarketDayRange: String? = null,
    override val regularMarketOpen: Double? = null,
    override val regularMarketPreviousClose: Double? = null,
    override val regularMarketPrice: Double? = null,
    override val regularMarketTime: Long? = null,
    override val regularMarketVolume: Long? = null,
    override val shortName: String? = null,
    override val sourceInterval: Int? = null,
    override val symbol: String? = null,
    override val tradeable: Boolean? = null,
    override val triggerable: Boolean? = null,
    override val twoHundredDayAverage: Double? = null,
    override val twoHundredDayAverageChange: Double? = null,
    override val twoHundredDayAverageChangePercent: Double? = null,
    override val typeDisp: String? = null,
    val underlyingExchangeSymbol: String? = null,
    val underlyingSymbol: String? = null,
) : SummaryBaseDTO