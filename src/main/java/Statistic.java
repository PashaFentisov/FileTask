public class Statistic {
    private String longestWord;
    private String shortestWord;
    private int lineLength;
    private double averageWordLength;

    public Statistic(String longestWord, String shortestWord, int lineLength, double averageWordLength) {
        this.longestWord = longestWord;
        this.shortestWord = shortestWord;
        this.lineLength = lineLength;
        this.averageWordLength = averageWordLength;
    }

    public Statistic() {
    }

    public String getLongestWord() {
        return longestWord;
    }

    public void setLongestWord(String longestWord) {
        this.longestWord = longestWord;
    }

    public String getShortestWord() {
        return shortestWord;
    }

    public void setShortestWord(String shortestWord) {
        this.shortestWord = shortestWord;
    }

    public int getLineLength() {
        return lineLength;
    }

    public void setLineLength(int lineLength) {
        this.lineLength = lineLength;
    }

    public double getAverageWordLength() {
        return averageWordLength;
    }

    public void setAverageWordLength(double averageWordLength) {
        this.averageWordLength = averageWordLength;
    }

    @Override
    public String toString() {
        return "Statistic{" +
                "longestWord='" + longestWord + '\'' +
                ", shortestWord='" + shortestWord + '\'' +
                ", lineLength=" + lineLength +
                ", averageWordLength=" + averageWordLength +
                '}';
    }
}
