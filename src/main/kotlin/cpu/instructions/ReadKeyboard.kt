package cpu.instructions

import D5700
import cpu.Nibbled
import cpu.RegisterBank

class ReadKeyboard(private val registerBank: RegisterBank) : Instruction(registerBank) {
    override fun mainFunction(nibbleds: Pair<Nibbled, Nibbled>) {
        val address = nibbleds.first.second
        val value = D5700.readKeyboard()
        registerBank.writeRegister(address, value)
    }
}