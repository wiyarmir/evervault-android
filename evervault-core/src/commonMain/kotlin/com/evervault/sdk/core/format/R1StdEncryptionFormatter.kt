package com.evervault.sdk.core.format

import com.evervault.sdk.core.DataType
import io.ktor.utils.io.core.toByteArray
import kotlin.io.encoding.Base64
import kotlin.io.encoding.ExperimentalEncodingApi

internal class R1StdEncryptionFormatter(
    private val evVersion: String,
    private val publicKey: String,
    private val isDebug: Boolean
): EncryptionFormatter {

    @OptIn(ExperimentalEncodingApi::class)
    override fun formatEncryptedData(dataType: DataType, keyIv: String, encryptedData: String): String {
        val evVersionPrefix = Base64.encode(evVersion.toByteArray())
        return "ev:${if(isDebug) "debug:" else ""}${evVersionPrefix}${dataType.prefix}:${keyIv.paddingRemoved}:${publicKey.paddingRemoved}:${encryptedData.paddingRemoved}:$"
    }
}

private val DataType.prefix: String
    get() = when(this) {
        DataType.STRING -> ""
        DataType.BOOLEAN, DataType.NUMBER -> ":$header"
    }

private val String.paddingRemoved: String get() {
    var i = length - 1
    while (i > 0) {
        if (this[i] != '=') {
            break
        }
        i--
    }
    return substring(0, ++i)
}
