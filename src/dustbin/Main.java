package  dustbin;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        String example = "Class A {Class B {foo() { }bar() {}}Class C {}}";

        CodeParser parser = CodeParser.parse(example);

        List<String> childrenA = parser.getChildren("A");
        System.out.println("Children of A: " + childrenA);  // Output: [B, C]

        List<String> childrenB = parser.getChildren("B");
        System.out.println("Children of B: " + childrenB);  // Output: [foo, bar]

        String parentB = parser.getParentForClass("B");
        System.out.println("Parent of B: " + parentB);  // Output: A

        String parentFoo = parser.getParentForFun("foo");
        System.out.println("Parent of foo: " + parentFoo);  // Output: B

        String parentA = parser.getParentForClass("A");
        System.out.println("Parent of A: " + parentA);  // Output: null
    }
}
