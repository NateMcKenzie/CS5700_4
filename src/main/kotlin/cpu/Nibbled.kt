package cpu

class Nibbled(val preNibbled: Pair<UByte, UByte> = Pair(0u.toUByte(),0u.toUByte())) {
    var nibbles = preNibbled
        private set;

    fun byte() : Byte{
        TODO("Not implemented yet")
    }
}
