package exporters.text

/**
 * Exports text to standard output.
 */
class StdOutTextExporter extends StreamTextExporter(System.out) {}
