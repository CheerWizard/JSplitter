package annotations;

import java.lang.annotation.*;
/**The annotation interface that will only mark each
 *concrete model implementation*/
@Inherited
@Target(ElementType.PACKAGE)
@Retention(RetentionPolicy.SOURCE)
public @interface Model {}
