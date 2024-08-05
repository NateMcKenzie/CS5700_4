package cpu.instructions

import cpu.Nibbled
import cpu.RegisterBank

class ConvertASCII(private val registerBank: RegisterBank) : Instruction(registerBank) {
    override fun mainFunction(nibbleds: Pair<Nibbled, Nibbled>) {
        val byte = registerBank.readRegister(nibbleds.first.second)
        //Claude's work:
        val asciiValue = when (byte) {
            in 0u..9u -> (byte + '0'.code.toUInt()).toUByte()
            in 10u..15u -> (byte - 10u + 'A'.code.toUInt()).toUByte()
            else -> throw IllegalArgumentException("Byte value out of range for hex: $byte")
        }
        registerBank.writeRegister(nibbleds.second.first, asciiValue)
    }
}