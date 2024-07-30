package cpu.instructions

import D5700
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class SwitchMemoryTest {
    @Test
    fun switchMemoryTest() = runBlocking {
        val bytes = arrayOf(0x70, 0x00)
        D5700.run(ByteArray(2) {
            bytes[it].toByte()
        }, ROMmode = false)
        delay(2)
        assertTrue(D5700.memory.ROMmode)
    }

    @Test
    fun switchMemoryNotTest() = runBlocking {
        val bytes = arrayOf(0x70, 0x00)
        D5700.run(ByteArray(2) {
            bytes[it].toByte()
        }, ROMmode = true)
        delay(2)
        assertFalse(D5700.memory.ROMmode)
    }

    @Test
    fun multiSwitchMemoryTest() = runBlocking {
        val bytes = arrayOf(0x7A, 0x31, 0x7B, 0xdd, 0x77, 0x77, 0x7C, 0xCC)
        D5700.run(ByteArray(8) {
            bytes[it].toByte()
        }, ROMmode = true)
        delay(8)
        assertTrue(D5700.memory.ROMmode)
    }
}