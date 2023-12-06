package exporters.image

/**
 * Exports ascii images to standard output.
 */
class StdOutAsciiImageExporter extends StreamAsciiImageExporter(System.out) {}
