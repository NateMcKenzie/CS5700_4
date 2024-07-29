package cpu.instructions

import D5700
import kotlin.test.Test
import kotlin.test.assertEquals

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

class WriteTest {
    @Test
    fun writeTest() = runBlocking {
        val bytes = arrayOf(0x00, 0xA0, 0x40, 0x00)
        D5700.run(ByteArray(4){
            bytes[it].toByte()
        }, ROMmode = false)
        delay(4)
        assertEquals(0xA0u.toUByte(), D5700.memory.read(0u.toUByte() to 0u.toUByte()))
    }
}