package cpu.instructions

import cpu.Nibbled
import cpu.RegisterBank

abstract class Instruction(registerBank: RegisterBank) {
    fun run(nibbleds: Pair<Nibbled, Nibbled>, pc: UShort): UShort {
        mainFunction(nibbleds)
        return handleCounter(pc)
    }

    open fun handleCounter(pc: UShort) =
        (pc + 2u).toUShort()

    abstract fun mainFunction(nibbleds: Pair<Nibbled, Nibbled>)
}