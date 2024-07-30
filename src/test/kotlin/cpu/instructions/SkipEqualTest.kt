package cpu.instructions

import D5700
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.test.Test
import kotlin.test.assertEquals

class SkipEqualTest {
    @Test
    fun equalTest() = runBlocking {
        val bytes = arrayOf(0x00, 0x01, 0x01, 0x01, 0x80, 0x10, 0x00, 0x0F)
        D5700.run(ByteArray(8) {
            bytes[it].toByte()
        })
        delay(8)
        assertEquals(1u.toUByte(), D5700.cpu.registers.readRegister(0u.toUByte()))
    }

    @Test
    fun unequalTest() = runBlocking {
        val bytes = arrayOf(0x00, 0x01, 0x01, 0x02, 0x80, 0x10, 0x00, 0x0F)
        D5700.run(ByteArray(8) {
            bytes[it].toByte()
        })
        delay(8)
        assertEquals(0xFu.toUByte(), D5700.cpu.registers.readRegister(0u.toUByte()))
    }
}