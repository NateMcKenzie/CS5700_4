package cpu.instructions

import D5700
import cpu.CPU
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import memory.MemoryDriver
import org.junit.jupiter.api.parallel.Execution
import org.junit.jupiter.api.parallel.ExecutionMode
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

@Execution(ExecutionMode.SAME_THREAD)
class SwitchMemoryTest {
    @Test
    fun switchMemoryTest() = runBlocking {
        val memory = MemoryDriver(false)
        val cpu = CPU()

        val bytes = arrayOf(0x70, 0x00)
        memory.flashROM(ByteArray(2) {
            bytes[it].toByte()
        })
        D5700.runInject(memory, cpu)
        delay(2)
        assertTrue(memory.ROMmode)
    }

    @Test
    fun switchMemoryNotTest() = runBlocking {
        val memory = MemoryDriver(true)
        val cpu = CPU()

        val bytes = arrayOf(0x70, 0x00)
        memory.flashROM(ByteArray(2) {
            bytes[it].toByte()
        } )
        D5700.runInject(memory, cpu)
        delay(2)
        assertFalse(memory.ROMmode)
    }

    @Test
    fun multiSwitchMemoryTest() = runBlocking {
        val memory = MemoryDriver(true)
        val cpu = CPU()

        val bytes = arrayOf(0x7A, 0x31, 0x7B, 0xdd, 0x77, 0x77, 0x7C, 0xCC)
        memory.flashROM(ByteArray(8) {
            bytes[it].toByte()
        } )
        D5700.runInject(memory, cpu)
        delay(8)
        assertTrue(memory.ROMmode)
    }
}