package cpu.instructions

import D5700
import kotlin.test.Test
import kotlin.test.assertEquals

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

class SubtractTest {
    @Test
    fun subtractTest() = runBlocking {
        val bytes = arrayOf(0x00, 0x05, 0x01, 0x02, 0x20, 0x13)
        D5700.run(ByteArray(6){
            bytes[it].toByte()
        }, false)
        delay(6)
        assertEquals(3u.toUByte(), D5700.cpu.registers.readRegister(3u.toUByte()))
    }

    @Test
    fun overflowTest() = runBlocking {
        val bytes = arrayOf(0x00, 0x01, 0x01, 0x02, 0x20, 0x13)
        D5700.run(ByteArray(6){
            bytes[it].toByte()
        }, false)
        delay(6)
        assertEquals(0xFFu.toUByte(), D5700.cpu.registers.readRegister(3u.toUByte()))
    }
}
