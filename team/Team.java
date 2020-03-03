
/**
 *  The container Team class which holds an array of
 *  team members that has methods add, remove,
 *  and find specific team members.
 *  The array is initially size 4 and grows by 4 every time we run out of space.
 *  Removed item is replaced by the last item of the array.
 *
 * @author Michael Flores mof15
 * @author Alex Varshavsky av653
 */
public class Team {

    private final int NOT_FOUND = -1;
    private final int GROW_SIZE = 4; //initial and grow size
    private TeamMember[] team;
    private int numMembers;

    //This is the default constructor
    public Team() {
        System.out.println("Let's start a new team!");
        numMembers = 0;
        team = new TeamMember[GROW_SIZE];
    }

    /**
     * The find method searches for a specific team member at a given index.
     *
     * @param m The given team member to find.
     * @return The index the member is found at or -1 if not found.
     */
    private int find(TeamMember m) {
        int element; //Index the member is found at

        for (int i = 0; i < team.length; i++) {
            if (team[i] != null) {
                if (team[i].equals(m)) {
                    element = i;
                    return element;
                }
            }
        }
        return NOT_FOUND;
    }

    /**
     * The grow method adds four slots to the array each time the team appears
     * to be full.
     */
    private void grow() {
        //Create a new array with 4 extra slots each time grow is invoked
        TeamMember[] biggerTeam = new TeamMember[team.length + GROW_SIZE];
        for (int i = 0; i < team.length; i++) {
            biggerTeam[i] = team[i];
        }

        //The bigger array becomes the new team array
        team = biggerTeam;
    }

    /**
     * Checks if the team is empty.
     *
     * @return true if empty and false if not empty.
     */
    public boolean isEmpty() {
        if (numMembers == 0) {
            return true;
        }
        return false;
    }

    /**
     * The add method appends a new team member to the end of the array. If the
     * array is full, the grow method is called to allocate 4 more spaces.
     *
     * @param m The member to be added.
     */
    public void add(TeamMember m) {
        if (numMembers % 4 != 0 || numMembers == 0) {
            team[numMembers] = m;
            numMembers++;
            System.out.println(m + " has joined the team.");
        } else {
            grow();  //grows array by 4 if full.
            team[numMembers] = m;
            numMembers++;
            System.out.println(m + " has joined the team.");
        }
    }

    /**
     * The remove method removes a team member at an index. The last item fills
     * the deleted slot and then becomes null.
     *
     * @param m The member to be removed.
     * @return Whether it is successfully removed.
     */
    public boolean remove(TeamMember m) {
        if (!isEmpty()) {
            int storedIndex = find(m);
            if (storedIndex >= 0) {
                team[storedIndex] = team[numMembers - 1]; //Last item in array fills slot
                team[numMembers - 1] = null; //Last item becomes null
                numMembers--; //Number of members decreases
                return true;
            }
        }
        return false;
    }

    /**
     * The contains method checks if the team member is in the team already.
     *
     * @param m The member to be checked.
     * @return Whether true if it contains the member and false if not.
     */
    public boolean contains(TeamMember m) {
        for (int i = 0; i < team.length; i++) {
            if (team[i] != null) {
                if (team[i].equals(m)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Prints all current team members.
     */
    public void print() {
        System.out.println("We have the following team members:");
        for (int i = 0; i < team.length; i++) {
            if (team[i] == null) {
            } else {
                System.out.println(team[i].toString());
            }
        }

        System.out.println("-- end of the list --");
    }
}
