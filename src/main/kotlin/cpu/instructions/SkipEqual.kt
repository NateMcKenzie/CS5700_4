package cpu.instructions

import bytesToShort
import cpu.Nibbled
import cpu.RegisterBank
import shortToBytes

class SkipEqual(private val registerBank: RegisterBank) : Instruction(registerBank) {
    private var amount = 2
    override fun mainFunction(nibbleds: Pair<Nibbled, Nibbled>) {
        val operand1 = registerBank.readRegister(nibbleds.first.second)
        val operand2 = registerBank.readRegister(nibbleds.second.first)
        amount = if (operand1 == operand2) 4 else 2
    }

    override fun handleCounter(pc: UShort) =
        (pc + amount.toUShort()).toUShort()
}