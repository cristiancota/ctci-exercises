package leetCode;

public class GoatLatin {
    public String toGoatLatin(String S) {
        StringBuilder result = new StringBuilder();
        String[] words = S.split(" ");
        for (int i = 0, wordsLength = words.length; i < wordsLength; i++) {
            StringBuilder word = new StringBuilder(words[i]);
            char firstLetter = word.charAt(0);
            if (!isVowel(firstLetter)) {
                word = new StringBuilder(word.substring(1) + firstLetter);
            }
            word.append("ma");
            for (int j = 0; j < i + 1; j++) {
                word.append("a");
            }
            result.append(word);
            result.append(" ");
        }
        return result.toString().substring(0, result.length() - 1);
    }

    boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
                c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}
