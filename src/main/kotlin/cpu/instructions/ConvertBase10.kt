package cpu.instructions

import D5700
import cpu.Nibbled
import cpu.RegisterBank
import shortToBytes

class ConvertBase10(private val registerBank: RegisterBank) : Instruction(registerBank) {
    override fun mainFunction(nibbleds: Pair<Nibbled, Nibbled>) {
        val memoryAddress = registerBank.address
        val registerAddress = nibbleds.first.second
        val value = registerBank.readRegister(registerAddress)
        val hundreds = value / 100u
        val tens = (value / 10u) % 10u
        val ones = value % 10u
        D5700.memory.write(memoryAddress, hundreds.toUByte())
        D5700.memory.write((memoryAddress+1u).toUShort(), tens.toUByte())
        D5700.memory.write((memoryAddress+2u).toUShort(), ones.toUByte())
    }
}