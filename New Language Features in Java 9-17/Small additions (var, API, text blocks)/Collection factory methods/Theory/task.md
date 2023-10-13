# Collection factory methods

Java 9 saw the addition of convenient factory methods for collections.
They are invoked directly from the interface.
These are:

```java
List.of(...);
Set.of(...);
Map.of(...);
```

They should be used whenever you work with compile-time constant expressions, like a list of items
in a test.

The collections created by these factory methods are immutable, i.e., you cannot add or remove
elements.
As an additional benefit, the various overloads are optimized.
That means, if you return a list with exactly two arguments, the list will not use a backing array
like `Arrays.asList()`, but really just use two fields for the two elements!

If you want to see it for yourself, check out the [ImmutableCollections](psi_element://java.util.ImmutableCollections) class in the JDK.
It even optimizes to the empty List with `List.of()`! Gone are the days when you had to
use different APIs (`Arrays.asList()`, `Collections.emptyList()`, `Collections.singletonList()`)
in your code to achieve the same goal.

Note that you cannot use `ImmutableCollections` yourself (as it is package private), only through the factory methods.

## List.of(...)

[List.of(...)](psi_element://java.util.List#of) creates an immutable list of its arguments.

## Set.of(...)

[Set.of(...)](psi_element://java.util.Set#of) creates an immutable Set of its arguments.

It is a runtime error if you specify the same element twice.
Use a regular `HashSet` if you don't know whether duplicates exist.

## Map.of(...)

You can create a new Map with [Map.of(...)](psi_element://java.util.Map#of) by specifying alternating key-value pairs,
e.g. `Map.of(key1, value1, key2, value2)`.

Since it may be difficult to see which value belongs to which key, you can use the
alternate [Map.ofEntries(...)](psi_element://java.util.Map#ofEntries), which takes [Map.entry(...)](psi_element://java.util.Map#entry) elements.

## List.copyOf(...)

[List.copyOf(...)](psi_element://java.util.List#copyOf) creates an immutable copy of a list.
Note that this is more than just wrapping it with `Collections.unmodifiableList()`: it also copies
the elements.
A simple unmodifiable list still sees any changes made to the underlying list.
That's why it's a good practice to make copies of incoming list arguments (at least if you don't
trust the code calling you).
`List.copyOf(...)` makes this pattern very easy.