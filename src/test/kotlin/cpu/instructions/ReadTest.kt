package cpu.instructions

import D5700
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.test.Test
import kotlin.test.assertEquals

class ReadTest {
    @Test
    fun readTest() = runBlocking {
        //Note: relies on Reading during ROM mode.
        val bytes = arrayOf(0x30, 0x00, 0x00, 0xAB)
        D5700.run(ByteArray(4) {
            bytes[it].toByte()
        })
        delay(4)
        assertEquals(0xABu.toUByte(), D5700.cpu.registers.readRegister(0u.toUByte()))
    }
}