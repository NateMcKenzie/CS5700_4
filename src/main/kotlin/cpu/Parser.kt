package cpu

import cpu.instructions.*

class Parser (registerBank : RegisterBank){
    private val instructionMap: Map<UByte, Instruction> = mapOf(
        0u.toUByte() to Store(registerBank),
        1u.toUByte() to Add(registerBank),
        2u.toUByte() to Subtract(registerBank),
        3u.toUByte() to Read(registerBank),
        4u.toUByte() to Write(registerBank),
        5u.toUByte() to Jump(registerBank),
        6u.toUByte() to ReadKeyboard(registerBank),
        7u.toUByte() to SwitchMemory(registerBank),
        8u.toUByte() to SkipEqual(registerBank),
        9u.toUByte() to SkipNotEqual(registerBank),
        10u.toUByte() to SetA(registerBank),
        11u.toUByte() to SetT(registerBank),
        12u.toUByte() to ReadT(registerBank),
        //13u.toUByte() to ConvertBase10(registerBank),
        //14u.toUByte() to ConvertASCII(registerBank),
        //15u.toUByte() to Draw(registerBank),
    )

    fun parse(input : UByte) : Instruction {
        val instruction = instructionMap[input]
        return instruction ?: throw NotImplementedError("Not a known instruction: $input")
    }
}