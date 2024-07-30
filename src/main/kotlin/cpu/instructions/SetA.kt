package cpu.instructions

import cpu.Nibbled
import cpu.RegisterBank

@OptIn(ExperimentalUnsignedTypes::class)
class SetA(private val registerBank: RegisterBank) : Instruction(registerBank) {
    override fun mainFunction(nibbleds: Pair<Nibbled, Nibbled>) {
        registerBank.address[0] = nibbleds.first.second
        registerBank.address[1] = nibbleds.second.byte()
    }
}