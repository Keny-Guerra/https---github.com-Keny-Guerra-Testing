package practica.mirror;

public class Mirror {

    public String mirrorEnds(String string) {
        StringBuilder mirror = new StringBuilder();
        int length = string.length();

        for (int i = 0; i < length; i++) {
            if (string.charAt(i) == string.charAt(length - 1 - i)) {
                mirror.append(string.charAt(i));
            } else {
                break;
            }
        }

        return mirror.toString();
    }
}