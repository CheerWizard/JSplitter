package utils.runners;

import models.JSplitterModel;
import org.jetbrains.annotations.NotNull;
import utils.loggers.JSplitterLogger;

import java.io.IOException;

public final class ConsoleRunner {
    public static synchronized void run(@NotNull String[] args) throws IOException {
        //explain what to do , step-by-step
        System.out.print("Please follow to this sequence of arguments : \n");
        System.out.print("args[0] -> Means directory name\n");
        System.out.print("args[1] -> Means concrete image name , including image format (ex. .png , .jpeg , etc.)\n");
        System.out.print("args[2] -> Means an amount of pieces , in which you want to cut width of your image\n");
        System.out.print("args[3] -> Means an amount of pieces , in which you want to cut height of your image\n");
        //check length of entered arguments
        if (args.length != 4) {
            JSplitterLogger.warn("JSplitter", "You should enter the directory name of image , \n" +
                    "the concrete image name \n" +
                    "and also 2 count parameters (by_width , by_height) ,\n" +
                    "in which you wanna to split!\n");
            throw new RuntimeException("Sorry I can't work without start data and start parameters!");
        }
        //directory name
        final String dir_name = args[0];
        //image name
        final String image_name = args[1];
        //count of piece in width
        final int piece_count_by_width = Integer.parseInt(args[2]);
        //count of piece in height
        final int piece_count_by_height = Integer.parseInt(args[3]);
        //ask JSplitter to run
        JSplitterRunner.run(JSplitterModel.getInstance(dir_name, image_name), piece_count_by_width, piece_count_by_height);
    }
}
