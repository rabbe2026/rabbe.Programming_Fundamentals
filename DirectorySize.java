import java.io.File;
import java.util.Scanner;

/**
 * Task 4: Directory size calculator.
 *
 * - Asks for a directory name (or takes it as a command line argument).
 * - Prints an error if the directory does not exist.
 * - Otherwise prints the total size of all files (including subdirectories)
 *   in MB, KB and bytes.
 * - Additional: prints the size of every directory and subdirectory.
 */
public class DirectorySize {

    public static void main(String[] args) {
        String path;
        if (args.length > 0) {
            path = args[0];
        } else {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter directory name: ");
            path = scanner.nextLine().trim();
        }

        File dir = new File(path);

        if (!dir.exists()) {
            System.out.println("Error: Directory \"" + path + "\" does not exist.");
            return;
        }
        if (!dir.isDirectory()) {
            System.out.println("Error: \"" + path + "\" is not a directory.");
            return;
        }

        System.out.println();
        System.out.println("Size of each directory (including its subdirectories):");
        System.out.println("-------------------------------------------------------");
        long total = printSizes(dir, 0);

        System.out.println();
        System.out.println("Total size of \"" + path + "\":");
        System.out.println("  " + format(total));
    }

    /**
     * Recursively calculates the size of a directory, printing the size of
     * the directory itself and then each of its subdirectories (indented).
     * Returns the total size in bytes.
     */
    private static long printSizes(File dir, int level) {
        // Compute this directory's total first, so we can print it before its children.
        long total = calculateSize(dir);
        System.out.println("  ".repeat(level) + dir.getName().replaceAll("^$", dir.getPath())
                + "  ->  " + format(total));

        File[] children = dir.listFiles();
        if (children != null) {
            for (File child : children) {
                if (child.isDirectory()) {
                    printSizes(child, level + 1);
                }
            }
        }
        return total;
    }

    /** Total size in bytes of all files in a directory and its subdirectories. */
    private static long calculateSize(File dir) {
        long size = 0;
        File[] children = dir.listFiles();
        if (children == null) {      // no permission or I/O error
            return 0;
        }
        for (File child : children) {
            if (child.isFile()) {
                size += child.length();
            } else if (child.isDirectory()) {
                size += calculateSize(child);
            }
        }
        return size;
    }

    /** Formats a byte count as "x MB | y KB | z bytes". */
    private static String format(long bytes) {
        double kb = bytes / 1024.0;
        double mb = bytes / (1024.0 * 1024.0);
        return String.format("%.4f MB | %.2f KB | %d bytes", mb, kb, bytes);
    }
}
