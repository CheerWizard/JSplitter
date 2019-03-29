package utils;

import annotations.Console;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.lang.annotation.Annotation;

public final class AnnotationProcessor {

    private static Annotation annotation;

    public static synchronized boolean isConsoleEnabled(@NotNull Class<?> className) {
        boolean enabled = false;
        if (className.isAnnotationPresent(Console.class)) {
            annotation = className.getAnnotation(Console.class);
            enabled = ((Console) annotation).enable();
        }
        return enabled;
    }
    @Contract(pure = true)
    public static synchronized Annotation getAnnotation() {
        if (annotation == null) throw new RuntimeException("You have tried to get null Annotation!\nTo use it , you should first initialize it!");
        return annotation;
    }

    public static synchronized void initAnnotation(@NotNull Class<?> className , Class<Annotation> annotationClassName) {
        annotation = className.getAnnotation(annotationClassName);
    }
}
