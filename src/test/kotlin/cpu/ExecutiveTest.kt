package cpu

import D5700
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import memory.MemoryDriver
import kotlin.test.Test
import kotlin.test.assertEquals

class ExecutiveTest {
    @Test
    fun timerTest() = runBlocking {
        val memory = MemoryDriver()
        val cpu = CPU()

        val bytes = arrayOf(
            0xB0,
            0xF0,
            0x00,
            0x01,
            0x00,
            0x01,
            0x00,
            0x01,
            0x00,
            0x01,
            0x00,
            0x01,
            0x00,
            0x01,
            0x00,
            0x01,
            0x00,
            0x01
        )
        memory.flashROM(ByteArray(18) {
            bytes[it].toByte()
        })
        D5700.runInject(memory, cpu)
        delay(2)
        assertEquals(15u.toUByte(), cpu.timer)
        delay(16)
        assertEquals(14u.toUByte(), cpu.timer)
    }
}