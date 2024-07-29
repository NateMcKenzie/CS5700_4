import cpu.Nibbled
import kotlin.test.Test
import kotlin.test.assertEquals

class NibbledTest {
    @Test
    fun zeroTest(){
        val nibbled = Nibbled(0x00u.toUByte())
        assertEquals(0u.toUByte() to 0u.toUByte(), nibbled.nibbles)
        assertEquals(0u.toUByte(), nibbled.byte())
    }

    @Test
    fun normalTest(){
        val nibbled = Nibbled(0x5Bu.toUByte())
        assertEquals(0x5u.toUByte() to 0xBu.toUByte(), nibbled.nibbles)
        assertEquals(0x5Bu.toUByte(), nibbled.byte())
    }

    @Test
    fun bigTest(){
        val nibbled = Nibbled(0xFFu.toUByte())
        assertEquals(0xFu.toUByte() to 0xFu.toUByte(), nibbled.nibbles)
        assertEquals(0xFFu.toUByte(), nibbled.byte())
    }
}