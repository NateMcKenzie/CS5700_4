package cpu.instructions

import cpu.Nibbled
import cpu.RegisterBank
import kotlin.test.Test
import kotlin.test.assertEquals

class ReadTTest {
    @Test
    fun readTTest() {
        val registers = RegisterBank()
        registers.timer = 0xFFu.toUByte()
        val byteCode = Pair(Nibbled(0xC7.toUByte()), Nibbled(0xFF.toUByte()))
        val instruction = ReadT(registers)
        instruction.run(byteCode, 0u.toUShort())
        assertEquals(0xFFu.toUByte(), registers.readRegister(0x7u.toUByte()))
    }
}