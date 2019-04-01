package dao;

import annotations.Dao;
import constants.StringResources;
import org.jetbrains.annotations.NotNull;
import utils.loaders.PropertyLoader;
import utils.loggers.JSplitterLogger;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
@Dao
public class ImageDAO {
    //class name
    private String class_name = getClass().getName();
    //directory name
    protected String dirName;
    //file name
    protected String fileName;
    //without .png or .jpg
    private String pieceName;
    //full image
    protected BufferedImage fullBufferedImage;
    //piece of full image
    private BufferedImage pieceBufferedImage;
    //file
    protected File file;

    public ImageDAO(String dirName , @NotNull String fileName) throws IOException {
        JSplitterLogger.info(class_name , StringResources.initializing);
        this.fileName = fileName;
        this.dirName = dirName;
        this.pieceName = fileName.substring(0 , fileName.length() - 4);
        JSplitterLogger.info(class_name , StringResources.reading_image);
        file = new File(dirName , fileName);
        readImage(file);
    }

    public ImageDAO() {
        //protect default constructor
        JSplitterLogger.info(class_name , StringResources.initializing);
        defaultInit();
    }

    private void defaultInit() {
        this.fileName = "";
        this.pieceName = "";
        this.file = new File("");
        this.fullBufferedImage = new BufferedImage(0 , 0 , BufferedImage.TYPE_BYTE_INDEXED);
    }

    public String getDirName() {
        return dirName;
    }

    public void setDirName(String dirName) {
        this.dirName = dirName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getPieceName() {
        return pieceName;
    }

    public void setPieceName(String pieceName) {
        this.pieceName = pieceName;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public void readImage(File file) throws IOException {
        fullBufferedImage = ImageIO.read(file);
    }

    public void readImage(String dir , String fileName) throws IOException {
        file = new File(dir , fileName);
        fullBufferedImage = ImageIO.read(file);
    }

    public void writeImagePiece(double x , double y , double step_width , double step_height , int pieceId) throws IOException {
        createImagePieceFile(x, y, step_width, step_height, pieceId);
    }

    private void createImagePieceFile(double x , double y , double step_width , double step_height , int pieceId) throws IOException {
        final String pieces_dir = PropertyLoader.getPropertyValue("pieces_directory");
        final String pieces_name = PropertyLoader.getPropertyValue("pieces_name");
        final String image_format = PropertyLoader.getPropertyValue("image_format");
        file = new File(pieces_dir , pieceName + pieces_name + pieceId + image_format);
        pieceBufferedImage = fullBufferedImage.getSubimage((int) x,(int) y,(int) step_width,(int) step_height);
        ImageIO.write(pieceBufferedImage, "png", file);
    }

    public String getClass_name() {
        return class_name;
    }

    public BufferedImage getFullBufferedImage() {
        return fullBufferedImage;
    }

    public void setFullBufferedImage(BufferedImage fullBufferedImage) {
        this.fullBufferedImage = fullBufferedImage;
    }

    public BufferedImage getPieceBufferedImage() {
        return pieceBufferedImage;
    }

    public void setPieceBufferedImage(BufferedImage pieceBufferedImage) {
        this.pieceBufferedImage = pieceBufferedImage;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    private boolean isHorizontalRectangle() {
        return fullBufferedImage.getWidth() > fullBufferedImage.getHeight();
    }

    private boolean isVerticalRectangle() {
        return fullBufferedImage.getWidth() < fullBufferedImage.getHeight();
    }

    public boolean isSquare() {
        return fullBufferedImage.getWidth() == fullBufferedImage.getHeight();
    }

    public boolean isRectangle() {
        return (isHorizontalRectangle() || isVerticalRectangle());
    }
    //TODO create method , that will check image_pieces directory for available files. It will be useful for faster executing and avoiding repeating of splitting!
}
