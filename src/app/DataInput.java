package app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public final class DataInput {

    public static Double getDouble(){ return getDouble(null);}

    public static Double getDouble(String text) {
        Double ans = null;
        while (true) {
            try {
                ans = Double.valueOf(getString(text));
                break;
            } catch (IOException e) {
                e.printStackTrace();
            } catch (NumberFormatException e) {
                System.out.println("Incorrect Format");
            }
        }
        return ans;
    }

    public static Long getLong() throws IOException {
        return getLong(null);
    }

    public static Long getLong(String text) throws IOException {
        String s = getString(text);
        Long value = Long.valueOf(s);
        return value;
    }

    public static Character getChar() throws IOException, IndexOutOfBoundsException {
        return getChar(null);
    }

    public static Character getChar(String text) throws IOException, IndexOutOfBoundsException {
        String s = getString(text);
        if (s.length() == 0)
            return null;
        return s.charAt(0);
    }

    public static Integer getInt() {
        return getInt(null);
    }

    public static Integer getInt(String text) throws NumberFormatException {
        while (true) {
            try {
                String s = "";
                try {
                    s = getString(text);
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                Integer value = Integer.valueOf(s);
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Incorrect format");
            }
        }

    }

    public static String getString() throws IOException {
        return getString(null);
    }

    public static String getString(String text) throws IOException {
        if (text != null)
            System.out.print(text);
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }
}
