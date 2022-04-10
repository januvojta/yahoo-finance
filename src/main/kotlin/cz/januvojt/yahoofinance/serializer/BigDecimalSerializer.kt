package cz.januvojt.yahoofinance.serializer

import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.JsonDecoder
import kotlinx.serialization.json.JsonEncoder
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.jsonPrimitive
import java.math.BigDecimal

object BigDecimalSerializer : KSerializer<BigDecimal> {
    override fun deserialize(decoder: Decoder): BigDecimal =
        (decoder as JsonDecoder).decodeJsonElement().jsonPrimitive.content.toBigDecimal()


    override fun serialize(encoder: Encoder, value: BigDecimal) {
        (encoder as JsonEncoder).encodeJsonElement(JsonPrimitive(JsonBigDecimal(value)))
    }

    override val descriptor: SerialDescriptor
        get() = PrimitiveSerialDescriptor("BigDecimal", PrimitiveKind.STRING)


    private class JsonBigDecimal(value: BigDecimal) : Number() {

        private val serialized: String = value.toString()
        private fun notSupported(): Nothing = throw IllegalStateException("Should not be ever invoked!")

        override fun toString() = serialized
        override fun toByte() = notSupported()
        override fun toChar() = notSupported()
        override fun toDouble() = notSupported()
        override fun toFloat() = notSupported()
        override fun toInt() = notSupported()
        override fun toLong() = notSupported()
        override fun toShort() = notSupported()
    }
}