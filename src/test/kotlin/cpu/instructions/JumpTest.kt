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
            instruction.run(Pair(Nibbled(0x55u.toUByte()), Nibbled(0x55u.toUByte())), 0u.toUShort())
        assertEquals(0x0555u.toUShort(), newPC)
    }

    @Test
    fun pcIrrelevantTest() {
        val instruction = Jump(RegisterBank())
        val newPC = instruction.run(
            Pair(Nibbled(0x55u.toUByte()), Nibbled(0x55u.toUByte())),
            0xFF06u.toUShort()
        )
        assertEquals(0x0555u.toUShort(), newPC)
    }
}