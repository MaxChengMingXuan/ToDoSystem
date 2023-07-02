package todoSystem.views;
import java.util.LinkedList;



public class TaskList {
	LinkedList<Task> TaskList=new LinkedList<Task>();
	

	public void add(String day,String code,String task, String note, String dueDate) {
		TaskList.add(new Task(day,code,task,note,dueDate));
	}
	
	public void remove(int i) {
		TaskList.remove(i);
	}

	public void insertAt(int input, Task data) {
		TaskList.add(input,data);
		
	}
	public void insertFirst(Task data) {
		TaskList.addFirst(data);
		
	}
	
	public void removeFirst() {
		TaskList.removeFirst();
	}
}
