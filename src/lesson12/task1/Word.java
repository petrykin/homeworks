package lesson12.task1;

public class Word {
    private String word;
    private int uniqueCharsNumber;

    public Word(String word) {
        this.word = word;
        uniqueCharsNumber = uniqueCharsCount(word);
    }

    private int uniqueCharsCount(String word) {
        int count = word.length();
        String lowerCaseWord = word.toLowerCase();
        for (int i = 0; i < word.length() - 1; i++) {
            for (int j = i + 1; j < word.length(); j++) {
                if (lowerCaseWord.charAt(i) == lowerCaseWord.charAt(j)) {
                    count--;
                    break;
                }
            }
        }
        return count;
    }

    public String getWord() {
        return word;
    }

    public int getUniqueCharsNumber() {
        return uniqueCharsNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Word)) return false;

        Word word1 = (Word) o;

        if (uniqueCharsNumber != word1.uniqueCharsNumber) return false;
        return word.equals(word1.word);
    }

    @Override
    public int hashCode() {
        int result = word.hashCode();
        result = 31 * result + uniqueCharsNumber;
        return result;
    }

    @Override
    public String toString() {
        return "Word{" +
                "word = '" + word + '\'' +
                ", uniqueSymbolsNumber = " + uniqueCharsNumber +
                '}';
    }
}
