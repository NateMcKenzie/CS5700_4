package cpu.instructions

import D5700
import cpu.CPU
import cpu.Nibbled
import cpu.RegisterBank
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import memory.MemoryDriver
import kotlin.test.Test
import kotlin.test.assertEquals

class SkipEqualTest {
    @Test
    fun equalTest() {
        val registers = RegisterBank()
        registers.writeRegister(0u.toUByte(), 1u.toUByte())
        registers.writeRegister(1u.toUByte(), 1u.toUByte())
        val byteCode = Pair(Nibbled( 0x80.toUByte()), Nibbled( 0x10.toUByte()))
        val instruction = SkipEqual(registers)
        val pc = instruction.run(byteCode, 0u.toUShort())
        assertEquals(4u.toUShort(), pc)
    }

    @Test
    fun unequalTest() {
        val registers = RegisterBank()
        registers.writeRegister(0u.toUByte(), 1u.toUByte())
        registers.writeRegister(1u.toUByte(), 2u.toUByte())
        val byteCode = Pair(Nibbled( 0x80.toUByte()), Nibbled( 0x10.toUByte()))
        val instruction = SkipEqual(registers)
        val pc = instruction.run(byteCode, 0u.toUShort())
        assertEquals(2u.toUShort(), pc)
    }
}