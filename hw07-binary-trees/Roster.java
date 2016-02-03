/**
 * 
 * @author [First Name] [Last Name] <[ID]>
 * @section [Section Letter]
 * @date [date]
 *
 */

// You may not import any additional classes and packages.
import java.util.*;

public class Roster {
    public StudentNode root;
    public int numStudents;

    public Roster() {
        root = null;
        numStudents = 0;
    }

    public int size() {
        return numStudents;
    }

    public void addCourse(String name, String course) {
        return; // remove this line when you are done
    }

    public void dropCourseFromAll(String course) {
        return; // remove this line when you are done
    }

    public void deleteStudent(String aName) {
        return; // remove this line when you are done
    }

    public String toString() {
        return null; // remove this method when you are done
    }



    // Do not change anything below this line.
    
    public void display() {
        new TreeDisplay<String>().setRoot(copy(root));
    }

    private static TreeNode<String> copy(StudentNode node) {
        if (node == null) return null;
        return new TreeNode<String>(node.name + ":" + node.courses,
                                    copy(node.left),
                                    copy(node.right));
    }
}
