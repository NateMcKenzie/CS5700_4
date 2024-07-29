package cpu.instructions

import D5700
import cpu.Nibbled
import cpu.RegisterBank

@OptIn(ExperimentalUnsignedTypes::class)
class Read(private val registerBank: RegisterBank) : Instruction(registerBank) {
    override fun mainFunction(nibbleds: Pair<Nibbled, Nibbled>) {
        val memoryAddress = registerBank.address
        val value = D5700.memory.read(memoryAddress[0] to memoryAddress[1])
        val register = nibbleds.first.second
        registerBank.writeRegister(register, value)
    }
}