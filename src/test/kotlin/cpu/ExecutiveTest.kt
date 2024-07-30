package cpu

import D5700
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.test.Test
import kotlin.test.assertEquals

class ExecutiveTest {
    @Test
    fun timerTest() = runBlocking{
        val bytes = arrayOf(0xB0, 0xF0, 0x00, 0x01, 0x00, 0x01, 0x00, 0x01, 0x00, 0x01, 0x00, 0x01, 0x00, 0x01, 0x00, 0x01, 0x00, 0x01)
        D5700.run(ByteArray(18) {
            bytes[it].toByte()
        })
        delay(2)
        assertEquals(15u.toUByte(), D5700.cpu.registers.timer)
        delay(16)
        assertEquals(14u.toUByte(), D5700.cpu.registers.timer)
    }
}