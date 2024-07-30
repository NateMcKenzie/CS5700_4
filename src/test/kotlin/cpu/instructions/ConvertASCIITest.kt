package cpu.instructions

import D5700
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.test.Test
import kotlin.test.assertEquals

class ConvertASCIITest {
    @Test
    fun alphaTest() = runBlocking {
        val bytes = arrayOf(0x00, 0x0A, 0xE0, 0x10)
        D5700.run(ByteArray(4) {
            bytes[it].toByte()
        })
        delay(4)
        assertEquals(65u.toUByte(), D5700.cpu.registers.readRegister(1u.toUByte()))
    }

    @Test
    fun numericTest() = runBlocking {
        val bytes = arrayOf(0x00, 0x03, 0xE0, 0x10)
        D5700.run(ByteArray(4) {
            bytes[it].toByte()
        })
        delay(4)
        assertEquals(51u.toUByte(), D5700.cpu.registers.readRegister(1u.toUByte()))
    }
}