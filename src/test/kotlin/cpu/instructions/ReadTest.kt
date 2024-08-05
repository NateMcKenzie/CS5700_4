package cpu.instructions

import D5700
import cpu.CPU
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import memory.MemoryDriver
import kotlin.test.Test
import kotlin.test.assertEquals

class ReadTest {
    //Note: relies on Reading during ROM mode.
    @Test
    fun readTest() = runBlocking {
        val memory = MemoryDriver()
        val cpu = CPU()

        val bytes = arrayOf(0x30, 0x00, 0x00, 0xAB)
        memory.flashROM(ByteArray(4) {
            bytes[it].toByte()
        })
        D5700.runInject(memory, cpu)
        delay(4)
        assertEquals(0xABu.toUByte(), cpu.readRegister(0u.toUByte()))
    }
}