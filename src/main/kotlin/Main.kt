import cz.januvojt.yahoofinance.YahooFinance
import kotlinx.coroutines.runBlocking

fun main(args: Array<String>) {
    val url = "https://query1.finance.yahoo.com/v7/finance/quote?symbols=BTC-USD"
    runBlocking {
        val obj = YahooFinance().getCryptoSummary("BTC-USD")
        println(obj?.shortName ?: "None")
    }
}