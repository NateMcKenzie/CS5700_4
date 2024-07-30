package cpu.instructions

import D5700
import kotlin.test.Test
import kotlin.test.assertEquals

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

class SetTTest {
    @Test
    fun setTTest() = runBlocking {
        val bytes = arrayOf(0xBF, 0xFF)
        D5700.run(ByteArray(2){
            bytes[it].toByte()
        })
        delay(2)
        assertEquals(0xFFu.toUByte(), D5700.cpu.registers.timer)
    }
}