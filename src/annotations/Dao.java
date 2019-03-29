package annotations;
import java.lang.annotation.*;
/**Implementation of data access objects , which you can use for accessing to any
 * external or internal resources*/
/**Right now it's just annotation interface ,
 * which will only mark each concrete implementation.*/
@Inherited
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface Dao {}
