package cpu.instructions

import cpu.Nibbled
import cpu.RegisterBank

abstract class Instruction (private val registerBank : RegisterBank){
    fun run(nibbles: Pair<Nibbled, Nibbled>, pc: Pair<UByte,UByte>) : Pair<UByte,UByte> {
        TODO("Not implemented yet")
    }
    open fun handleCounter(){
        TODO("Not implemented yet")
    }
    abstract fun mainFunction()
}