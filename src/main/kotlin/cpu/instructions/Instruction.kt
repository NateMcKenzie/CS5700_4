package cpu.instructions

import bytesToShort
import cpu.Nibbled
import cpu.RegisterBank
import shortToBytes

abstract class Instruction(registerBank: RegisterBank) {
    fun run(nibbleds: Pair<Nibbled, Nibbled>, pc: UShort): UShort {
        mainFunction(nibbleds)
        return handleCounter(pc)
    }

    open fun handleCounter(pc: UShort) =
        (pc + 2u).toUShort()

    abstract fun mainFunction(nibbleds: Pair<Nibbled, Nibbled>)
}