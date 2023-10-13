import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PolymorphicMapper<BASE> {

  private final Map<Class<? extends BASE>, Class<?>> sourceToTargetMapping;

  private PolymorphicMapper(Map<Class<? extends BASE>, Class<?>> sourceToTargetMapping) {
    this.sourceToTargetMapping = sourceToTargetMapping;
  }

  public static <BASE> Builder<BASE> builder(Class<BASE> baseClass) {
    return new Builder<>(baseClass);
  }

  public Class<?> getMapping(Class<? extends BASE> clazz) {
    return sourceToTargetMapping.get(clazz);
  }

  public static class Builder<BASE> {

    private final Class<BASE> baseClass;

    private final Map<Class<? extends BASE>, Class<?>> sourceToTargetMapping = new HashMap<>();

    private Builder(Class<BASE> baseClass) {
      this.baseClass = baseClass;
    }

    public Builder<BASE> fromTo(Class<? extends BASE> from, Class<?> to) {
      sourceToTargetMapping.put(from, to);
      return this;
    }

    public PolymorphicMapper<BASE> build() {
      verifyAllSubclassesCovered();
      return new PolymorphicMapper<>(sourceToTargetMapping);
    }

    private void verifyAllSubclassesCovered() {
/* implement permitted subclass check */
    }
  }
}
