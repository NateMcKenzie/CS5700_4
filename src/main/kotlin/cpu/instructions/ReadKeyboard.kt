package cpu.instructions

import cpu.Nibbled
import cpu.RegisterBank

class ReadKeyboard(private val registerBank: RegisterBank) : Instruction(registerBank) {
    override fun mainFunction(nibbleds: Pair<Nibbled, Nibbled>) {
        val address = nibbleds.first.second
        val value = D5700.keyboard.read()
        registerBank.writeRegister(address, value)
    }
}