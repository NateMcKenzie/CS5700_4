import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class BinaryUtilsTest {
    @Test
    fun shortToBytesTest() {
        assertEquals(Pair(0.toUByte(), 0.toUByte()), shortToBytes(0u))
        assertEquals(Pair(0.toUByte(), 1.toUByte()), shortToBytes(1u))
        assertEquals(Pair(1.toUByte(), 0.toUByte()), shortToBytes(256u))
        assertEquals(Pair(255.toUByte(), 255.toUByte()), shortToBytes(65535u))
        assertEquals(Pair(128.toUByte(), 0.toUByte()), shortToBytes(32768u))
        assertEquals(Pair((-1).toUByte(), (-1).toUByte()), shortToBytes(65535u))
    }

    @Test
    fun bytesToShortTest() {
        assertEquals(0u, bytesToShort(0.toUByte() to 0.toUByte()))
        assertEquals(1u, bytesToShort(0.toUByte() to 1.toUByte()))
        assertEquals(256u, bytesToShort(1.toUByte() to 0.toUByte()))
        assertEquals(65535u, bytesToShort(255.toUByte() to 255.toUByte()))
        assertEquals(32768u, bytesToShort(128.toUByte() to 0.toUByte()))
        assertEquals(65535u, bytesToShort((-1).toUByte() to (-1).toUByte()))
    }

    @Test
    fun stringToByteTest() {
        assertEquals(0xFFu.toUByte(), stringToByte("FF"))
    }

    @Test
    fun stringToByteEmptyTest() {
        assertEquals(0x0u.toUByte(), stringToByte(""))
    }

    @Test
    fun stringToByteShortTest() {
        assertEquals(0xFu.toUByte(), stringToByte("F"))
    }

    @Test
    fun stringToByteLongTest() {
        assertEquals(0xFFu.toUByte(), stringToByte("FF0000"))
    }

    @Test
    fun stringToByteInvalidTest() {
        assertFailsWith<IllegalArgumentException> {
            stringToByte("HI")
        }
        assertFailsWith<IllegalArgumentException> {
            stringToByte("FI")
        }
    }
}