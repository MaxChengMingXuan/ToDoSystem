package todoSystem.views;

public class Task {
	 private String day;
	 private String code;
	 private String task;
	 private String dueDate;
	 private String note;
     private String progress;
	

	public Task(String day,String code,String task, String note, String dueDate) {
		this.day=day;
		this.code = code;
		this.task = task;
		this.dueDate = dueDate;
		this.note=note;
	}
	public String getDay() {
		return day;
	}
	public String getTask() {
		return task;
	}

	public String getCode() {
		return code;
	}

	public String getDueDate() {
		return dueDate;
	}

	public String getNote() {
		return note;
	}
	
	public String getProgress() {
		return progress;
	} 
	
	public void setDay(String day) {
		this.day = day;
	}
	public void setTask(String task) {
		this.task = task;
	}

	public void setCode(String code) {
		this.code=code;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}
	
	public void setNote(String note) {
		this.note=note;
	}
	
	public void setProgress(String progress) {
		this.progress=progress;
	}

	@Override
	public String toString() {
		return "\n" +"Code = " + code + "task = " + task + ", Due Date = " + dueDate+ ", Note = " + note+ ", Progress = "+progress;
	}
}
