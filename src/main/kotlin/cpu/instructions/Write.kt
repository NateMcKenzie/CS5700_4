package cpu.instructions

import cpu.Nibbled
import cpu.RegisterBank

@OptIn(ExperimentalUnsignedTypes::class)
class Write(private val registerBank: RegisterBank) : Instruction(registerBank) {
    override fun mainFunction(nibbleds: Pair<Nibbled, Nibbled>) {
        val memoryAddress = registerBank.address
        val registerAddress = nibbleds.first.second
        val value = registerBank.readRegister(registerAddress)
        D5700.memory.write(memoryAddress[0] to memoryAddress[1], value)
    }
}