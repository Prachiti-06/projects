package selenium.testcases.utils;

public class AssertUtils {

    public static boolean assertEquals(String actual, String expected) {
        if (actual.equalsIgnoreCase(expected)) {
            System.out.println("Assert passed");
            return true;
        } else {
            System.err.println("Assert failed");
            System.exit(1);
            return false;
        }
    }

    public static boolean assertContains(String actual, String expected) {
        if (actual.contains(expected)) {
            System.out.println("Assert passed");
            return true;
        } else {
            System.err.println("Assert failed");
            System.exit(1);
            return false;
        }
    }

    public static boolean assertEquals(boolean actual, boolean expected) {
        if (actual == expected) {
            System.out.println("Assert passed");
            return true;
        } else {
            System.err.println("Assert failed");
            System.exit(1);
            return false;
        }
    }

    public static boolean assertEquals(int actual, int expected) {
        if (actual == expected) {
            System.out.println("Assert passed");
            return true;
        } else {
            System.err.println("Assert failed");
            System.exit(1);
            return false;
        }
    }

}
