package cpu.instructions

import D5700
import cpu.CPU
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import memory.MemoryDriver
import kotlin.test.Test
import kotlin.test.assertEquals

class WriteTest {
    @Test
    fun writeTest() = runBlocking {
        val memory = MemoryDriver()
        val cpu = CPU()

        val bytes = arrayOf(0x00, 0xA0, 0x40, 0x00)
        memory.flashROM(ByteArray(4) {
            bytes[it].toByte()
        })
        D5700.runInject(memory, cpu)
        delay(5)
        assertEquals(0xA0u.toUByte(), memory.read(0u.toUShort()))
    }
}