## When to use records?

The JEP defines records as **transparent carriers for immutable data**:

* _transparent:_ You cannot make the constructor of a record less visible than the record itself,
  and the header of a record tells you exactly how it looks like. There are no hidden fields
  or state to take care of.
* _carrier:_ Records are meant as something you pass around, instead of something that has behavior.
* _immutable:_ Once constructed, you cannot change the state of a record, at least as long as you
  do not employ tricks like putting mutable objects into the components.
* _data:_ Traversing the record tree should only lead to simple types. A record should not hold
  or represent objects like a file, database connection, or thread.

From this, a number of applications open up for records.

### Records vs. Beans

You are probably familiar with _Plain Old Java Objects (POJOs)_, simple data carriers to get
data from A to B in a structured way (that is better than a `Map<String, String>`).
Often, POJOs employ the _JavaBeans_ style, having mutable state that can be accessed and modified
through `getX()` and `setX()` methods (begging the question of why its fields have been made private
to begin with).

The mutability of JavaBeans is sometimes exploited in complex business processes in a way
that makes it difficult to follow the program's logic.
While Java doesn't have pass-by-reference<sup>1</sup> or `in` parameters like C#, mutating state in
input arguments comes close to that.
It is convenient to structure a program as a series of state mutations.
However, excessive use of this style leads to difficult-to-debug code, especially if mutable
objects leave the boundaries of the class that created them.

Making the majority of your data carriers immutable helps to shape code that is simpler to
reason about.
Records simplify the creation of these immutable carriers.

### As Data Transfer Objects (DTOs)

Records are natural candidates for data transfer objects (DTOs) or database projections.
Having all instantiation go through the constructor is safer than letting the serialization
framework reflect on private fields.
And because the names of record components can be observed via reflection, you do not need the
`-parameters` compiler option to make constructor deserialization work in libraries like Jackson.

Even for built-in Java serialization, Records are a safer choice.
Unlike with regular classes, deserialization for records will _always_ go through the canonical constructor.
(All the other caveats about serialization remain; you should not deserialize untrusted input.)

### As multiple value return types

Sometimes you need to return more than one value.
Since Java doesn't have tuples, people often use types like `Pair` or `Triple` from Apache Commons:

```java
Pair<String, String> findLongestAndShortestPalindrome(List<String> words);
```

The problem with anonymous tuple types is their lack of names.
You need to consult the method's documentation to know which element is what.

In the past, developers shunned away from creating new classes for these returns, as they did not
want to deal with all the boilerplate involved.
With records however, it is easier than ever before to create an ad-hoc type just for a single
return wherever you like, even in interfaces.

### As intermediate objects

Sometimes, you need a class only for a single method.
You could already declare local classes, but these can make the method hard to read.
Records are perfect to store intermediate results in a structured way:

```java
Map<String, List<House>> findTopNPriciestHousesPerCity(int n) {

    record CityPrice(String city, int price) {}
      
    getHouses().stream()
        .map(house -> new CityPrice(house.getCity(), house.getPrice()))
        .distinct()
        .sorted(Comparator.comparing(CityPrice::price).reversed())
        .collect(Collectors.groupingBy(CityPrice::city,
        Collectors.collectingAndThen(
        Collectors.toList(),
        prices -> prices.stream()
        .limit(n)
        .collect(Collectors.toList())
        );
        
}
```

### Immutable all the way

As we saw in
the [Overriding implicit methods](course://Records/Defining and using records/Overriding implicit methods)
lesson, you should be careful of what you put inside a record.
If you put mutable objects into a record, it becomes only shallowly immutable.
Invocations of `hashCode()` and `equals()` may return different results at different points in
time, and it is not safe to use such a record as the key of a Map or as a member of a Set.

Hence, the best practice is to declare only components which you know of are immutable (like
primitives, Strings, `LocalDate`, other records), or make an immutable copy in the canonical
constructor.

### Example code

Explore the example code if you like or move on to the next lesson.

----

<sup>1</sup> Java is pass-by-value _only_.
When you pass a reference to a method, the _reference_ gets copied.
If that wasn't the case then you could change the contents of variables defined outside a method's body.