## Use cases for sealed types

Sealed types can be used whenever it makes sense to communicate that a type can be only one of
several known types.

### Pattern matching

Sealed types only unlock their full potential with pattern matching.

[JEP 441](https://openjdk.org/jeps/441) will bring pattern matching for switch in its final form
to JDK 21, but you can already play around today with pattern matching in JDK 20 by providing the
`--enable-preview` flag (both to `javac` and `java`, or alternatively from IntelliJ IDEA's project
language level setting).

If enabled, when performing pattern matching over a sealed type, the compiler performs the same
exhaustiveness check as with enums.
This ensures you capture all cases and if you do, relieves you of adding a default branch:

```java
// with --enable-preview in JDK 20 or some earlier versions, or without in JDK 21
switch (planet) {
  case Earth earth -> ...;
  case Venus venus -> ...;
  case Saturn saturn -> ...;
}

```

### Either-or return scenarios

We showed in [When to use records](course://Records/Defining and using records/When to use records)
that you can use records when you need to return multiple return values ad-hoc.

But what if you want to indicate that it can be either one or the other value?
Sealed types are a natural application for this scenario.

The example code has a [Maybe](course://Sealed Interfaces and Classes/Advanced topics for sealed types/Use cases for sealed types/src/Maybe.java)
interface that mimics Haskell's `Maybe` type.
If Java 8 already had pattern matching and sealed types, we may have seen a different style of
programming for optional types:

```java
Maybe<Customer> maybeCustomer = findCustomer(id);

return switch (maybeCustomer) {
    case Just(Customer c) -> c;
    case Nothing<Customer> -> throw new NotFoundException("Customer with id " + id + " not found");
}
```

> Remember, you cannot use pattern matching like this in Java 17 without enabling preview features.

Often, you need to express that either one or another field are filled in a data type.
You can solve this by having one of them be null when the other is set, and document this requirement.
However, nothing prevents you from filling both fields (unless you wrote validation in the
constructor).

Sealed types are an alternative way to model this constraint.
Simply encapsulate the either-or fields in separate types, extending a base type (which can be an
empty interface).
The [Application](course://Sealed Interfaces and Classes/Advanced topics for sealed types/Use cases for sealed types/src/either/Application.java)
class in the example code demonstrates this.

### Polymorphic Data Transfer Objects (DTOs)

When deserializing polymorphic DTOs received over the network, the serialization library needs to
know which subtype the data belongs to.
The builtin Java serialization solves this by encoding the class name within the serialized data,
leading to security issues when deserializing untrusted input.
Other libraries like Jackson (for JSON) require you to specify how you want to encode the type
information in the data, and which child types exist.

A simple solution in Jackson is to also include the fully qualified class name, but you have to
explicitly "unlock" classes or packages you want to deserialize to as a security measure.
Alternatively, you can specify the type mapping using the `@JsonSubtypes` annotation.

In the following example, we want to give each subclass a logical type name, which is specified in
the implementation class:

```java
@JsonTypeInfo(use = Id.NAME, include = As.PROPERTY, property = "type") // encode type info as a property "type"
@JsonSubTypes({Dog.class, Cat.class}) // which implementations exist
class Animal {}
```

We need to tell Jackson the implementations to look out for with `@JsaonSubTypes`.
But this is exactly the kind of "parent knows descendants" situation sealed types were made for!

So in a future version of Jackson, we might be able to just list the subclasses with a `permits`
clause.

You can see an example for polymorphic DTOs with the [Message](course://Sealed Interfaces and Classes/Advanced topics for sealed types/Use cases for sealed types/src/messaging/Message.java)
class.

### Don't replace all OOP with sealed types and instanceof

Like records are transparent carriers, sealed types are _transparent parents_.
As they list their descendants, one main usage is to perform explicit `instanceof` checks on them.
It makes sense to use `instanceof` on sealed types when the business logic or main behavior of a class lives
_outside_ of it: data transfer objects and ad-hoc return types are natural candidates.

On the other hand, classic object-oriented inheritance builds upon encapsulating the specialized
behavior of child classes _inside_ them.
When you put the logic for these outside, you lose the ability to add new types and behavior without
touching all places.

For example, let's say you're displaying data in a table, and you need different column types like
a date formatted column, an input field, etc.
Modeling this with sealed types (or enums) and an `instanceof` check puts all the rendering logic
into one place:

```java
return switch (columnType) {
  DATE -> formatDate(value);
  INPUT -> createInputField(value);
  ...
}
```

If you have several of these tests across your codebase, you would have to adjust each of them to
cover a new column type.

Instead, it should be the _column's_ job to know how to render it:

```java
class DateColumn implements Column {
  @Override
  public void render(Object value) {
    ...
  }
}
```