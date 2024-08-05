package cpu.instructions

import D5700
import cpu.CPU
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import memory.MemoryDriver
import kotlin.test.Test
import kotlin.test.assertEquals

class AddTest {
    @Test
    fun addTest() = runBlocking {
        val memory = MemoryDriver()
        val cpu = CPU()

        val bytes = arrayOf(0x00, 0x01, 0x01, 0x02, 0x10, 0x13)
        memory.flashROM(ByteArray(6) {
            bytes[it].toByte()
        })
        D5700.runInject(memory, cpu)
        delay(6)
        assertEquals(3u.toUByte(), cpu.readRegister(3u.toUByte()))
    }

    @Test
    fun overflowTest() = runBlocking {
        val memory = MemoryDriver()
        val cpu = CPU()

        val bytes = arrayOf(0x00, 0x02, 0x01, 0xFF, 0x10, 0x13)
        memory.flashROM(ByteArray(6) {
            bytes[it].toByte()
        })
        D5700.runInject(memory, cpu)
        delay(6)
        assertEquals(1u.toUByte(), cpu.readRegister(3u.toUByte()))
    }
}