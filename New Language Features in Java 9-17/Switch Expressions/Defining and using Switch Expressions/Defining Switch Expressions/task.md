## Defining a switch expression

A switch expression looks similar to a switch statement, but uses arrows `->` instead of colons `:`
between case and "effect", and returns a value from the matching case.

In a switch *statement*, cases are followed by statements:

```java
case "August":
  return "Summer";
  break;
```

Whereas in a switch *expression*, the right hand side is an expression as well:

```java
case "August" -> "Summer";
```

Multiple tests that should return the same value can be combined by placing a comma between the
tests.

So instead of:

```java
case "July" -> "Summer";
case "August" -> "Summer";
```

You can write:

```java
case "July", "August" -> "Summer";
```

**There is no fall through in switch expressions.**
As with a switch statement, the first matching case is selected, but only the block following
that case is executed.<sup>1</sup>
After that, execution leaves the switch.

### Usage as an expression

You can use switch expressions everywhere you can use an expression:

```java
return switch(month) {
  case "July", "August" -> "Summer";
  case "December" -> "Winter";
  
  default -> throw new UnsupportedOperationException("Not yet implemented");
}
```

When we say everywhere, we literally mean everywhere.
This includes method arguments or even the right-hand side of another switch expression's case.

However, for the sake of readability, you should use switch expressions for assignments and return
statements only.

### Throwing exceptions from case blocks

The right-hand side of a switch expression must be an expression itself, except for the special
case of throwing an exception.
This allows to fail fast from unexpected input without having to cover that in a default case:

```java
case OCTOBER -> throw new UnexpectedMonthException(month);
```

### Using arrow labels in switch statements

You can use the new arrow syntax instead of classic colon syntax in switch statements as well.
Sometimes, this is called the "enhanced switch statement".
You should always prefer this syntax over the "legacy" one, since then you don't have to worry
about fall through semantics.

## Exercise

Use a switch expression to write a primality test for input from the range 1 to 10 only (both inclusive)
by listing the matching numbers explicitly.
Return true if a given number is prime, false otherwise.
If the input is less than 1 or greater than 10, throw an IllegalArgumentException.

----
<sup>1</sup> Note that at the moment, the _first_ matching case is also the _only_ possible
case.
Case labels can't repeat in a switch, so you have to test mutually exclusive numbers / enum values / Strings.
With the addition of [pattern matching for switch](https://openjdk.org/jeps/441), _multiple_ cases
could match, so it is better to get used to the notion of "first match" now.