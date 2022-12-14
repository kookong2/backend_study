package day22;

import java.lang.annotation.*;
import static java.lang.annotation.ElementType.*;

@Repeatable(Todos.class)
@Target({TYPE,ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Todo {
	String value();
}
