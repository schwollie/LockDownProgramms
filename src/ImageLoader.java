import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class ImageLoader {

    private static ArrayList<BufferedImage> images = new ArrayList<BufferedImage>();

    public static void loadAll() {
        File[] files = new File("images/").listFiles();

        try {
            ArrayList<File> allFiles = getAllFiles(files);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<File> getAllFiles(File[] dir) throws IOException {
        ArrayList<File> files = new ArrayList<>();
        for (File file : dir) {
            images.add(ImageIO.read(file));
        }

        return files;
    }

    public static BufferedImage getRand() {
        if (images.size() == 0) {loadAll();}

        Random rnd = new Random();
        int i = rnd.nextInt(images.size());

        return images.get(i);

    }


}
