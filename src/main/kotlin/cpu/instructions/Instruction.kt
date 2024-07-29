package cpu.instructions

import bytesToShort
import cpu.Nibbled
import cpu.RegisterBank
import shortToBytes

abstract class Instruction (private val registerBank : RegisterBank){
    fun run(nibbleds: Pair<Nibbled, Nibbled>, pc: Pair<UByte,UByte>) : Pair<UByte,UByte> {
        mainFunction(nibbleds)
        return handleCounter(pc)
    }

    open fun handleCounter(pc : Pair<UByte, UByte>) =
        shortToBytes((bytesToShort(pc) + 2u).toUShort())

    abstract fun mainFunction(nibbleds: Pair<Nibbled, Nibbled>)
}