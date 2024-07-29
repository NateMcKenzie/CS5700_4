package cpu.instructions

import cpu.Nibbled
import cpu.RegisterBank

class Store(private val registerBank: RegisterBank) : Instruction(registerBank) {
    override fun mainFunction(nibbleds: Pair<Nibbled, Nibbled>) {
        val value = nibbleds.second.byte()
        val address = nibbleds.first.second
        registerBank.writeRegister(address, value)
    }
}