package cpu.instructions

import cpu.Nibbled
import cpu.RegisterBank

class Subtract(private val registerBank: RegisterBank) : Instruction(registerBank) {
    override fun mainFunction(nibbleds: Pair<Nibbled, Nibbled>) {
        val operand1 = registerBank.readRegister(nibbleds.first.second)
        val operand2 = registerBank.readRegister(nibbleds.second.first)
        val difference = (operand1 - operand2).toUByte()
        registerBank.writeRegister(nibbleds.second.second, difference)
    }
}
