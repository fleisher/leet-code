package validparentheses;

public class ValidParentheses {

    public static void main(String[] args) {
        String s = "[";

        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {

        char[] b = new char[s.length() / 2 + 1];
        int i = -1;

        for (char sim : s.toCharArray()) {
            switch (sim) {
                case ')': {
                    if (!(i >= 0 && b[i--] == '(')) { return false; }
                    break;
                }
                case '}': {
                    if (!(i >= 0 && b[i--] == '{')) { return false; }
                    break;
                }
                case ']': {
                    if (!(i >= 0 && b[i--] == '[')) { return false; }
                    break;
                }
                default: {
                    if (++i > s.length() / 2) { return false; }
                    b[i] = sim;
                }
            }
        }

        return i == -1;
    }
}
