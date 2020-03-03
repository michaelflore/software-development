
/**
 * The TeamMember class defines the properties
 * and methods of a team member. Team members
 * have a name and has joined at a start date.
 *
 * @author Michael Flores mof15
 * @author Alex Varshavsky av653
 */
public class TeamMember {

    private String name;
    private Date startDate;

    /**
     * This is the TeamMember constructor. Takes in a string name and a Date
     * object date.
     *
     * @param nm is the string name of the team member.
     * @param date is the Date object date that represents the start working
     * date of the member..
     */
    public TeamMember(String nm, Date date) {
        this.name = nm;
        this.startDate = date;
    }

    /**
     * The getStartDate method retrieves the start date of the team member.
     *
     * @return The start date.
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * Takes in an object and compares them. Checks if the two are the same team
     * members.
     *
     * @param obj takes in any object.
     * @return true if both date and name are equal, returns false if objects
     * don't match or if the name or date or both are not equal.
     */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        TeamMember teamMember = (TeamMember) obj;
        Date date = teamMember.getStartDate();

        //Name and date must be equal
        if (teamMember.name.equals(this.name) && this.startDate.equals(date)) {
            return true;
        }
        return false;
    }

    public String toString() {
        String teamMember = this.name + " " + this.startDate;
        return teamMember;
    }

    //Testbed main
    public static void main(String[] args) {
        //Test cases that utilize the constructor and all methods in this class.
        String testDate = "02/06/2020";
        String testDate2 = "02/07/2120";
        Date myDate = new Date(testDate);
        Date myDate2 = new Date(testDate2);
        TeamMember testObject1 = new TeamMember("Alex V", myDate);
        TeamMember testObject2 = new TeamMember("Mike F", myDate2);

        System.out.println(testObject1.getStartDate());
        System.out.println(testObject2.getStartDate());

        System.out.println(testObject1.equals(testObject2));
        System.out.println(testObject1.equals(testObject1));
//        
        System.out.println(testObject1.toString());
        System.out.println(testObject2.toString());
    }
}
