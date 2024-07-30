package cpu

class CPU {
    val registers = RegisterBank()
    val parser = Parser(registers)
    val executive = Executive(parser)

    fun start(){
        executive.start()
    }

    fun decrementTimer() {
        registers.timer = (registers.timer - 1u).toUByte()
    }
}
