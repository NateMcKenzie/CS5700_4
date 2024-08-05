package cpu.instructions

import cpu.Nibbled
import cpu.RegisterBank
import kotlin.test.Test
import kotlin.test.assertEquals

class SubtractTest {
    @Test
    fun subtractTest() {
        val registers = RegisterBank()
        registers.writeRegister(0u.toUByte(), 5u.toUByte())
        registers.writeRegister(1u.toUByte(), 2u.toUByte())
        val byteCode = Pair(Nibbled(0x20.toUByte()), Nibbled(0x13.toUByte()))
        val instruction = Subtract(registers)
        instruction.run(byteCode, 0u.toUShort())
        assertEquals(3u.toUByte(), registers.readRegister(3u.toUByte()))
    }

    @Test
    fun overflowTest() {
        val registers = RegisterBank()
        registers.writeRegister(0u.toUByte(), 1u.toUByte())
        registers.writeRegister(1u.toUByte(), 2u.toUByte())
        val byteCode = Pair(Nibbled(0x20.toUByte()), Nibbled(0x13.toUByte()))
        val instruction = Subtract(registers)
        instruction.run(byteCode, 0u.toUShort())
        assertEquals(0xFFu.toUByte(), registers.readRegister(3u.toUByte()))
    }
}
