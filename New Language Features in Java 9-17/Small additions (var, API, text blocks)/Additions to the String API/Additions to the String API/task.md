# Additions to String

Several methods have been added to the String API since Java 8.
Here are the most useful ones:

## strip()

[strip()](psi_element://java.lang.String#strip) removes whitespace from the beginning and end of a String.

...huh, doesn't [trim()](psi_element://java.lang.String#trim) already do that?
Yes, but `trim()` is not Unicode aware.
There are [a lot of Unicode characters](https://en.wikipedia.org/wiki/Whitespace_character#Unicode)
denoting white space, like a thin space used in this example.
`strip()` properly removes that.

Additionally, you can use [stripLeading()](psi_element://java.lang.String#stripLeading) and [stripTrailing()](psi_element://java.lang.String#stripTrailing) to remove the leading and trailing
white space of a String, respectively.

`stripIndent()` applies the same logic to a String as Java does to a text block.

## formatted()

Did you also find it strange that [String.format()](psi_element://java.lang.String#format) is a static method taking the format string and
the arguments?

Well, rejoice, as [formatted()](psi_element://java.lang.String#formatted) was added in Java 15 as an instance method to be directly invoked on a format
string: `"Test: %d".formatted(42)`.

## repeat()

Very useful in tests, [repeat()](psi_element://java.lang.String#repeat) (added in Java 11) repeats a String exactly n times.

## isBlank()

Another very useful method, [isBlank()](psi_element://java.lang.String#isBlank), does exactly what it says on the tin: it returns true if a
String contains only white space characters (and takes Unicode into account).

## lines()

The [lines()](psi_element://java.lang.String#lines) method streams the lines of a String.

## chars()

[chars()](psi_element://java.lang.String#chars) streams the characters of a String.
