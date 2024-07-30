package cpu.instructions

import cpu.Nibbled
import cpu.RegisterBank

class Jump(private val registerBank: RegisterBank) : Instruction(registerBank) {
    private lateinit var newPC: Pair<UByte, UByte>
    override fun mainFunction(nibbleds: Pair<Nibbled, Nibbled>) {
        newPC = Pair(nibbleds.first.second, nibbleds.second.byte())
    }

    override fun handleCounter(pc: Pair<UByte, UByte>): Pair<UByte, UByte> {
        return newPC
    }
}