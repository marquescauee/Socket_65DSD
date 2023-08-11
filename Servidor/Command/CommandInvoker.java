package Command;

import java.util.ArrayList;
import java.util.List;

public class CommandInvoker {

	private List<Command> todos = new ArrayList<>();
    
    public void execute(Command comm) {
    	comm.execute();
        todos.add(comm);
    }

    public void undo() {
        
    }
    
    
    public void redo() {
        
    }
}
