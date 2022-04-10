import cz.januvojt.yahoofinance.getHtml
import cz.januvojt.yahoofinance.model.EtfSummary
import cz.januvojt.yahoofinance.model.StockSummary
import cz.januvojt.yahoofinance.model.Summary
import cz.januvojt.yahoofinance.toJson
import cz.januvojt.yahoofinance.toJsonElement
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.json.jsonArray
import kotlinx.serialization.json.jsonObject

fun main(args: Array<String>) {
    val url = "https://query1.finance.yahoo.com/v7/finance/quote?symbols=VOO"
    runBlocking {
        val text = getHtml(url)
        val obj =
            text.toJsonElement().jsonObject["quoteResponse"]?.jsonObject?.get("result")?.jsonArray?.get(0).toString()
                .toJson(EtfSummary::class)
        println("name: ${obj.shortName}")

    }

    // Try adding program arguments at Run/Debug configuration
    println("Program arguments: ${args.joinToString()}")
}