package cpu.instructions

import D5700
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.test.Test
import kotlin.test.assertEquals

class StoreTest {
    @Test
    fun storeTest() = runBlocking {
        val bytes = arrayOf(0x00, 0xff)
        D5700.run(ByteArray(2) {
            bytes[it].toByte()
        }, false)
        delay(2)
        assertEquals(0xffu.toUByte(), D5700.cpu.registers.readRegister(0u.toUByte()))
    }

    @Test
    fun addressTest() = runBlocking {
        val bytes = arrayOf(0x07, 0xcd)
        D5700.run(ByteArray(2) {
            bytes[it].toByte()
        }, false)
        delay(2)
        assertEquals(0xcdu.toUByte(), D5700.cpu.registers.readRegister(7u.toUByte()))
    }
}