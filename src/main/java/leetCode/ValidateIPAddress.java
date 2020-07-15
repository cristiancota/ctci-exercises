package leetCode;

public class ValidateIPAddress {
    public String validIPAddress(String IP) {
        final String neither = "Neither";
        if (IP.isEmpty()) return neither;
        int i = 0;
        final char c = IP.charAt(i);

        while (i <= IP.length() && c != '.' && c != ':' && i < 5) {
            i++;
        }

        switch (c) {
            case '.':
                return isValidIPV4(IP) ? "IPv4" : neither;
            case ':':
                return isValidIPV6(IP) ? "IPv6" : neither;
            default:
                return neither;
        }
    }


    public boolean isValidIPV4(String ip) {
        int chunkCounter = 0;
        StringBuilder stringBuilder = new StringBuilder();
        char[] charArray = ip.toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            char currentChar = charArray[i];
            if (chunkCounter == 3) {
                final String substring = ip.substring(i);
                for (char lastChar : substring.toCharArray())
                    if (isInvalidV4Char(lastChar)) return false;
                return isValidV4Chunk(substring);
            }
            if (currentChar != '.') {
                if (isInvalidV4Char(currentChar)) return false;
                stringBuilder.append(currentChar);
            } else {
                if (!isValidV4Chunk(stringBuilder.toString()))
                    return false;
                chunkCounter++;
                stringBuilder = new StringBuilder();
            }
        }

        return chunkCounter < 3 && stringBuilder.length() == 0;
    }

    public boolean isValidIPV6(String ip) {
        int chunkCounter = 0;
        StringBuilder stringBuilder = new StringBuilder();
        char[] charArray = ip.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char currentChar = charArray[i];
            if (chunkCounter == 7) {
                final String substring = ip.substring(i);
                for (char lastChar : substring.toCharArray())
                    if (isInvalidV6Char(lastChar)) return false;
                return isValidV6Chunk(substring);
            }
            if (currentChar != ':') {
                if (isInvalidV6Char(currentChar)) return false;
                stringBuilder.append(currentChar);
            } else {
                if (!isValidV6Chunk(stringBuilder.toString()))
                    return false;
                chunkCounter++;
                stringBuilder = new StringBuilder();
            }
        }
        return chunkCounter < 7 && stringBuilder.length() == 0;
    }

    public boolean isValidV4Chunk(String chunk) {
        if (chunk.length() == 0) return false;
        final int integer = Integer.parseInt(chunk);
        if (chunk.length() > 3) return false;
        if (integer == 0 && chunk.length() > 1) return false;
        if (integer > 0 && chunk.charAt(0) == '0') return false;
        return integer >= 0 && integer <= 255;
    }

    public boolean isValidV6Chunk(String chunk) {
        if (chunk.length() == 0) return false;
        final int integer = Integer.parseInt(chunk, 16);
        if (chunk.length() > 4) return false;
        return integer >= 0 && integer <= 0xFFFF;
    }

    private boolean isInvalidV6Char(char s) {
        return s < 48 || s > 102 || (s > 57 && s < 65) || (s > 70 && s < 97);
    }

    private boolean isInvalidV4Char(char s) {
        return (s < 48 || s > 60);
    }
}
