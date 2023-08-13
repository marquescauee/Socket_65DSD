package command;

import java.util.ArrayList;
import java.util.List;

import command.pessoa.Command;

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
