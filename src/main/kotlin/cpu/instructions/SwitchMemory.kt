package cpu.instructions

import D5700
import cpu.Nibbled
import cpu.RegisterBank

class SwitchMemory(private val registerBank: RegisterBank) : Instruction(registerBank) {
    override fun mainFunction(nibbleds: Pair<Nibbled, Nibbled>) {
        D5700.switchROMmode()
    }
}