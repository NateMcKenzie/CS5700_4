package cpu

import nibblesToByte

class Nibbled(byte: UByte) {
    var nibbles : Pair<UByte,UByte>
        private set;
    val first get() = nibbles.first
    val second get() = nibbles.second

    init {
        val first = byte.toUInt().shr(4).toUByte()
        val second = byte.toUInt().and(0x0Fu).toUByte()
        nibbles = Pair(first,second)
    }

    fun byte() = nibblesToByte(first, second)
}
