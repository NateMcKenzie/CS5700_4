fun nibble(byte: Byte) : Pair<Byte, Byte>{
    TODO("Not implemented yet")
}

fun shortToBytes(short : UShort) : Pair<UByte,UByte>{
    val first = short.toUInt().shr(8)
    val second = short - first.shl(8)
    return Pair(first.toUByte(), second.toUByte())
}

fun bytesToShort(bytes : Pair<UByte,UByte>) : UShort{
    var canvas : UInt = bytes.first.toUInt()
    canvas = canvas.shl(8)
    canvas += bytes.second.toUInt()
    return canvas.toUShort()
}



