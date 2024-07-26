import java.io.File

fun main(){
    println("Where is the ROM?")
    val romPath = readln()
    val bytes = File(romPath).readBytes()
    D5700.run(bytes)
}
