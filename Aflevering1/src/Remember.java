public class Remember{
    //We create a repeat method so we can call it later to avoid redundancy
    public static void repeat() {
        System.out.println("Use \"\\\\\" to obtain a ’backslash’ character.");
    }
    public static void main(String[] args){
        repeat();
        System.out.println("Remember:");
        repeat();
    }
}
