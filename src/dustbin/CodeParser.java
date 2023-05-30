package dustbin;
import java.util.*;

public class CodeParser {
    private static final String CLASS_REGEX = "Class\\s+(\\w+)\\s*\\{";
    private static final String FUNCTION_REGEX = "(\\w+)\\s*\\(\\s*\\)\\s*\\{";

    private String code;
    private Map<String, String> classParents;
    private Map<String, List<String>> classChildren;
    private Map<String, String> functionParents;

    private CodeParser(String code) {
        this.code = code;
        classParents = new HashMap<>();
        classChildren = new HashMap<>();
        functionParents = new HashMap<>();
        parseCode(code);
    }

    public static CodeParser parse(String s) {
        return new CodeParser(s);
    }

    public List<String> getChildren(String className) {
        return classChildren.getOrDefault(className, new ArrayList<>());
    }

    public String getParentForClass(String className) {
        return classParents.get(className);
    }

    public String getParentForFun(String funName) {
        return functionParents.get(funName);
    }

    private void parseCode(String code) {
        Stack<String> stack = new Stack<>();
        String currentClass = null;

        String[] lines = code.split("\n");
        for (String line : lines) {
            if (line.matches(CLASS_REGEX)) {
                // Parsing class name
                String className = line.replaceAll(CLASS_REGEX, "$1");
                classParents.put(className, currentClass);
                classChildren.put(className, new ArrayList<>());
                currentClass = className;
                stack.push("Class");
            } else if (line.contains("{")) {
                stack.push("{");
            } else if (line.contains("}")) {
                if (stack.isEmpty()) {
                    continue;
                }
                if (stack.peek().equals("{")) {
                    stack.pop();
                }
                if (stack.peek().equals("Class")) {
                    stack.pop();
                    currentClass = classParents.get(currentClass);
                }
            } else if (line.matches(FUNCTION_REGEX)) {
                // Parsing function name
                String functionName = line.replaceAll(FUNCTION_REGEX, "$1");
                if (currentClass != null) {
                    functionParents.put(functionName, currentClass);
                    classChildren.get(currentClass).add(functionName);
                }
            }
        }
    }
}
