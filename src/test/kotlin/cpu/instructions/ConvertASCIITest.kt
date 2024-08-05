package cpu.instructions

import D5700
import cpu.CPU
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import memory.MemoryDriver
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFails

class ConvertASCIITest {
    @Test
    fun alphaTest() = runBlocking {
        val memory = MemoryDriver()
        val cpu = CPU()

        val bytes = arrayOf(0x00, 0x0A, 0xE0, 0x10)
        memory.flashROM(ByteArray(4) {
            bytes[it].toByte()
        })
        D5700.runInject(memory, cpu)
        delay(4)
        assertEquals(65u.toUByte(), cpu.registers.readRegister(1u.toUByte()))
    }

    @Test
    fun numericTest() = runBlocking {
        val memory = MemoryDriver()
        val cpu = CPU()

        val bytes = arrayOf(0x00, 0x03, 0xE0, 0x10)
        memory.flashROM(ByteArray(4) {
            bytes[it].toByte()
        })
        D5700.runInject(memory, cpu)
        delay(4)
        assertEquals(51u.toUByte(), cpu.registers.readRegister(1u.toUByte()))
    }
}