# Preface

Welcome to _New Language Features in Java 9-17!_

This course shows you features introduced in versions 9 to 17 to the Java programming language.
You can learn about and experiment with them side-by-side directly in the IDE.

Topics covered:

- the var keyword
- useful new API methods on Strings and streams, and the new collection factory methods
- text blocks
- pattern matching with instanceof
- records
- switch expressions
- sealed interfaces and classes

There will be small exercises, but the main focus is on giving you theoretical knowledge accompanied
by examples.

## How to navigate this course

Keep the Task window open at all times and resize it to see more of its contents on large screens.

Use the _Next_ button to proceed to the next lesson.

You can use _Run_ in theory lessons to see the code in action.
Not all theory lessons contain executable code (for example, the one you are reading doesn't).
Look out for those that contain a Main method.

For interactive tasks, click the _Check_ button to run the tests and get feedback whether your
solution was correct.

When you see a Class or method name styled as a link, clicking on it will let the IDE open the
corresponding source file of the JDK.
For example: [List.of()](psi_element://java.util.List#of)

## Prerequisites

This course assumes **you know Java 8** well enough to catch the nuances and differences of the
features introduced.
Even if you already worked with a recent version of Java for a while, you may find some of the material interesting.

Obviously, you need JDK 17 or higher installed for the examples to work, and an up-to-date version
of IntelliJ IDEA to benefit from syntax highlighting.
You can download JDKs from many vendors directly from inside IntelliJ IDEA: https://www.jetbrains.com/help/idea/sdk.html#jdk-from-ide

Do not pick the JetBrains Runtime JRE, it is not suitable for development and also has no JavaDoc.

If you want to change the JDK for the course, right click on the course's name, select
"Open Module Settings", go to the _Project_ section, and select a different JDK.

## This is not a complete overview

I skip some features which are not part of your everyday coding (like the included HTTP Server or
the Stack Walking API), or otherwise out of scope for an interactive experience (like garbage
collector enhancements).

I will also not discuss JDK licensing questions.
There are many vendors you can pick from that provide free OpenJDK builds.
You can find out more about them on https://whichjdk.com/

## A word on the Java Platform Module System (JPMS)

The Java module system (JPMS) was a big change introduced with Java 9.
The entire JDK has been modularized, which broke some libraries that accessed internal JDK APIs
despite warnings (like the name `sun.misc.Unsafe` implies, for example).
Combined with (at that time) basically no comprehensive documentation how to use the module system
except for some blog posts, JPMS quickly got a bad wrap.
It also didn't help that build systems like Maven or Gradle, and even your favorite IDEs were not
integrating well with modules.

The final nail in the coffin was the fact that while you can modularize your application top down,
you may get problems when accessing non-modular Jars, since they may try to access split packages,
something that is forbidden by the module system.

This led to only a handful of projects actually using the module system.
Since it is entirely opt-in, you can continue to ignore it (sans the necessity to import some JDK
modules via the command line).

But like there are good reasons not to put all your code into the unnamed package, there are also
good reasons to use the module system.
However, as the module system is such a complex topic, I plan to address it in a separate course.

## Preview features

This course will **not** cover features that were previewed or did not even exist in version 17 of
the JDK (like record pattern matching or virtual threads).

While preview features are safe to use (they are not full of bugs like a video game Beta), the API
may change, which makes them unsuitable for a course.

I hope to be able to update this course with the release of JDK 21, the next LTS version, which
should come out in September 2023, or release a separate course just for going from 17 to 21.
Let me know what you'd prefer.

## Those pesky bugs

Due to how slow enterprise software is upgraded, I have not yet come in contact with Java features newer
than version 8 at work, so I cannot give guidelines from first-hand experience.
This course is partially also me trying to explore these features after having learned about them
through JEPs, experimentation, talks, and other resources.

Naturally, this can lead to errors in the course material.
I can also hardly conceal the fact that I'm not a native speaker.

If you find errors or grammatical/semantic oddities, please feel free to open a pull request on
Github.
Thank you!

## Where can I learn more?

People still link to the Oracle Java 8 tutorial today when referring others to learn about Java, but
that's no longer updated.
Luckily, Oracle has created a new platform and learning website with up-to-date content
at: https://dev.java/learn/

To find out what each release contains, check out the release notes, for example for Java
17: https://www.oracle.com/java/technologies/javase/17-relnote-issues.html

Big Java features are described by "JDK Enhancement Proposals" (JEPs).
You can think of them like "request for comments" (RFC) documents.
They don't contain the detailed specification of features, but give enough explanation and rules to
understand them in-depth.
If you're interested in the future of Java, I highly recommend checking them out!

You can find a list of all JEPs (both implemented and proposed) at: https://openjdk.org/jeps/0