package annotations;

import java.lang.annotation.*;
/**The annotation interface ,
 * which will mark concrete configuration class for JSplitter project.
 * ------------------------------------------------------------------
 * Also it is used to transfer particular parameters ,
 * which any developer can configure.*/
@Inherited
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface JSplitterConfig {
}
