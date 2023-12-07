package converters

/**
 * Converts input of type I to output of type O.
 *
 * @tparam I type of input
 * @tparam O type of output
 */
trait Converter[I, O] {

  /**
   * Converts input of type I to output of type O.
   * @param input input to convert
   * @return converted output
   */
  def convert(input: I): O
}
