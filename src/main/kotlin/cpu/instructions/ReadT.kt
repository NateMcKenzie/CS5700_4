package cpu.instructions

import cpu.Nibbled
import cpu.RegisterBank

class ReadT(private val registerBank: RegisterBank) : Instruction(registerBank) {
    override fun mainFunction(nibbleds: Pair<Nibbled, Nibbled>) {
        val registerAddress = nibbleds.first.second
        registerBank.writeRegister(registerAddress, registerBank.timer)
    }
}