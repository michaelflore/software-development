
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * The ProjectManager class acts as a user interface while reading from standard
 * input and display standard output. This class is running until done = true
 * and keeps taking commands, validating them and executing them if they are
 * correct. This class allows us to add and remove team members as well as
 * display all members.
 *
 * @author Michael Flores mof15
 * @author Alex Varshavsky av653
 */
public class ProjectManager {

    Scanner stdin;
    Team cs213;

    /**
     * The Run method starts the interface and waits for commands. Initializes
     * the scanners and while done = false, it runs and takes next command.
     * Checks if the command is valid after tokenizing the input.
     */
    public void run() {
        stdin = new Scanner(System.in);  //init scanner.
        cs213 = new Team();   // create new team object.
        char command;
        String employeeName;
        String startDate;
        boolean done = false;

        while (!done) {
            String input = stdin.nextLine();
            StringTokenizer string = new StringTokenizer(input, " ");
            command = string.nextToken().charAt(0);

            // any case besides 'A' , 'R', 'P' and 'Q' are invalid.
            switch (command) {
                case 'A':
                    employeeName = string.nextToken();
                    startDate = string.nextToken();
                    add(employeeName, startDate); //adds employee.
                    break;
                case 'R':
                    employeeName = string.nextToken();
                    startDate = string.nextToken();
                    remove(employeeName, startDate);  //removes employee.
                    break;
                case 'P':
                    print(); //prints team members.
                    break;
                case 'Q':  // prints and quits.
                    print();
                    System.out.println("The team is ready to go!");
                    done = true;
                    break;

                default:
                    System.out.println("Command '" + command + "' not supported!");
                    break;
            }
        }

        System.exit(0);
    }

    /**
     * The add method checks if the input date is valid, checks for duplication,
     * and then adds the member to the team if it doesn't exist.
     *
     * @param employeeName The input employee name.
     * @param date The input start date date.
     */
    private void add(String employeeName, String date) {

        Date startDate = new Date(date);

        if (startDate.isValid()) {  //check if date is valid.
            TeamMember newMember = new TeamMember(employeeName, startDate);

            boolean doesExist = cs213.contains(newMember); // checks if team member already exists.

            if (doesExist == true) {
                System.out.println(newMember.toString() + " is already in the team.");
            } else {
                cs213.add(newMember);  //adds team member to the next available index in array.
            }
        } else {
            System.out.println(startDate.toString() + " is not a valid date!");
        }
    }

    /**
     * The remove method removes a member from the team, unless the member is
     * not an actual member. If member exists, it removes him and the last item
     * in the array replaces it's position.
     *
     * @param employeeName The name to be removed.
     * @param date The start date of the employee to be removed.
     */
    private void remove(String employeeName, String date) {

        Date startDate = new Date(date);

        if (startDate.isValid()) { //check if date is valid.
            TeamMember memberToRemove = new TeamMember(employeeName, startDate);
            boolean wasRemoved = cs213.remove(memberToRemove);  //removes member.
            if (wasRemoved == true) {
                System.out.println(memberToRemove.toString() + " has left the team.");
            } else {
                System.out.println(memberToRemove.toString() + " is not a team member.");
            }
        }
    }

    /**
     * The print method outputs all members in the team. If the team is empty it
     * displays that it has 0 members.
     */
    private void print() {
        if (cs213.isEmpty()) {
            System.out.println("We have 0 team members!");
        } else {
            cs213.print();
        }
    }
} //ProjectManager

