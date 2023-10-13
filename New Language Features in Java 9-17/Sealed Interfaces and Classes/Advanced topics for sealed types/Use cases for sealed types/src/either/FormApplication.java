package either;

public non-sealed class FormApplication extends Application {

  private FormType formType;

  private Address address;

  public enum FormType {
    A38, A42
  }
}
