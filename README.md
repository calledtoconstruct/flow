![Code QL](https://github.com/calledtoconstruct/flow/actions/workflows/codeql.yml/badge.svg)

# Flow

A collection of potentially useful classes for streamlining the process flow of Java applications.

## [Either](https://github.com/calledtoconstruct/flow/blob/main/flow/src/main/java/net/calledtoconstruct/Either.java)

...

### Return an Either

```java
    import net.calledtoconstruct.Either;
    import net.calledtoconstruct.Left;
    import net.calledtoconstruct.Right;

    public Either<..., String> getData() {
        try {
            ...
            final var data = repository.findAll();
            ...
            return new Left<>(data);
        } catch (final DataAccessException exception) {
            return new Right<>(exception.getMessage());
        }
    }
```

## [Tuple](https://github.com/calledtoconstruct/flow/blob/main/flow/src/main/java/net/calledtoconstruct/Tuple.java)

A collection of one or more values of discrete data types.  In contrast to Array or List which require elements of the collection to share the same data type, the Tuple interface and implementations, allow for elements of different data types.  However, the trade-off is that Tuple can only support a small number of elements.  This library currently supports up-to four (4) elements.

Implementations: 

* [Tuple1](https://github.com/calledtoconstruct/flow/blob/main/flow/src/main/java/net/calledtoconstruct/Tuple1.java) - Example: new Tuple1\<String\>

* [Tuple2](https://github.com/calledtoconstruct/flow/blob/main/flow/src/main/java/net/calledtoconstruct/Tuple2.java) - Example: new Tuple2\<String, Integer\>

* [Tuple3](https://github.com/calledtoconstruct/flow/blob/main/flow/src/main/java/net/calledtoconstruct/Tuple3.java) - Example: new Tuple3\<Long, String, String\>

* [Tuple4](https://github.com/calledtoconstruct/flow/blob/main/flow/src/main/java/net/calledtoconstruct/Tuple4.java) - Example: new Tuple4\<MyClass, Long, Long, String\>

* [Tuple5](https://github.com/calledtoconstruct/flow/blob/main/flow/src/main/java/net/calledtoconstruct/Tuple5.java) - Example: new Tuple5\<String, Integer, Long, Short, Char\>

* [Tuple6](https://github.com/calledtoconstruct/flow/blob/main/flow/src/main/java/net/calledtoconstruct/Tuple6.java) - Example: new Tuple6\<Integer, Long, Short, Char, Byte, Float\>

* [Tuple7](https://github.com/calledtoconstruct/flow/blob/main/flow/src/main/java/net/calledtoconstruct/Tuple7.java) - Example: new Tuple7\<MyClass, String, Long, Double, String, Integer, Integer\>

* [Tuple8](https://github.com/calledtoconstruct/flow/blob/main/flow/src/main/java/net/calledtoconstruct/Tuple8.java) - Example: new Tuple8\<Double, Double, String, Long, Short, String, String, Integer\>

...

### Return a Tuple

This builds on the Either example:

```java
    import org.springframework.util.StopWatch;

    import net.calledtoconstruct.Either;
    import net.calledtoconstruct.Left;
    import net.calledtoconstruct.Right;
    import net.calledtoconstruct.Tuple3;

    public Either<Tuple3<List<Entity>, Long, Long>, String> getDataAndCountTimed() {
        try {
            final var stopWatch = new StopWatch();
            
            stopWatch.start();
            final var rows = repository.findAll();
            final var count = repository.count();
            stopWatch.stop();

            final var duration = stopWatch.getLastTaskTimeMillis();

            return new Left<>(new Tuple3<>(rows, count, duration));
        } catch (final DataAccessException exception) {
            return new Right<>(exception.getMessage());
        }
    }
```
