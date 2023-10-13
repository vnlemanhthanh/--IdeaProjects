import java.util.Collections;
import java.util.Set;

public class MissingPolymorphicMappingException extends RuntimeException {

  private final Class<?> baseClass;

  private final Set<Class<?>> missingClasses;

  public MissingPolymorphicMappingException(Class<?> baseClass, Set<Class<?>> missingClasses) {
    this.baseClass = baseClass;
    this.missingClasses = Collections.unmodifiableSet(missingClasses);
  }

  public Set<Class<?>> getMissingClasses() {
    return missingClasses;
  }

  @Override
  public String getMessage() {
    return "Not all permitted subclasses of " + baseClass + " have been covered. Missing classes: " + missingClasses;
  }
}
