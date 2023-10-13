## dropWhile() and takeWhile()

* [dropWhile(Predicate)](psi_element://java.util.stream.Stream#dropWhile) skips elements as long as the condition is true, then emits all remaining elements.

```java
Stream.of(2, 3, -4, -5, 6).dropWhile(i -> i > 0).toList(); // [-4, -5, 6]
```

* [takeWhile(Predicate)](psi_element://java.util.stream.Stream#takeWhile) lets elements through as long the condition is true, then skips the remaining elements. 

```java
Stream.of(2, 3, -4, -5, 6).takeWhile(i -> i > 0).toList(); // [2, 3]
```

## Exercise

Add stream operations to the code such that only the words between a "START" and "END" marker are returned.

Each marker appears exactly once in the whole list, and in the correct order.

**Example:**

```
Input: ["hello", "START", "world", "!", "END", "how", "are", "you", "?"];
Output: ["world", "!"];
```

<div class="hint">
  When <code>dropWhile</code> evaluates to false for the first time, the element at that position will be let through.
</div>

<div class="hint">
  You can skip a number of elements with the <a href="psi_element://java.util.stream.Stream#skip">skip()</a> operator.
</div>
