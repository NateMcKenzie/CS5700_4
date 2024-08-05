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

class SetTTest {
    @Test
    fun setTTest() {
        val registers = RegisterBank()
        val byteCode = Pair(Nibbled( 0xBF.toUByte()),Nibbled( 0xFF.toUByte()))
        val instruction = SetT(registers)
        instruction.run(byteCode, 0u.toUShort())
        assertEquals(0xFFu.toUByte(), registers.timer)
    }
}