package cpu

import cpu.instructions.Instruction

class Parser (private val registerBank : RegisterBank){
    private val instructionMap = mapOf(
        "add" to "add"
    )

    fun parse(input: Pair<Nibbled, Nibbled>) : Instruction {
        TODO("Not implemented yet")
    }
}