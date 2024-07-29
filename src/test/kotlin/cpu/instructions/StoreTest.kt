package cpu.instructions

import D5700
import kotlin.test.Test
import kotlin.test.assertEquals

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

class StoreTest {
    @Test
    fun storeTest() = runBlocking {
        val bytes = arrayOf(0x00, 0xff)
        D5700.run(ByteArray(2){
            bytes[it].toByte()
        })
        delay(2)
        assertEquals(0xffu.toUByte(), D5700.cpu.registers.readRegister(0u.toUByte()))
    }
}