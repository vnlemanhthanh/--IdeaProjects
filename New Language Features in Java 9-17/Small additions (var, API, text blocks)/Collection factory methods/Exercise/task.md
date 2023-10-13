## Exercise: replace by convenience collection factory methods

The `Task` class has many opportunities to replace "old" style instantiations of collections by the new factory methods.

Your IDE will help you in all these refactorings.
Place your cursor at the appropriate locations and press **&shortcut:ShowIntentionActions;** to open the quick fix menu.
Then, select the suggested change to a collection factory method.

Your final solution should no longer require these imports:

```java
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
```

The program should work unchanged.