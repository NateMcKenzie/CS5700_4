package cpu

class CPU {
    val registers = RegisterBank()
    val parser = Parser(registers)
    val executive = Executive(parser)

    fun start(){
        TODO("Not implemented yet")
    }
}
