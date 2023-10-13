## The `permits` clause

The direct subtypes of a sealed interface or class are called the _permitted_ types.

Permitted types don't need to be declared in the same source file.
The file would get pretty crowded once we start adding behavior.

Instead, we can place permitted subclasses _in the same package_ as the sealed type.
When we do that, we have to list the permitted subclasses explicitly with the `permits` keyword:

```java
sealed class Planet permits Earth, Mars, Jupiter, Venus, Saturn {...}
```

We have updated the example code to make use of the `permits` clause.
We also converted `Vertebrate` and `Fish` to interfaces since they don't have fields or methods
other classes should inherit from, and also should not be instantiated.