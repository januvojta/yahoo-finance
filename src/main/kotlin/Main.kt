import cz.januvojt.yahoofinance.*
import cz.januvojt.yahoofinance.dto.CryptoSummaryDTO
import cz.januvojt.yahoofinance.getHtmlBody
import cz.januvojt.yahoofinance.toObject
import cz.januvojt.yahoofinance.toJsonElement
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.json.jsonArray
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive

fun main(args: Array<String>) {
    val url = "https://query1.finance.yahoo.com/v7/finance/quote?symbols=BTC-USD"
    runBlocking {
        val text = getHtmlBody(url)
        val obj: CryptoSummaryDTO? =
            text.toJsonElement().jsonObject["quoteResponse"]?.jsonObject?.get("result")?.jsonArray?.get(0)
                ?.toObject(CryptoSummaryDTO::class)

        println(text.toJsonElement().jsonObject["quoteResponse"]?.jsonObject?.get("result")?.jsonArray?.get(0)
            ?.let { isOfTypeCrypto(it) } )
        println(text.toJsonElement().jsonObject["quoteResponse"]?.jsonObject?.get("result")?.jsonArray?.get(0)
            ?.let { it.jsonObject["quoteType"]?.jsonPrimitive?.content })
        val date = obj?.gmtOffSetMilliseconds?.let { java.time.ZoneOffset.ofTotalSeconds(it.toInt() / 1000) }
        println("date: ${date.toString()}")
    }
}