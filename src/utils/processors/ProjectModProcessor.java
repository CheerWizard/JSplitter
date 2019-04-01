package utils.processors;

import annotations.ProjectMod;
import constants.Properties;
import org.jetbrains.annotations.NotNull;
import utils.runners.ConsoleRunner;
import utils.runners.PropertyRunner;

import java.io.IOException;

public final class ProjectModProcessor {
    public static synchronized void runProcess(@NotNull Class<?> targetClassName , String[] args) throws IOException {
        if (targetClassName.isAnnotationPresent(ProjectMod.class)) {
            final ProjectMod annotation = targetClassName.getAnnotation(ProjectMod.class);
            switch (annotation.project_mod()) {
                case CONSOLE:
                    ConsoleRunner.run(args);
                    break;
                case PROPERTIES:
                    PropertyRunner.run(Properties.settings);
                    break;
            }
        }
        else PropertyRunner.run(Properties.settings);
    }
}
