package algoutils.parsing;

import java.util.ArrayList;

public class Int2DArrayParser {

    public static int[][] parse(String input) {
        if (input.charAt(0) != '[' || input.charAt(input.length() - 1) != ']') {
            throw new IllegalArgumentException();
        }

        String innerInput = input.substring(1, input.length() - 1);
        ArrayList<String> parts = new ArrayList<String>(); 
        int pos = 0;

        while (pos < innerInput.length()) {
            if (innerInput.charAt(pos) == '[') {
                int parEnd = pos + 1;

                while (parEnd < innerInput.length() && innerInput.charAt(parEnd) != ']') {
                    parEnd++;
                }

                if (parEnd == innerInput.length()) return null;

                System.out.println("$" + innerInput.substring(pos, parEnd + 1) + "$");
                parts.add(innerInput.substring(pos, parEnd + 1));
                pos = parEnd + 1;

                if (pos < innerInput.length()) {
                    if (innerInput.charAt(pos) != ',' || innerInput.charAt(pos + 1) != ' ') {
                        throw new IllegalArgumentException();
                    }

                    pos += 2;
                }
            } else {
                throw new IllegalArgumentException();
            }
        }

        int[][] arr = new int[parts.size()][];

        for (int i = 0; i < parts.size(); i++) {
            try {
                arr[i] = IntArrayParser.parse(parts.get(i));
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException();
            }
        }

        return arr;
    }

}
