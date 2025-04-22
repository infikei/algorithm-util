package algoutils.parsing;

public class IntArrayParser {

    public static int[] parse(String input) {
        if (input.charAt(0) != '[' || input.charAt(input.length() - 1) != ']') {
            throw new IllegalArgumentException();
        }

        String innerInput = input.substring(1, input.length() - 1);
        String[] parts = innerInput.split(", ");
        int[] arr = new int[parts.length];

        for (int i = 0; i < parts.length; i++) {
            arr[i] = Integer.parseInt(parts[i]);
        }

        return arr;
    }

}
