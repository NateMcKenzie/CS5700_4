package cpu.instructions

import D5700
import cpu.CPU
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import memory.MemoryDriver
import kotlin.test.Test
import kotlin.test.assertEquals

class ReadTest {
    @Test
    fun readTest() = runBlocking {
        //Note: relies on Reading during ROM mode.
        val memory = MemoryDriver(ROMmode = true)
        val cpu = CPU()

        val bytes = arrayOf(0xA0, 0x05, 0x31, 0x00, 0x00, 0xAB)
        memory.flashROM(ByteArray(6) {
            bytes[it].toByte()
        })
        D5700.runInject(memory, cpu)
        delay(6)
        assertEquals(0xABu.toUByte(), cpu.readRegister(1u.toUByte()))
    }
}