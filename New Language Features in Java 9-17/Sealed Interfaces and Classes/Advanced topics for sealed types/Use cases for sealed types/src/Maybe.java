public sealed interface Maybe<T> {
  record Nothing<T>() implements Maybe<T> {}
  record Just<T>(T value) implements Maybe<T> {}
}
