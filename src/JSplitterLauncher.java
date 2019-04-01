import annotations.ProjectMod;
import constants.ProjectMods;
import org.jetbrains.annotations.NotNull;
import utils.processors.ProjectModProcessor;

import java.io.IOException;

/**To execute this project in different mods , enter annotation @ProjectMod under this class ,
 * and after that select appropriate mod.
 *
 * Mod CONSOLE = will start this project in console and after that will ask arguments for executing project processes.
 * Mod PROPERTIES = will start this project and will take all arguments from setting.properties file to execute all processes.
 *
 * File settings.properties need to be only at general folder of project!
 * Otherwise , the system will not find and recognize the file!
 *
 * If you will not enter any annotation , by default it will start the project as PROPERTIES mod.*/
//@ProjectMod(project_mod = ProjectMods.CONSOLE)
/**To start project in CONSOLE , please open your cmd on your PC , enter 2 commands :
 * javac- JSplitterLauncher.class
 * java- JSplitterLauncher.class
 * Even , if your console can't recognized this , please use StackOverflow website.
 * (https://stackoverflow.com/questions/)*/
//@ProjectMod(project_mod = ProjectMods.PROPERTIES)
public final class JSplitterLauncher {
    public static void main(@NotNull String[] args) {
        try {
            ProjectModProcessor.runProcess(JSplitterLauncher.class , args);
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
