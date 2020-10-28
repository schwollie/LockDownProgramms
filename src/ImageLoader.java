import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class ImageLoader {

    private static HashMap<String, BufferedImage> images = new HashMap<>();

    public static void loadAll() {
        File[] files = new File("images/").listFiles();
        ArrayList<File> allFiles = getAllFiles(files);
    }

    public static ArrayList<File> getAllFiles(File[] dir) {
        ArrayList<File> files = new ArrayList<>();
        for (File file : dir) {
            if (file.isDirectory()) {
                files.addAll(getAllFiles(file.listFiles())); // Calls same method again.
            } else if (file.getPath().endsWith(".png") || file.getPath().endsWith(".jpg") || file.getPath().endsWith(".jpeg")) {
                files.add(file);
            }
        }

        return files;
    }

    public static BufferedImage getFromFilePath(String filepath) {
        filepath = filepath.replaceAll("/", "\\\\");

        if (!images.containsKey(filepath)) {
            System.err.println("Could not load File: " + filepath);
        }

        return ImageLoader.images.get(filepath);
    }

    public BufferedImage getRand() {
        if (images.size() == 0) {loadAll();}
        return null;
    }


}
