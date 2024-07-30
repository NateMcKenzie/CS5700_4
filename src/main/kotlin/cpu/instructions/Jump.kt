package cpu.instructions

import bytesToShort
import cpu.Nibbled
import cpu.RegisterBank

class Jump(registerBank: RegisterBank) : Instruction(registerBank) {
    private var newPC: UShort = 0u
    override fun mainFunction(nibbleds: Pair<Nibbled, Nibbled>) {
        newPC = bytesToShort(Pair(nibbleds.first.second, nibbleds.second.byte()))
    }

    override fun handleCounter(pc: UShort): UShort {
        return newPC
    }
}