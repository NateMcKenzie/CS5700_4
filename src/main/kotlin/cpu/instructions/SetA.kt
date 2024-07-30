package cpu.instructions

import bytesToShort
import cpu.Nibbled
import cpu.RegisterBank

class SetA(private val registerBank: RegisterBank) : Instruction(registerBank) {
    override fun mainFunction(nibbleds: Pair<Nibbled, Nibbled>) {
        registerBank.address = bytesToShort(Pair(nibbleds.first.second, nibbleds.second.byte()))
    }
}