import java.util.*;

public class TransitCalculator{

  int days,rides;
	  String[] name = {"Pay-per-ride", "7-day Unlimited Rides", "30-day Unlimited Rides"};
	  double[] fare = {2.75, 33.00, 127.00};

	  public TransitCalculator(int ndays,int nrides){
	    days = ndays;
	    rides = nrides;
	  }

	  public double unlimited7Price(){

	    double weeks = Math.ceil(days/7.0);
	    double cost = weeks*fare[1];
	    return cost/rides;

	  }

	  public double[] getRidePrices() {

      double ppr = fare[0];
      double unlimited7Price = unlimited7Price();
      double unlimited30Price = fare[2]/rides;
      double[] prices = {ppr, unlimited7Price, unlimited30Price};
		  return prices;

	  }

    public String getBestFare(){

      double[] ridePrices = getRidePrices();
      int winningIndex = 0;

        for (int i = 0; i < ridePrices.length; i++) {
            if (ridePrices[i] < ridePrices[winningIndex]){
                winningIndex = i;
            }
        }
        return "You should get the " + name[winningIndex] + " option at $" + Math.round(ridePrices[winningIndex] * 100.0) / 100.0 + " per ride.";
    }

    public static void main(String[] args) {

      Scanner in = new Scanner(System.in);
      System.out.print("Enter no. of days: ");
       int ndays = in.nextInt();
       System.out.print("Enter no. of rides: ");
       int nrides = in.nextInt();
       TransitCalculator in = new TransitCalculator(ndays, nrides);
       System.out.println(in.getBestFare());
      
    
  }
}
