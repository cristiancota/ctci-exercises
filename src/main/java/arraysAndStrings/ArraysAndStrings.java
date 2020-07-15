package arraysAndStrings;

import java.util.Arrays;
import java.util.HashSet;

class ArraysAndStrings {

    boolean isUnique(String s) {
        HashSet<String> hashSet = new HashSet<>();

        for (String str : s.split(""))
            if (!hashSet.add(str)) return false;

        return true;
    }

    boolean arePermutation(String a, String b) {
        int xor = 0;

        for (char c : a.toCharArray()) xor ^= c;
        for (char c : b.toCharArray()) xor ^= c;

        return xor == 0;
    }

    String urlify(String str, int trueLength) {
        StringBuilder stringBuilder = new StringBuilder();
        char[] chars = str.toCharArray();

        for (int i = 0; i < trueLength; i++)
            stringBuilder.append(chars[i] == ' ' ? "%20" : chars[i]);

        return stringBuilder.toString();
    }


    boolean isPalindromePermutation(String word) {
        char[] chars = word.replace(" ", "").toLowerCase().toCharArray();
        Arrays.sort(chars);

        for (int i = 0; i < chars.length - 1; i += 2)
            if (chars[i] != chars[i + 1]) {
                if (chars.length % 2 != 0) i--;
                else return false;
            }

        return true;
    }

    boolean isOneAway(String s1, String s2) {

        int diffs = 0;

        if (s1.length() == s2.length()) {
            for (int i = 0; i < s1.length(); i++) {
                if (s1.charAt(i) != s2.charAt(i)) {
                    diffs++;
                    if (diffs > 1) {
                        return false;
                    }
                }
            }
        } else {
            String longest = s1.length() > s2.length() ? s1 : s2;
            String shortest = s1.length() < s2.length() ? s1 : s2;

            if (longest.length() - shortest.length() > 1) {
                return false;
            }

            int i = 0;
            int j = 0;

            while (diffs <= 1 && i < longest.length() && j < longest.length()) {
                if (i == longest.length() - 1 && i == j) {
                    return true;
                }

                if (longest.charAt(i) != shortest.charAt(j)) {
                    if (longest.charAt(i + 1) == shortest.charAt(j)) {
                        i++;
                        diffs++;
                    } else if (longest.charAt(i) == shortest.charAt(j + 1)) {
                        j++;
                        diffs++;
                    } else {
                        return false;
                    }
                } else {
                    i++;
                    j++;
                }
            }
        }

        return true;
    }

    String stringCompression(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        int counter = 1;

        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                counter++;
            } else {
                stringBuilder.append(str.charAt(i)).append(counter);
                counter = 1;
            }
        }

        stringBuilder.append(str.charAt(str.length() - 1)).append(counter);

        return stringBuilder.toString().length() > str.length() ? str : stringBuilder.toString();
    }

    int[][] rotateMatrix(int[][] matrix) {
        int aux = 0;
        int layer = 0;
        int len = matrix.length;
        final int iterations = getIterations(len);
        for (int i = 0; i < iterations; i++) {
            if (aux == matrix.length - 1 - layer * 2) {
                layer++;
                aux = 0;
            }

            int ax = layer;
            int ay = layer + aux;

            int bx = layer + aux;
            int by = len - 1 - layer;

            int cx = len - 1 - layer;
            int cy = len - 1 - aux - layer;

            int dx = len - 1 - aux - layer;
            int dy = layer;

            swapFour(matrix, ax, ay, bx, by, cx, cy, dx, dy);
            aux++;
        }
        return matrix;
    }

    private void swapFour(int[][] matrix, int ax, int ay, int bx, int by, int cx, int cy, int dx, int dy) {
        int temp = matrix[ax][ay];
        matrix[ax][ay] = matrix[dx][dy];
        matrix[dx][dy] = matrix[cx][cy];
        matrix[cx][cy] = matrix[bx][by];
        matrix[bx][by] = temp;
    }

    private int getIterations(int n) {
        int iterations = (n % 2 == 0) ? 1 : 0;
        int originalN = n;
        for (int i = 0; n > 2; i++) {
            iterations += (originalN - (i * 2)) - 1;
            n = n - 2;
        }

        return iterations;
    }

    int[][] zeroMatrix(int[][] matrix) {
        int x = -1;
        int y = -1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    x = i;
                    y = j;
                    break;
                }
            }
            if (x >= 0) break;
        }

        if (x >= 0) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    if (i == x || j == y) {
                        matrix[i][j] = 0;
                    }
                }
            }
        }

        return matrix;
    }

    boolean stringRotation(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        if (s1.length() == 0) return false;

        int i = 0;
        int j = 0;

        while (i < s1.length()) {
            if (j == s1.length()) {
                if (i == 0) {
                    return false;
                } else {
                    j = 0;
                }
            }

            if (s1.charAt(i) == s2.charAt(j)) {
                i++;
                j++;
            } else {
                j = j - i + 1;
                i = 0;
            }

            if (i == s1.length()) return true;
        }

        return false;
    }
}
