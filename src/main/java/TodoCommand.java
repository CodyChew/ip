public class TodoCommand extends Command {

	private String description;

	public TodoCommand(String tsk) {
		this.description = tsk;
	}

	public String getDescription() {
		return this.description;
	}

	@Override
	public void execute(TaskList tasks, Ui ui, Storage storage) {
		Task todo = new Todo(this.description);
		tasks.add(todo);

		//print output
		ui.printTaskAdded(tasks, todo);

		//update storage
		storage.saveListToHardDisk(tasks);
	}

	@Override
	public boolean isExit() {
		return false;
	}
}
