import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Task {
  private static final Map<String, String> ANIMAL_DESCRIPTIONS;

  static {
    Map<String, String> animalDescriptions = new HashMap<>();

    animalDescriptions.put("cow", "A cow has hoofs");
    animalDescriptions.put("alligator", "Alligators live in the swamp");
    animalDescriptions.put("cat", "Cats meow");
    animalDescriptions.put("sheep", "A sheep is wooly");

    ANIMAL_DESCRIPTIONS = Collections.unmodifiableMap(animalDescriptions);
  }

  private static final Set<String> FARM_ANIMALS = Collections.unmodifiableSet(new HashSet<>(Arrays.asList("cow", "sheep")));

  public boolean isFarmAnimal(String animal) {
    return FARM_ANIMALS.contains(animal);
  }

  public List<String> getDescriptions(List<String> animals) {
    if (animals == null) {
      return Collections.emptyList();
    }

    return animals.stream().map(ANIMAL_DESCRIPTIONS::get).toList();
  }

  public List<String> getAlligatorAsList() {
    return Collections.singletonList("alligator");
  }
}