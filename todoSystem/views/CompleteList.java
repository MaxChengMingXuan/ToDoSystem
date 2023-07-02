package todoSystem.views;

import java.util.LinkedList;

public class CompleteList {
	LinkedList<Task> CompleteList=new LinkedList<Task>();
	
	
	public void add(String day,String code,String task, String note, String dueDate) {
		CompleteList.add(new Task(day,code,task,note,dueDate));
	}
	
	public void remove(int i) {
		CompleteList.remove(i);
	}

	public void insertAt(int input, Task data) {
		CompleteList.add(input,data);
		
	}
	public void insertFirst(String day,String code,String task, String note, String dueDate) {
		CompleteList.addFirst(new Task(day,code,task,note,dueDate));
		
	}
	
	public void removeFirst() {
		CompleteList.removeFirst();
	}
	
}
