package cz.januvojt.yahoofinance.model

data class IndexSummary(
    val ask: Double,
    val askSize: Int,
    val averageDailyVolume10Day: Int,
    val averageDailyVolume3Month: Int,
    val bid: Double,
    val bidSize: Int,
    val currency: String,
    val customPriceAlertConfidence: String,
    val esgPopulated: Boolean,
    val exchange: String,
    val exchangeDataDelayedBy: Int,
    val exchangeTimezoneName: String,
    val exchangeTimezoneShortName: String,
    val fiftyDayAverage: Double,
    val fiftyDayAverageChange: Double,
    val fiftyDayAverageChangePercent: Double,
    val fiftyTwoWeekHigh: Double,
    val fiftyTwoWeekHighChange: Double,
    val fiftyTwoWeekHighChangePercent: Double,
    val fiftyTwoWeekLow: Double,
    val fiftyTwoWeekLowChange: Double,
    val fiftyTwoWeekLowChangePercent: Double,
    val fiftyTwoWeekRange: String,
    val firstTradeDateMilliseconds: Long,
    val fullExchangeName: String,
    val gmtOffSetMilliseconds: Int,
    val language: String,
    val market: String,
    val marketState: String,
    val messageBoardId: String,
    val priceHint: Int,
    val quoteSourceName: String,
    val quoteType: String,
    val region: String,
    val regularMarketChange: Double,
    val regularMarketChangePercent: Double,
    val regularMarketDayHigh: Double,
    val regularMarketDayLow: Double,
    val regularMarketDayRange: String,
    val regularMarketOpen: Double,
    val regularMarketPreviousClose: Double,
    val regularMarketPrice: Double,
    val regularMarketTime: Int,
    val regularMarketVolume: Int,
    val shortName: String,
    val sourceInterval: Int,
    val symbol: String,
    val tradeable: Boolean,
    val triggerable: Boolean,
    val twoHundredDayAverage: Double,
    val twoHundredDayAverageChange: Double,
    val twoHundredDayAverageChangePercent: Double,
    val typeDisp: String
)