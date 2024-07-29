package cpu

class Nibbled(byte: UByte) {
    var nibbles : Pair<UByte,UByte>
        private set;

    init {
        val first = byte.toUInt().shr(4).toUByte()
        val second = byte.toUInt().and(0x0Fu).toUByte()
        nibbles = Pair(first,second)
    }




    fun byte() : UByte{
        var newByte = nibbles.first.toUInt()
        newByte = newByte.shl(4)
        newByte = newByte.or(nibbles.second.toUInt())
        return newByte.toUByte()
    }
}
