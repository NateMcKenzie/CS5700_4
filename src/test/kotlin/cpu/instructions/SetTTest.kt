package cpu.instructions

import D5700
import cpu.CPU
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import memory.MemoryDriver
import kotlin.test.Test
import kotlin.test.assertEquals

class SetTTest {
    @Test
    fun setTTest() = runBlocking {
        val memory = MemoryDriver()
        val cpu = CPU()

        val bytes = arrayOf(0xBF, 0xFF)
        memory.flashROM(ByteArray(2) {
            bytes[it].toByte()
        })
        D5700.runInject(memory, cpu)
        delay(2)
        assertEquals(0xFFu.toUByte(), cpu.timer)
    }
}