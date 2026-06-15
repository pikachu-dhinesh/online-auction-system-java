import java.util.*;

class Bidder {
    String name;
    int bid;

    Bidder(String name, int bid) {
        this.name = name;
        this.bid = bid;
    }
}

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Bidder> bidders = new ArrayList<>();
        Random random = new Random();

        String[] wishes = {
                "Congratulations on winning!",
                "Great bidding! Enjoy your product.",
                "You are the highest bidder!",
                "Auction completed successfully!",
                "Excellent choice and winning bid!"
        };

        System.out.println("===== ONLINE AUCTION SYSTEM =====");

        System.out.print("Enter Product Name: ");
        String product = sc.nextLine();

        System.out.print("Enter Starting Price: ₹");
        int startPrice = sc.nextInt();

        System.out.print("How many persons are ready to bid? ");
        int n = sc.nextInt();

        sc.nextLine();

        // Initial bidders
        for (int i = 1; i <= n; i++) {

            System.out.println("\nPerson " + i);

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Bid Amount: ₹");
            int bid = sc.nextInt();

            sc.nextLine();

            if (bid < startPrice) {
                System.out.println(
                        "Bid should be at least ₹"
                                + startPrice);
                i--;
                continue;
            }

            bidders.add(
                    new Bidder(name, bid)
            );
        }

        // Additional bidders
        while (true) {

            System.out.print(
                    "\nAnyone else interested? (yes/no): ");

            String choice =
                    sc.nextLine();

            if (choice.equalsIgnoreCase("no")) {
                break;
            }

            System.out.print(
                    "Enter Name: ");
            String name =
                    sc.nextLine();

            System.out.print(
                    "Enter Bid Amount: ₹");

            int bid =
                    sc.nextInt();

            sc.nextLine();

            if (bid < startPrice) {
                System.out.println(
                        "Bid rejected.");
                continue;
            }

            bidders.add(
                    new Bidder(name, bid));

            System.out.println(
                    "Bid Accepted");
        }

        // Find Winner
        Bidder winner =
                bidders.get(0);

        for (Bidder b : bidders) {

            if (b.bid >
                    winner.bid) {

                winner = b;
            }
        }

        System.out.println(
                "\n===== AUCTION RESULT =====");

        System.out.println(
                "Product: " + product);

        System.out.println(
                "Winner: " +
                        winner.name);

        System.out.println(
                "Winning Bid: ₹" +
                        winner.bid);

        System.out.println(
                "\n" +
                wishes[
                        random.nextInt(
                                wishes.length
                        )
                ]
        );

        sc.close();
    }
}