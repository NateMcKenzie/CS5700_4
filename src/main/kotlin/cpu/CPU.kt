package cpu

class CPU {
    private val registers: RegisterBank = RegisterBank()
    private val parser: Parser = Parser(registers)
    private val executive: Executive = Executive(parser, this)
    val timer get() = registers.timer
    val address get() = registers.address

    fun start() {
        executive.start()
    }

    fun decrementTimer() {
        if (registers.timer > 0u)
            registers.timer = (registers.timer - 1u).toUByte()
    }

    fun readRegister(address: UByte) = registers.readRegister(address)
}
