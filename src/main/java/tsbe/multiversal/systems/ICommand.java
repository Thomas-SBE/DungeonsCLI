package tsbe.multiversal.systems;

public interface ICommand {

    String getPrefix();
    int getArgs();
    boolean valid(String[] argv, Object[] data);
    boolean execute(String[] argv, Object[] data);
    String getHelpDesc();

}
