# Additions to the stream API

## toList()

As you know, you can collect the results of a stream using the Collector API.
There are many powerful collectors, and you can even define your own.

One collector however is used a lot more than any other: [Collectors.toList()](psi_element://java.util.stream.Collectors#toList).
Because of this, a convenient [toList()](psi_element://java.util.stream.Stream#toList) has been added directly to `Stream`.

Note that there is **no toSet()**.
It is not a goal to add a method for each collection type.
The collectors API is deliberately designed like it is, because it allows the addition of
collectors without having to change the Stream API.

`toList()` is not available on primitive streams (like [IntStream](psi_element://java.util.stream.IntStream)), which makes sense since
generics require objects (for now, at least).
However, you can use the operator [boxed()](psi_element://java.util.stream.IntStream#boxed) to box these first and then use `toList()`.