package cpu.instructions

import D5700
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.test.Test

class DrawTest {
    @Test
    fun drawTest() = runBlocking {
        val bytes = arrayOf(0x00, 0x41, 0xF0, 0x00)
        D5700.run(ByteArray(4) {
            bytes[it].toByte()
        })
        delay(4)
    }
}