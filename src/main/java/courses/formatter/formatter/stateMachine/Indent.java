package courses.formatter.formatter.stateMachine;

/**
 *
 */
public class Indent {
    private static int indent;
    private static final int indentConst = 4;
    /**
     * constructor;
     */
    public Indent() {
        indent = 0;
    }

    public int getIndent() {
        return indent;
    }

    /**
     * increment indent;
     */
    public void incIndent() {
        indent += indentConst;
    }

    /**
     * decrement indent;
     */
    public void decIndent() {
        if (indent >= indentConst) {
            indent -= indentConst;
        }
    }

}
