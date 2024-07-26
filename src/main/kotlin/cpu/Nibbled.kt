package cpu

class Nibbled(val preNibbled: Pair<Byte, Byte> = Pair(0x0,0x0)) {
    var nibbles = preNibbled
        private set;

    fun byte() : Byte{
        TODO("Not implemented yet")
    }
}

fun nibble(byte: Byte) : Pair<Byte, Byte>{
    TODO("Not implemented yet")
}