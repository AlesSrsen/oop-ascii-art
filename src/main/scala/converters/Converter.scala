package converters

trait Converter[I, O] {
    def convert(input: I): O
}
