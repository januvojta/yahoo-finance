package cz.januvojt.yahoofinance.dto

import cz.januvojt.yahoofinance.serializer.BigIntegerSerializer
import kotlinx.serialization.Serializable
import java.math.BigDecimal
import java.math.BigInteger


interface SummaryBaseDTO {
    val averageDailyVolume10Day: Long?
    val averageDailyVolume3Month: Long?
    val currency: String?
    val customPriceAlertConfidence: String?
    val esgPopulated: Boolean?
    val exchange: String?
    val exchangeDataDelayedBy: Long?
    val exchangeTimezoneName: String?
    val exchangeTimezoneShortName: String?
    val fiftyDayAverage: Double?
    val fiftyDayAverageChange: Double?
    val fiftyDayAverageChangePercent: Double?
    val fiftyTwoWeekHigh: Double?
    val fiftyTwoWeekHighChange: Double?
    val fiftyTwoWeekHighChangePercent: Double?
    val fiftyTwoWeekLow: Double?
    val fiftyTwoWeekLowChange: Double?
    val fiftyTwoWeekLowChangePercent: Double?
    val fiftyTwoWeekRange: String?
    val firstTradeDateMilliseconds: Long?
    val fullExchangeName: String?
    val gmtOffSetMilliseconds: Long?
    val language: String?
    val market: String?
    val marketState: String?
//    val messageBoardId: String?
    val priceHint: Int?
    val quoteSourceName: String?
    val quoteType: String?
    val region: String?
    val regularMarketChange: Double?
    val regularMarketChangePercent: Double?
    val regularMarketDayHigh: Double?
    val regularMarketDayLow: Double?
    val regularMarketDayRange: String?
    val regularMarketOpen: Double?
    val regularMarketPreviousClose: Double?
    val regularMarketPrice: Double?
    val regularMarketTime: Long?
    val regularMarketVolume: Long?
    val shortName: String?
    val sourceInterval: Int?
    val symbol: String?
    val tradeable: Boolean?
    val triggerable: Boolean?
    val twoHundredDayAverage: Double?
    val twoHundredDayAverageChange: Double?
    val twoHundredDayAverageChangePercent: Double?
    val typeDisp: String?
}