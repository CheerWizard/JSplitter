package models;
import dao.ImageDAO;
import org.jetbrains.annotations.Contract;
import utils.ImageSplitter;

import java.io.IOException;

public final class JSplitterModel {
    //make it singleton
    private static JSplitterModel instance;
    //image splitter
    private ImageSplitter imageSplitter;
    //image reader-writer
    private ImageDAO imageDAO;

    private JSplitterModel(String dirName , String fileName) throws IOException {
        imageDAO = new ImageDAO(dirName , fileName);
        imageSplitter = new ImageSplitter(imageDAO);
    }

    @Contract(pure = true)
    public ImageSplitter getImageSplitter() {
        return imageSplitter;
    }

    public void setImageSplitter(ImageSplitter imageSplitter) {
        this.imageSplitter = imageSplitter;
    }

    @Contract(pure = true)
    public ImageDAO getImageDAO() {
        return imageDAO;
    }

    public void setImageDAO(ImageDAO imageDAO) {
        this.imageDAO = imageDAO;
    }

    public static synchronized JSplitterModel getInstance(String dirName , String fileName) throws IOException {
        if (instance == null) instance = new JSplitterModel(dirName, fileName);
        return instance;
    }
}
