import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class Main {

  public static void main(String[] args) {

    var animalList = List.of("cow", "elephant", "elephant");

    var emptyList = List.of();

    var animalSet = Set.of("cow", "elephant" /*, "elephant"*/);

    var animalMap = Map.of(
        "cow", 3,
        "elephant", 4
    );

    var animalMapFromEntries = Map.ofEntries(
        Map.entry("duck", 9),
        Map.entry("elephant", 4)
    );

    var someMutableList = new ArrayList<String>();
    someMutableList.add("hello");
    var copyOfSomeMutableList = List.copyOf(someMutableList);
    someMutableList.add("world");

    print("animalList", animalList);
    print("emptyList", emptyList);
    print("animalSet", animalSet);
    print("animalMap", animalMap);
    print("animalMapFromEntries", animalMapFromEntries);
    print("someMutableList", someMutableList);
    print("copyOfSomeMutableList", copyOfSomeMutableList);
  }

  private static void print(String name, Object objectToPrint) {
    System.out.print(name + ": ");
    System.out.println(objectToPrint);
  }
}