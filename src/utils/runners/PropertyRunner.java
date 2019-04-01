package utils.runners;

import constants.Properties;
import models.JSplitterModel;
import utils.loaders.PropertyLoader;

import java.io.IOException;

public final class PropertyRunner {
    public static synchronized void run(String propertyPath) throws IOException {
        //ask to load properties
        PropertyLoader.load(propertyPath);
        //get required properties
        final String dir_name = PropertyLoader.getPropertyValue("image_directory");
        final String image_name = PropertyLoader.getPropertyValue("image_name");
        final int cnt_in_width = Integer.parseInt(PropertyLoader.getPropertyValue("count_of_pieces_in_width"));
        final int cnt_in_height = Integer.parseInt(PropertyLoader.getPropertyValue("count_of_pieces_in_height"));
        System.out.println("dir_name : " + dir_name);
        System.out.println("image_name : " + image_name);
        System.out.println("width : " + cnt_in_width);
        System.out.println("height : " + cnt_in_height);
        //ask to run JSplitter model
        JSplitterRunner.run(JSplitterModel.getInstance(dir_name , image_name) , cnt_in_width , cnt_in_height);
    }
    public static void main(String[] args) {
        try {
            run(Properties.settings);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
