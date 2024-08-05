package cpu.instructions

import D5700
import cpu.CPU
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import memory.MemoryDriver
import kotlin.test.Test
import kotlin.test.assertEquals

class StoreTest {
    @Test
    fun storeTest() = runBlocking {
        val memory = MemoryDriver()
        val cpu = CPU()

        val bytes = arrayOf(0x00, 0xff)
        memory.flashROM(ByteArray(2) {
            bytes[it].toByte()
        })
        D5700.runInject(memory, cpu)
        delay(2)
        assertEquals(0xffu.toUByte(), cpu.registers.readRegister(0u.toUByte()))
    }

    @Test
    fun addressTest() = runBlocking {
        val memory = MemoryDriver()
        val cpu = CPU()

        val bytes = arrayOf(0x07, 0xcd)
        memory.flashROM(ByteArray(2) {
            bytes[it].toByte()
        })
        D5700.runInject(memory, cpu)
        delay(2)
        assertEquals(0xcdu.toUByte(), cpu.registers.readRegister(7u.toUByte()))
    }
}