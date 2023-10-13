public class Task {
  private static final String BRONZE_WINNING_SENTENCE = "Good job!";
  private static final String SILVER_WINNING_SENTENCE = "Well done!";
  private static final String GOLD_WINNING_SENTENCE = "Excellent work!";
  private static final String PLATINUM_WINNING_SENTENCE = "Perfect solution!";

  public String getAchievementCongratulations(Achievement achievement) {
    return "You've achieved "
        + achievement.toString()
        + "! "
        + getWinningSentence(achievement);
  }

  private String getWinningSentence(Achievement achievement) {
    return switch (achievement) {
      case BRONZE -> BRONZE_WINNING_SENTENCE;
      case SILVER -> SILVER_WINNING_SENTENCE;
      case GOLD -> GOLD_WINNING_SENTENCE;
      /* TODO */
    };
  }
}