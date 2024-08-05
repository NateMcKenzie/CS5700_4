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

class SetATest {
    @Test
    fun setATest() {
        val registers = RegisterBank()
        val byteCode = Pair(Nibbled( 0xAF.toUByte()),Nibbled( 0xFF.toUByte()))
        val instruction = SetA(registers)
        instruction.run(byteCode, 0u.toUShort())
        assertEquals(0xFFFu.toUShort(), registers.address)
    }
}