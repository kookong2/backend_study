package day22;

@Todo("할일1")
@Todo("할일2")
@Todo("할일3")
public class Ex03 {
	public static void main(String[] args) {
		
		Class<Ex03> cls = Ex03.class;
		Todos todos = cls.getAnnotation(Todos.class);
		for(Todo todo : todos.value()) {
			System.out.println(todo.value());
		}
	}
}
