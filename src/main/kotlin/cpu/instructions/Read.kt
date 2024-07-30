package cpu.instructions

import D5700
import cpu.Nibbled
import cpu.RegisterBank
import shortToBytes

class Read(private val registerBank: RegisterBank) : Instruction(registerBank) {
    override fun mainFunction(nibbleds: Pair<Nibbled, Nibbled>) {
        val memoryAddress = registerBank.address
        val value = D5700.memory.read(memoryAddress)
        val registerAddress = nibbleds.first.second
        registerBank.writeRegister(registerAddress, value)
    }
}