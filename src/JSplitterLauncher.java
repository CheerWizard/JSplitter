import annotations.Console;
import models.JSplitterModel;
import org.jetbrains.annotations.NotNull;
import utils.AnnotationProcessor;
import utils.JSplitterRunner;
import utils.loggers.JSplitterLogger;

import java.io.IOException;

/**To execute this project in console , enter the true value of enabled element
 *
 * Otherwise , you need to enter false value of enabled element.
 *
 * Also , optionally , you can enter your own directory name element , file name element ,
 * and enter amount of pieces , that you required. In other words , you can manage it.
 *
 * Anyway if you don't want to use console , you still need to make this class annotated as @Console
 * as the project will not recognize in which state it should be executed.*/
@Console(enable = false)
public final class JSplitterLauncher {
    //TODO replace hardcoded strings with constants
    public static void main(@NotNull String [] args) {
        //declare args
        String dir_name , image_name;
        int piece_count_by_width , piece_count_by_height;
        //check if the launcher has enabled console
        if (AnnotationProcessor.isConsoleEnabled(JSplitterLauncher.class)) {
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
            dir_name = args[0];
            //image name
            image_name = args[1];
            //count of piece in width
            piece_count_by_width = Integer.parseInt(args[2]);
            //count of piece in height
            piece_count_by_height = Integer.parseInt(args[3]);
        }
        //if not then generate from annotation
        else {
            //ask to get annotation
            final Console console = (Console) AnnotationProcessor.getAnnotation();
            //directory name
            dir_name = console.directory_name();
            //image name
            image_name = console.file_name();
            //count of pieces in height
            piece_count_by_height = console.count_of_pieces_by_height();
            //count of pieces in width
            piece_count_by_width = console.count_of_pieces_by_width();
        }
        //try to run the functionality , entering main model
        try {
            //enter JSplitter model
            JSplitterRunner.run(JSplitterModel.getInstance(dir_name, image_name), piece_count_by_width, piece_count_by_height);
        } catch (NumberFormatException e) {
            System.out.println("Sorry , can't execute with this data! Please insert digital data to execute!");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Illegal count of parameters! You need to enter only 2 parameters!");
        } catch (IOException e) {
            System.out.println("IOException has been thrown\n");
            e.printStackTrace();
        }
    }
}
