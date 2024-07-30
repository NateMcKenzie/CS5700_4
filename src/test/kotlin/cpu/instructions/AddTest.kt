package cpu.instructions

import D5700
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.test.Test
import kotlin.test.assertEquals

class AddTest {
    @Test
    fun addTest() = runBlocking {
        val bytes = arrayOf(0x00, 0x01, 0x01, 0x02, 0x10, 0x13)
        D5700.run(ByteArray(6) {
            bytes[it].toByte()
        }, false)
        delay(6)
        assertEquals(3u.toUByte(), D5700.cpu.registers.readRegister(3u.toUByte()))
    }

    @Test
    fun overflowTest() = runBlocking {
        val bytes = arrayOf(0x00, 0x02, 0x01, 0xFF, 0x10, 0x13)
        D5700.run(ByteArray(6) {
            bytes[it].toByte()
        }, false)
        delay(6)
        assertEquals(1u.toUByte(), D5700.cpu.registers.readRegister(3u.toUByte()))
    }
}