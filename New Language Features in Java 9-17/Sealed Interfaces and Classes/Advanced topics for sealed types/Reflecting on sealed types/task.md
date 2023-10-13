## Reflecting on sealed types

When using reflection, you can check if a `Class` is sealed with the [isSealed()](psi_element://java.lang.Class#isSealed) method.

You can get the permitted subclasses with [getPermittedSubclasses()](psi_element://java.lang.Class#getPermittedSubclasses).

## Exercise: Exhaustive polymorphic bean mapping

It is common practice to keep Data Transfer Objects (DTOs) that are part of a public API separate
from objects in the business layer of an enterprise application.
This way, you can change the API shape or support multiple API versions (v1, v2...) without having
to adjust or duplicate logic in the business layer.
For the multi-version scenario, the objects in the business layer then capture both versions of an
API in a single object.
Only the data objects are being duplicated.
For example, you could have a `v1.ProductDto`, `v2.ProductDto`, and `core.ProductBo`, with "Bo"
representing a "business object" from the business layer.

It would be error-prone and cumbersome to write the code needed to map from one object to the other
by hand.
That's why _bean mappers_ like MapStruct or Orika are used.
You can then use code like this to map from one object to the other:

```java
mapper.map(dog, DogDto.class);
```

However, when you map a polymorphic type A to a polymorphic type B, the mapping library has no way
of knowing which subtype of A should map to which target subtype of B.
You need to register this mapping explicitly.

When you forget to register a polymorphic mapping, the library can only notice this at runtime the
moment it actually encounters an unknown source subtype, since it cannot know which subclasses exist.

With sealed types, this could be checked already when registering the polymorphic mappings.
MapStruct, which is an annotation processor, even does it at [compile time](https://github.com/mapstruct/mapstruct/issues/3054).

### Task

We've prepared a simple `PolymorphicMapper` class for registering type mappings that can be used
like this:

```java
var mapper = PolymorphicMapper.builder(Animal.class)
        .fromTo(DogDto.class, DogBo.class)
        .fromTo(CatDto.class, CatBo.class)
        .build();
```

Implement the `verifyAllSubclassesCovered()` check in `PolymorphicMapper`: If the base class is
sealed, check that all permitted subclasses appear in the key set of the `sourceToTargetMapping` Map.
If not, throw a `MissingPolymorphicMappingException` (which we prepared for you), providing the set
of classes that need to be registered.

If all permitted subclasses are covered, do nothing.

If the base class is _not_ sealed, return immediately from `verifyAllSubclassesCovered()`.

Also, do not care about whether the _target_ classes are sealed or not (bean mapping functions are
not necessarily [isomorphisms](https://en.wikipedia.org/wiki/Isomorphism)).