package cpu.instructions

import D5700
import cpu.Nibbled
import cpu.RegisterBank

class Draw(private val registerBank: RegisterBank) : Instruction(registerBank) {
    override fun mainFunction(nibbleds: Pair<Nibbled, Nibbled>) {
        val value = registerBank.readRegister(nibbleds.first.second)
        val row = nibbleds.second.first
        val col = nibbleds.second.second
        D5700.writeScreen(value, row, col)
    }
}