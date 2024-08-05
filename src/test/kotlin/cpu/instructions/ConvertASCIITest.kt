package cpu.instructions

import cpu.Nibbled
import cpu.RegisterBank
import kotlinx.coroutines.runBlocking
import kotlin.test.Test
import kotlin.test.assertEquals

class ConvertASCIITest {
    @Test
    fun alphaTest() {
        val registers = RegisterBank()
        registers.writeRegister(0u.toUByte(), 0xA.toUByte())
        val instruction = ConvertASCII(registers)
        val byteCode = Pair(Nibbled( 0xE0.toUByte()),Nibbled( 0x10.toUByte()))
        instruction.run(byteCode, 0u.toUShort())
        assertEquals(65u.toUByte(), registers.readRegister(1u.toUByte()))
    }

    @Test
    fun numericTest() {
        val registers = RegisterBank()
        registers.writeRegister(0u.toUByte(), 3u.toUByte())
        val instruction = ConvertASCII(registers)
        val byteCode = Pair(Nibbled( 0xE0.toUByte()),Nibbled( 0x10.toUByte()))
        instruction.run(byteCode, 0u.toUShort())
        assertEquals(51u.toUByte(), registers.readRegister(1u.toUByte()))
    }
}