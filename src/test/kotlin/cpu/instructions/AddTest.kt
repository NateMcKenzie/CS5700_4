package cpu.instructions

import cpu.Nibbled
import cpu.RegisterBank
import kotlin.test.Test
import kotlin.test.assertEquals

class AddTest {
    @Test
    fun addTest() {
        val registers = RegisterBank()
        registers.writeRegister(0u.toUByte(), 1u.toUByte())
        registers.writeRegister(1u.toUByte(), 2u.toUByte())
        val instruction = Add(registers)
        instruction.run(Pair(Nibbled(0x10.toUByte()), Nibbled(0x13.toUByte())), 2u.toUShort())
        assertEquals(3u.toUByte(), registers.readRegister(3u.toUByte()))
    }

    @Test
    fun overflowTest() {
        val registers = RegisterBank()
        registers.writeRegister(0u.toUByte(), 2u.toUByte())
        registers.writeRegister(1u.toUByte(), 0xFFu.toUByte())
        val instruction = Add(registers)
        instruction.run(Pair(Nibbled(0x10.toUByte()), Nibbled(0x13.toUByte())), 2u.toUShort())
        assertEquals(1u.toUByte(), registers.readRegister(3u.toUByte()))
    }
}