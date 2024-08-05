package cpu.instructions

import D5700
import cpu.CPU
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import memory.MemoryDriver
import kotlin.test.Test
import kotlin.test.assertEquals

class SkipEqualTest {
    @Test
    fun equalTest() = runBlocking {
        val memory = MemoryDriver()
        val cpu = CPU()

        val bytes = arrayOf(0x00, 0x01, 0x01, 0x01, 0x80, 0x10, 0x00, 0x0F)
        memory.flashROM(ByteArray(8) {
            bytes[it].toByte()
        })
        D5700.runInject(memory, cpu)
        delay(8)
        assertEquals(1u.toUByte(), cpu.readRegister(0u.toUByte()))
    }

    @Test
    fun unequalTest() = runBlocking {
        val memory = MemoryDriver()
        val cpu = CPU()

        val bytes = arrayOf(0x00, 0x01, 0x01, 0x02, 0x80, 0x10, 0x00, 0x0F)
        memory.flashROM(ByteArray(8) {
            bytes[it].toByte()
        })
        D5700.runInject(memory, cpu)
        delay(8)
        assertEquals(0xFu.toUByte(), cpu.readRegister(0u.toUByte()))
    }
}