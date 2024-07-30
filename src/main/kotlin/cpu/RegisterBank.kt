package cpu

@OptIn(ExperimentalUnsignedTypes::class)
class RegisterBank {
    private val general = UByteArray(8) {0u}
    val address = UByteArray(2) {0u}
    var timer = 0u.toUByte()

    fun writeRegister(address: UByte, value: UByte){
        general[address.toInt()] = value
    }

    fun readRegister(address: UByte) : UByte{
        return general[address.toInt()]
    }
}