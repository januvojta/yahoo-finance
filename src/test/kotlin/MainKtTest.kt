import org.assertj.core.api.Assertions.assertThat
import kotlin.test.Test

internal class MainKtTest {

    @Test
    fun examplePassingTest() {
        assertThat("Is this a String?").isExactlyInstanceOf(String::class.java)
    }

    @Test
    fun exampleFailingTest(){
        assertThat("Is Earth flat?").isEqualTo(true)
    }
}