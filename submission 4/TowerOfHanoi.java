// TowerOfHanoi.java
public class TowerOfHanoi {
    
    /**
     * Solves Tower of Hanoi puzzle
     * @param n number of disks
     * @param from source rod (A)
     * @param to destination rod (C)
     * @param aux auxiliary rod (B)
     */
    public static void solve(int n, char from, char to, char aux) {
        if (n == 1) {
            System.out.println("Move disk 1 from " + from + " to " + to);
            return;
        }
        
        // Move n-1 disks from source to auxiliary (using destination as aux)
        solve(n - 1, from, aux, to);
        
        // Move the nth (largest) disk from source to destination
        System.out.println("Move disk " + n + " from " + from + " to " + to);
        
        // Move n-1 disks from auxiliary to destination (using source as aux)
        solve(n - 1, aux, to, from);
    }
    
    public static void main(String[] args) {
        int n = 4; 
        System.out.println("Tower of Hanoi solution for " + n + " disks:");
        System.out.println("----------------------------------------");
        solve(n, 'A', 'C', 'B');
        System.out.println("\nTotal moves required = " + (int)(Math.pow(2, n) - 1));
    }
}