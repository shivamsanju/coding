import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/*
 * Find empty folders: find . -type d -name '.git' -prune -o -type d -empty -print
 * Remove empty folders: find . -type d -name '.git' -prune -o -type d -empty -exec rmdir {} +
 */

public class FolderManager {

    private static final String ROOT_DIR = "./";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the index position: ");
        int position;
        while (true) {
            try {
                position = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.print("Invalid index format. Please enter an integer: ");
            }
        }

        System.out.print("Enter the folder name: ");
        String folderName = scanner.nextLine();

        try {
            addFolder(position, folderName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        scanner.close();
    }

    public static void addFolder(int position, String folderName) throws IOException {
        File root = new File(ROOT_DIR);
        if (!root.isDirectory()) {
            throw new IllegalArgumentException("Provided path is not a directory.");
        }

        File[] folders = root.listFiles(File::isDirectory);
        if (folders == null)
            return;

        Arrays.sort(folders, Comparator.comparingInt(FolderManager::extractNumber));

        for (int i = folders.length - 1; i >= position - 1; i--) {
            File oldFolder = folders[i];
            int newNumber = extractNumber(oldFolder) + 1;
            File newFolder = new File(ROOT_DIR, formatNumber(newNumber) + ". " + oldFolder.getName().substring(3));
            if (!oldFolder.renameTo(newFolder)) {
                throw new IOException("Failed to rename " + oldFolder.getName() + " to " + newFolder.getName());
            }
        }

        // Create the new folder
        String newFolderName = formatNumber(position) + ". " + folderName;
        File newFolder = new File(ROOT_DIR, newFolderName);
        if (!newFolder.mkdir()) {
            throw new IOException("Failed to create " + newFolderName);
        }

        System.out.println("Folder added: " + newFolderName);
    }

    private static int extractNumber(File folder) {
        String name = folder.getName();
        try {
            return Integer.parseInt(name.split("\\.")[0].trim());
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    private static String formatNumber(int number) {
        return String.format("%02d", number);
    }
}
