package cpu.instructions

import cpu.Nibbled
import cpu.RegisterBank
import kotlin.test.Test
import kotlin.test.assertEquals

class JumpTest {
    @Test
    fun jumpTest() {
        val instruction = Jump(RegisterBank())
        val newPC =
            instruction.run(Pair(Nibbled(0x55u.toUByte()), Nibbled(0x55u.toUByte())), Pair(0u.toUByte(), 0u.toUByte()))
        assertEquals(Pair(0x05u.toUByte(), 0x55u.toUByte()), newPC)
    }

    @Test
    fun pcIrrelevantTest() {
        val instruction = Jump(RegisterBank())
        val newPC = instruction.run(
            Pair(Nibbled(0x55u.toUByte()), Nibbled(0x55u.toUByte())),
            Pair(0xFFu.toUByte(), 6u.toUByte())
        )
        assertEquals(Pair(0x05u.toUByte(), 0x55u.toUByte()), newPC)
    }
}