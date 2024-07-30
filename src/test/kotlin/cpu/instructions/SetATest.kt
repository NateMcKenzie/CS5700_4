package cpu.instructions

import D5700
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.test.Test
import kotlin.test.assertEquals

class SetATest {
    @Test
    fun setATest() = runBlocking {
        val bytes = arrayOf(0xAF, 0xFF)
        D5700.run(ByteArray(2) {
            bytes[it].toByte()
        })
        delay(2)
        assertEquals(0xFFFu.toUShort(), D5700.cpu.registers.address)
    }
}