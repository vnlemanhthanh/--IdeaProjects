import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Task {

  public Map<String, Integer> countAnimals(InputStream inputStream) throws IOException {
    Map<String, Integer> animalCountByType = new HashMap<>();

    try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {

      String line;

      while ((line = reader.readLine()) != null) {
        String animal = line.toLowerCase();
        animalCountByType.merge(animal, 1, Integer::sum);
      }
    }

    return animalCountByType;
  }
}