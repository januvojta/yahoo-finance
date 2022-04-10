package cz.januvojt.yahoofinance

fun formatCrypto(symbol: String): String {
    return symbol.uppercase()
}

fun formatCurrency(symbol: String): String {
    val formattedSymbol = if (symbol.endsWith("=X")) symbol else "$symbol=X"
    return formattedSymbol.uppercase()
}

fun formatEquity(symbol: String): String {
    return symbol.uppercase()
}

fun formatEtf(symbol: String): String {
    return symbol.uppercase()
}

fun formatFuture(symbol: String): String {
    val formattedSymbol = if (symbol.endsWith("=F")) symbol else "$symbol=F"
    return formattedSymbol.uppercase()
}

fun formatIndex(symbol: String): String {
    val formattedSymbol = if (symbol.startsWith("^")) symbol else "^$symbol"
    return formattedSymbol.uppercase()
}