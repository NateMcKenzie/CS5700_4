package cpu

@OptIn(ExperimentalUnsignedTypes::class)
class RegisterBank {
    private val general = UByteArray(8) { 0u }
    var address = 0u.toUShort()
    var timer = 0u.toUByte()

    fun writeRegister(address: UByte, value: UByte) {
        general[address.toInt()] = value
    }

    fun readRegister(address: UByte): UByte {
        return general[address.toInt()]
    }
}