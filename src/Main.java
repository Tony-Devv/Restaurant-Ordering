import facade.RestaurantFacade;


public class Main {
    public static void main(String[] args) {

        RestaurantFacade restaurant = new RestaurantFacade();
        restaurant.startOrderingProcess();
        
        System.out.println("\n╔══════════════════════════════════════╗");
        System.out.println("║  Thank you for using our system!     ║");
        System.out.println("╚══════════════════════════════════════╝");
    }
}