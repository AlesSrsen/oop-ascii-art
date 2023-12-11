# ASCII Art

[![pipeline status](https://gitlab.fit.cvut.cz/BI-OOP/B201/asciiart/badges/master/pipeline.svg)](https://gitlab.fit.cvut.cz/BI-OOP/B201/asciiart)

The idea of this project is to load images, translate them into ASCII ART images, optionally apply filters, and save
them. (https://courses.fit.cvut.cz/BI-OOP/projects/ASCII-art.html)

## How to do it

1. **Make your repository private**
2. **Read [the instructions](https://courses.fit.cvut.cz/BI-OOP/projects/ASCII-art.html)**
3. Play [lofi hip hop radio](https://www.youtube.com/watch?v=jfKfPfyJRdk)
4. [???](https://www.youtube.com/watch?v=ZXsQAXx_ao0)
5. Profit

---

# ASCII Art implementation

## Example run

In the root directory outside the sbt shell:
```bash
sbt "run --image ./src/main/resources/images/linear_gradient_rectangle.png --output-file ./out/image.txt --output-console --table-bourke-short --flip y"
```
In sbt shell in the root directory:
```sbtshell
run --image "./src/main/resources/images/linear_gradient_rectangle.png" --output-file "./out/image.txt" --output-console --table-bourke-short --flip y
```

## Available arguments

Currently available arguments are shown below. Some arguments need additional parameters.

### Loaders

There must be exactly one loader specified.

```
--image -i <path>
--image-random
```

### Filters

```
--flip <x/y>
--brightness <-255/+255>
--invert
```

### Converters

There must be maximum one converter specified.
By default `--table-bourke` is used.

```
--table-bourke
--table-bourke-short
--nonlinear-default
--nonlinear-outliers
--table-custom <table>
```

### Exporters

By default `--output-console` is used.

```
--output-file -o <path>
--output-console
```