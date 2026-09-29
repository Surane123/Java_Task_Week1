package collections;

import java.util.Scanner;

/** Application entry point. */
public final class Main {
    private Main() { }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            new CollectionsChallenge(scanner).run();
        }
    }
}
