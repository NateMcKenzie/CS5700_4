import java.io.File

fun main(){
    print("Where is the ROM?")
    val romPath = readln()
    val bytes = File(romPath).readBytes()
    D5700.init(bytes)
    print("DONE")
}