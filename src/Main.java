public class Main {

    public static void main(String[] args) {
        GamingPCDirector director = new GamingPCDirector();

        GamingPC budgetPC = director.buildBudgetPC(
                new GamingPC.Builder()
        );
        GamingPC highEndPC = director.buildHighEndPC(
                new GamingPC.Builder()
        );
        System.out.println("Budget Gaming PC:");
        System.out.println(budgetPC);

        System.out.println("\nHigh-End Gaming PC:");
        System.out.println(highEndPC);
    }
}