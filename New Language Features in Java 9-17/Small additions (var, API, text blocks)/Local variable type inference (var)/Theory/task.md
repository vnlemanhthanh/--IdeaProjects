# Local variable type inference

Local variable type inference, introduced with [JEP 286](https://openjdk.org/jeps/286), allows you to omit the type declaration of **local variable declarations**.
Instead of the type, you use the `var` keyword.

For example, instead of writing `Book book = new Book()`, you can write `var book = new Book()`.

The type of the variable will be inferred to be the specific type of the right hand side expression of the declaration.
Using `var` makes your code more concise.

See the `BookStore` class for more examples and use your IDE to show the actual type by hovering over
the variable names.