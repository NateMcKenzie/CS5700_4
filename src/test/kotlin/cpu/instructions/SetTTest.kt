package cpu.instructions

import cpu.Nibbled
import cpu.RegisterBank
import kotlin.test.Test
import kotlin.test.assertEquals

class SetTTest {
    @Test
    fun setTTest() {
        val registers = RegisterBank()
        val byteCode = Pair(Nibbled(0xBF.toUByte()), Nibbled(0xFF.toUByte()))
        val instruction = SetT(registers)
        instruction.run(byteCode, 0u.toUShort())
        assertEquals(0xFFu.toUByte(), registers.timer)
    }
}