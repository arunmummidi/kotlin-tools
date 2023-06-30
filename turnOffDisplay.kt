import java.awt.GraphicsEnvironment

const val LAPTOP_DISPLAY = "LVDS-1"

fun main() {


    val graphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment()
    val screens = graphicsEnvironment.screenDevices
    println("Available displays: ${screens.size}")

    if(screens.size > 1) {
        println("Attempting to turn of Laptop display with ID, $LAPTOP_DISPLAY")
        val result = ProcessBuilder("xrandr", "--output", LAPTOP_DISPLAY, "--off")
            .redirectOutput(ProcessBuilder.Redirect.INHERIT)
            .redirectError(ProcessBuilder.Redirect.INHERIT)
            .start()
            .waitFor()
        assert(result == 0)
    } else println("Detected single display. Doing nothing.")
}
