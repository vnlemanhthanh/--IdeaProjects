package either;

public sealed abstract class Application permits OnlineApplication, FormApplication {

  private String applicantName;
}
