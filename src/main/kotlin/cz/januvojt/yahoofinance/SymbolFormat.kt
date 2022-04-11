package cz.januvojt.yahoofinance

internal fun formatCrypto(symbol: String): String {
    return symbol.uppercase()
}

internal fun formatCurrency(symbol: String): String {
    val formattedSymbol = if (symbol.endsWith(suffix = "=X", ignoreCase = true)) symbol else "$symbol=X"
    return formattedSymbol.uppercase()
}

internal fun formatEquity(symbol: String): String {
    return symbol.uppercase()
}

internal fun formatEtf(symbol: String): String {
    return symbol.uppercase()
}

internal fun formatFuture(symbol: String): String {
    val formattedSymbol = if (symbol.endsWith(suffix = "=F", ignoreCase = true)) symbol else "$symbol=F"
    return formattedSymbol.uppercase()
}

internal fun formatIndex(symbol: String): String {
    val formattedSymbol = if (symbol.startsWith(prefix = "^", ignoreCase = true)) symbol else "^$symbol"
    return formattedSymbol.uppercase()
}