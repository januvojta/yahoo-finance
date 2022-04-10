import cz.januvojt.yahoofinance.dto.EquitySummaryDTO
import cz.januvojt.yahoofinance.getHtml
import cz.januvojt.yahoofinance.toJson
import cz.januvojt.yahoofinance.toJsonElement
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.json.jsonArray
import kotlinx.serialization.json.jsonObject

fun main(args: Array<String>) {
    val url = "https://query1.finance.yahoo.com/v7/finance/quote?symbols=msft"
    runBlocking {
        val text = getHtml(url)
        val obj =
            text.toJsonElement().jsonObject["quoteResponse"]?.jsonObject?.get("result")?.jsonArray?.get(0).toString()
                .toJson(EquitySummaryDTO::class)

        val date = obj.gmtOffSetMilliseconds?.let { java.time.ZoneOffset.ofTotalSeconds(it.toInt()/1000) }
        println("date: ${date.toString()}")
    }
}