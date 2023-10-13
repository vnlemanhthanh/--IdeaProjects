# Pattern Matching for instanceof

[JEP 394: Pattern Matching for instanceof](https://openjdk.org/jeps/394), which was delivered in its
final form in Java 16, adds the ability for pattern matching to the `instanceof` operator.

Cool, but what does that mean?

[_Pattern matching_](https://en.wikipedia.org/wiki/Pattern_matching) is a concept used in many (predominantly
functional) programming languages, for example Haskell or Scala.
The idea is to match a sequence or construct of _something_ against a _pattern_.
If the pattern matches, individual parts of that pattern can be bound to variables.

Even if you haven't worked with a language that uses pattern matching before, you probably used
regular expressions.
These are also pattern matchers.
Regular expressions allow you to get the whole matching sequence, but also individual groups if you
specified them in the pattern.

A very simple version of pattern matching was introduced in Java 16 for the `instanceof` operator.
It allows to match against a nominal type and then bind the narrowed type to a variable.

Instead of the following code:

```java
if (task instanceof BatchTask) {
    BatchTask batchTask = (BatchTask)task;
    return batchTask.getSubtasks();
}
```

you can now write the more concise

```java
if (task instanceof BatchTask batchTask) {
    return batchTask.getSubtasks();
}
```

that is, you can bind the matching pattern to a variable.

## Scope

The pattern variable is only accessible in the scope enclosed by the if condition.
Additionally, it is accessible on the right-hand-side of an "and":

```java
if (task instanceof BatchTask batchTask && batchTask.isMultiTask()) {
    ...
}
```

## Future features of Pattern Matching

That's nice and all, but isn't calling that "Pattern Matching" a bit exaggerating?
After all, it is just a fancy `instanceof`.

However, this was only the first step on a long journey to many useful pattern matching features in
Java.

Two of these features are currently in preview and will presumably be finalized in Java 21:

* [JEP 441: Pattern Matching for switch](https://openjdk.org/jeps/441) adds pattern matching
  capabilities to switch statements and expressions. A great benefit is that they will check
  for _exhaustiveness:_ if you forget to cover a case, the compilation will fail. This plays
  nicely with _sealed types_ (which we will get to know later), since they define how many cases
  are to be covered. If you ever had to `instanceof` over a lot of types and forgot adding new
  cases, this is the feature for you.

```java
sealed interface Planet permits Earth, Mars, Jupiter {}
//...
switch (planet) {
  case Mars m -> ...;
  case Earth e when e.circumference() > 100 -> ...;
  case Jupiter j -> ...;
} // exhaustive, all cases covered.

```

* [JEP 440: Record Patterns](https://openjdk.org/jeps/440) implements the extraction of record
  components, even nested:

```java
if (area instanceof Zoo(Keeper(firstName, lastName), var animalList)) {
    System.out.println("The zookeeper is " + firstName + " " + lastName);
}
```

There are many more features planned. Read [Deconstruction Patterns for Records and Classes](https://github.com/openjdk/amber-docs/blob/master/eg-drafts/deconstruction-patterns-records-and-classes.md)
and [Functional Transformation of Immutable Objects](https://github.com/openjdk/amber-docs/blob/master/eg-drafts/reconstruction-records-and-classes.md)
by Java language designer Brian Goetz to learn more about the direction pattern matching in Java is heading.