## mapMulti()

The [mapMulti()](psi_element://java.util.stream.Stream#mapMulti) operator lets you imperatively replace stream elements with zero or more elements.

You could achieve the same already with [flatMap()](psi_element://java.util.stream.Stream#flatMap), but sometimes you may wish to use a more
imperative approach or skip the intermediate stream creation required for `flatMap()`.

`mapMulti()` takes a [BiConsumer](psi_element://java.util.function.BiConsumer) (a function that takes two arguments and returns nothing) as its argument, which will be invoked for every stream element with the following parameters:

* the current stream element
* a [Consumer](psi_element://java.util.function.Consumer) that can be invoked zero or more times to add the replacement items to the stream

The following example adds the favorite animal after each persons name to a stream (if they have one):

```java
return persons.stream().mapMulti((personName, consumer)  -> 
      consumer.accept(personName);
      var animal = favoriteAnimals.get(personName);
      if (animal != null) {
        consumer.accept(animal);
      }
    )
    .toList();
```

The same could be expressed with `flatMap()` as:

```java
return persons.stream().flatMap(personName -> {
       return Stream.concat(
              Stream.of(personName),
              Stream.ofNullable(favoriteAnimals.get(personName))
              );
    })
```

> Note the use of [Stream.ofNullable(T)](psi_element://java.util.stream.Stream#ofNullable) here, another addition in Java 9. It returns an empty stream if the argument is null.

## Exercise

Use `mapMulti()` to implement the `repeatByValue` method, which should repeat each number as many times as its value. Example:

```
Input: [1, 2, 0, 3];
Output: [1, 2, 2, 3, 3, 3];
```

The input will not contain negative numbers.