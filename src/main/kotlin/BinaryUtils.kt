fun shortToBytes(short: UShort): Pair<UByte, UByte> {
    TODO("This function is no longer used")
    val first = short.toUInt().shr(8)
    val second = short - first.shl(8)
    return Pair(first.toUByte(), second.toUByte())
}

fun bytesToShort(bytes: Pair<UByte, UByte>): UShort {
    var canvas: UInt = bytes.first.toUInt()
    canvas = canvas.shl(8)
    canvas = canvas.or(bytes.second.toUInt())
    return canvas.toUShort()
}

fun nibblesToByte(first: UByte, second: UByte): UByte {
    var newByte = first.toUInt()
    newByte = newByte.shl(4)
    newByte = newByte.or(second.toUInt())
    return newByte.toUByte()
}

private val stringByteMap = mapOf(
    '0' to 0u, '1' to 1u, '2' to 2u,
    '3' to 3u, '4' to 4u, '5' to 5u,
    '6' to 6u, '7' to 7u, '8' to 8u,
    '9' to 9u, 'a' to 10u, 'A' to 10u,
    'b' to 11u, 'B' to 11u, 'c' to 12u,
    'C' to 12u, 'd' to 13u, 'D' to 13u,
    'e' to 14u, 'E' to 14u, 'f' to 15u, 'F' to 15u,
)

fun stringToByte(inputString: String): UByte {
    if (inputString.isEmpty()) return 0u.toUByte()
    var string = inputString
    if (inputString.length == 1) string = "0$string"

    val first = stringByteMap[string[0]] ?: throw IllegalArgumentException("${string[0]} is not base-16")
    val second = stringByteMap[string[1]] ?: throw IllegalArgumentException("${string[1]} is not base-16")
    return nibblesToByte(first.toUByte(), second.toUByte())
}