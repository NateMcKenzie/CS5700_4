package cpu.instructions

import D5700
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.test.Test
import kotlin.test.assertEquals

class ReadTTest {
    @Test
    fun readTTest() = runBlocking {
        val bytes = arrayOf(0xBF, 0xFF, 0xC7, 0xFF)
        D5700.run(ByteArray(4) {
            bytes[it].toByte()
        })
        delay(4)
        assertEquals(0xFFu.toUByte(), D5700.cpu.registers.readRegister(0x7u.toUByte()))
    }
}