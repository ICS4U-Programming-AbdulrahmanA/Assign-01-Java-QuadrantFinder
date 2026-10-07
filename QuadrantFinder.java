/*
 * Finds the quadrant or axis location of points entered by the user.
 *
 * Author: Abdul
 * Date: 2026-10-06
 * Description: Validates coordinates and reports where each point is located.
 */
import java.util.Scanner;

/**
 * Runs the Quadrant Finder program.
 */
public final class QuadrantFinder {

    private QuadrantFinder() {
    }

    /**
     * Reads coordinates, reports their location, and repeats when requested.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(final String[] args) {
        final double minCoord = -1000;
        final double maxCoord = 1000;
        Scanner scanner = new Scanner(System.in);

        // Both coordinates use the same limits so points are checked
        // consistently.
        System.out.println("Welcome to the Quadrant Finder!");
        System.out.println("Enter coordinates between -1000 and 1000.");

        String answer = "";
        while (!answer.equals("N")) {
            double x = 0;
            boolean xIsValid = false;

            while (!xIsValid) {
                System.out.print("Enter the X coordinate (-1000 to 1000): ");
                String input = scanner.nextLine();
                try {
                    x = Double.parseDouble(input);
                    if (x >= minCoord && x <= maxCoord) {
                        xIsValid = true;
                    } else {
                        System.out.println(
                                "Out of range. Enter a number from "
                                        + "-1000 to 1000.");
                    }
                } catch (NumberFormatException exception) {
                    System.out.println(
                            "Invalid entry. Please enter a number, like "
                                    + "3 or -2.5.");
                }
            }

            double y = 0;
            boolean yIsValid = false;

            while (!yIsValid) {
                System.out.print("Enter the Y coordinate (-1000 to 1000): ");
                String input = scanner.nextLine();
                try {
                    y = Double.parseDouble(input);
                    if (y >= minCoord && y <= maxCoord) {
                        yIsValid = true;
                    } else {
                        System.out.println(
                                "Out of range. Enter a number from "
                                        + "-1000 to 1000.");
                    }
                } catch (NumberFormatException exception) {
                    System.out.println(
                            "Invalid entry. Please enter a number, like "
                                    + "3 or -2.5.");
                }
            }

            // The origin and axes are boundaries, not part of any quadrant.
            // Check them first so a zero coordinate cannot be mistaken for a
            // quadrant.
            if (x == 0 && y == 0) {
                // Both coordinates are zero, where the axes meet.
                System.out.println(
                        "The point is the origin, so it is not in any "
                                + "quadrant.");
            } else if (y == 0) {
                // A zero Y value places the point on the horizontal axis.
                System.out.println(
                        "The point is on the x-axis, so it is not in any "
                                + "quadrant.");
            } else if (x == 0) {
                // A zero X value places the point on the vertical axis.
                System.out.println(
                        "The point is on the y-axis, so it is not in any "
                                + "quadrant.");
            } else if (x > 0 && y > 0) {
                // Positive X goes right and positive Y goes up: the
                // upper-right section.
                System.out.println("The point is in Quadrant I.");
            } else if (x < 0 && y > 0) {
                // Negative X goes left while positive Y stays above the
                // horizontal axis.
                System.out.println("The point is in Quadrant II.");
            } else if (x < 0 && y < 0) {
                // Both negative values place the point below and left of
                // the origin.
                System.out.println("The point is in Quadrant III.");
            } else {
                // With the axes already excluded, the remaining sign pair
                // is (+X, -Y).
                System.out.println("The point is in Quadrant IV.");
            }

            answer = "";
            while (!answer.equals("Y") && !answer.equals("N")) {
                System.out.print(
                        "Check another point? (Y/N) "
                                + "(Ensure Capitalization): ");
                answer = scanner.nextLine();
                if (!answer.equals("Y") && !answer.equals("N")) {
                    System.out.println(
                            "Invalid entry. Please enter uppercase Y or N.");
                }
            }
        }

        System.out.println("Goodbye!");
        scanner.close();
    }
}
