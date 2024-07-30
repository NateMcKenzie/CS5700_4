package cpu.instructions

import cpu.Nibbled
import cpu.RegisterBank
import nibblesToByte

class SetT(private val registerBank: RegisterBank) : Instruction(registerBank) {
    override fun mainFunction(nibbleds: Pair<Nibbled, Nibbled>) {
        registerBank.timer = nibblesToByte(nibbleds.first.second, nibbleds.second.first)
    }
}