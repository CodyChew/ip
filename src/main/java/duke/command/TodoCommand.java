package duke.command;

import duke.storage.Storage;
import duke.task.Task;
import duke.task.TaskList;
import duke.task.Todo;
import duke.ui.Ui;

/**
 * Represents a Command to add a new Todo object to the TaskList
 */
public class TodoCommand extends Command {

    private String description;

    /**
     * Constructs a command with in a String description.
     *
     * @param tsk String description of the Todo Task object.
     */
    public TodoCommand(String tsk) {
        this.description = tsk;
    }

    /**
     * Creates a new Todo Task and adds it into the TaskList. The Storage
     * is updated with the latest Task and the Ui Object will return a
     * relevant string message to notify the user on this addition.
     *
     * @param tasks   TaskList object containing the list of tasks.
     * @param ui      Ui object to output messages to the user.
     * @param storage Storage object to interact and manipulate data from the hard disk.
     * @return String response to user.
     */
    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage) {
        Task todo = new Todo(this.description);
        tasks.add(todo);

        //print output
        String output = ui.printTaskAdded(tasks, todo);

        //update storage
        storage.saveListToHardDisk(tasks);

        return output;
    }

    /**
     * Returns false to indicate that the Command does not exit the program.
     *
     * @return Exit program indicator
     */
    @Override
    public boolean isExit() {
        return false;
    }
}
