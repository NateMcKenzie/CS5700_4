package cpu

class RegisterBank {
    private val general = UByteArray(8) {0u}
    val address = UByteArray(2) {0u}
    val timer = 0u

    fun writeRegister(address: Byte, value: Byte){
        TODO("Not implemented yet")
    }

    fun readRegister(address: Byte) : Byte{
        TODO("Not implemented yet")
    }
}