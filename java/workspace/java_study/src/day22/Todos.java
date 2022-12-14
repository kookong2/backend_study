package day22;

import java.lang.annotation.*;
import static java.lang.annotation.ElementType.*;

@Target({TYPE,ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Todos {

	Todo[] value();
}
