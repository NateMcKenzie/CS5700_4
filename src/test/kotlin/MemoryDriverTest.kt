import memory.MemoryDriver
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class MemoryDriverTest {
    @Test
    fun ramReadWriteTest(){
        val driver = MemoryDriver()
        if(driver.ROMmode){
            driver.switch()
        }
        driver.write(Pair(0u,0u), 0xFu)
        driver.write(Pair(0u,0xFFu), 0x5u)
        assertEquals(0xFu, driver.read(Pair(0u,0u)))
        assertEquals(0x5u, driver.read(Pair(0u,0xFFu)))
    }

    @Test
    fun romWriteFailsTest(){
        val driver = MemoryDriver()
        if(!driver.ROMmode){
            driver.switch()
        }
        assertFailsWith<IllegalAccessError> {
            driver.write(Pair(0u,0u), 1u)
        }
    }

    @Test
    fun romFlashReadTest(){
        val driver = MemoryDriver()
        driver.flashROM(ByteArray(10) { it.toByte() })
        if(!driver.ROMmode){
            driver.switch()
        }
        for (i in 0..<10){
            val iByte = i.toUByte()
            assertEquals(iByte, driver.read(Pair(0u, iByte)))
        }
        for (i in 10..<4096){
            assertEquals(0u, driver.read(shortToBytes(i.toUShort())))
        }
    }

    @Test
    fun switchTest(){
        //Write different data to each memory device
        val driver = MemoryDriver()
        driver.flashROM(ByteArray(10) { it.toByte() })
        if(driver.ROMmode){
            driver.switch()
        }
        for (i in 0..<10){
            driver.write(shortToBytes(i.toUShort()), (i*2).toUByte())
        }

        //Ensure both read separately
        for (i in 0..<10){
            assertEquals((i*2).toUByte(), driver.read(shortToBytes(i.toUShort())))
        }
        driver.switch()
        for (i in 0..<10){
            assertEquals(i.toUByte(), driver.read(shortToBytes(i.toUShort())))
        }
    }
}