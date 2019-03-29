package annotations;

import java.lang.annotation.*;

@Inherited
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Console {
    boolean enable();
    String directory_name() default "/res/images";
    String file_name() default "default.png";
    int count_of_pieces_by_width() default 2;
    int count_of_pieces_by_height() default 2;
}
