# Text blocks

Text blocks were added in their finalized version to Java 15
in [JEP 378](https://openjdk.org/jeps/378).
They allow you to write multi-line Strings without having to resort to String concatenation.

Text blocks are enclosed by triple quotes `"""` and always span multiple lines.
Inside text blocks, you do not have to escape double quotes.

Using an intricate indentation algorithm, indentation will be stripped based on the first line's
indentation of the block.
This means you can keep your source code indentations intact without having to worry about them
carrying over to your Strings as well.

Space at the end is also stripped.
You can see that at work in the example.

Although it would be convenient in some places, it is not permitted to have single-line
text blocks.
Also, escaping still works the same.
There are no "raw strings" in Java:

```java
// does not compile
String rawString = """[0-9a-zA-Z\t\r\n]""";
```

_Run this and the following examples to see text blocks in action and the whitespace made visible._