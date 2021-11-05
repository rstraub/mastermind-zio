import org.scalatest.flatspec.AnyFlatSpec

class KataTest extends AnyFlatSpec {
  "double" should "double numbers" in {
    val result = Kata.double(2)

    assert(result === 4)
  }
}
