# Records

Records were added in their final form with [JEP 395](https://openjdk.org/jeps/395).
Simply put, they are a concise way of defining immutable data classes.

Their simplicity makes it easier than ever to introduce more strong types to your codebase,
replacing weak field declarations like `String productCode` or `int positiveInteger` with types
that check their invariants on construction.

## Defining a record

The code you see for the `Point` record is all you need to define it.
With that, you get accessor methods, a constructor, `equals`, `hashCode`, and `toString` for free.

## The header

The part after the record's name is called the _header_.
It lists the fields (or rather _components_ in record nomenclature) that make up the record.
These components will turn into private final fields.

## Limitations

Records are regular classes in the sense that they ultimately extend `Object`.
You can construct them with new, assign them to variables, perform `instanceof`, etc.

However, they have some restrictions:

* Records implicitly extend [java.lang.Record](psi_element://java.lang.Record). You cannot specify any superclass. However, you
  are free to have a record implement one or more interfaces.
* They are implicitly final, i.e. you cannot extend a record.
* All fields defined by the record are `final`.
* You cannot specify fields (not even those in the header).
* The constructor must have the same as or less restrictive visibility (access modifier) than the record itself. 
* If you override one of the automatically defined methods, the signature must match exactly.
* They cannot have _native_ methods (if you never heard of them, you probably don't need them).
