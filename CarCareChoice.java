//Car Care App page 409
import javax.swing.JOptionPane;

public class CarCareChoice
{
	public static void main(String[] args) 
	{
		//Variables and Constants
		String[] services = {"Oil Change", "Tire Rotation", "Battery Check", "Brake Inspection"};
		double[] prices = {25.00, 22.00, 15.00, 5.00};
		int matchIndex = 0; //This matches the index between the two arrays, this will hold the value
		boolean isMatch = false;
		int keepTrying = 0;  //This will stopus for having an error message for each service in the loop
		String selection = "";

		//do...while loop (we want the menu to appear at least once!)
		do
		{
			//Input phase
			selection = JOptionPane.showInputDialog(null, "Please type the name of the service to see it's price: \nOil Change \nTire Rotation \nBattery Check \nBrake Inspection");
			//Loop though all the services looking for a match
			for(int x = 0; x < services.length; ++x)
			{
				//Check to see if we have a match
				if(selection.substring(0, 3).equalsIgnoreCase(services[x].substring(0, 3))) //Checks first 3 characters from user imput, comparing to 3 characters in the array
				{
					isMatch = true;
					matchIndex = x; //This links the arrays, x represents which array the counter stopped
					JOptionPane.showMessageDialog(null, "You selected " + services[matchIndex] + "\nThe price for that service is $" + String.format("%.2f", prices[matchIndex]));
					//Early exit from the loop, push to the highest value so it doesnt keep looping
					x = services.length; //originally x needed to be LESS THAN, to run the loop
				}
				else
				{
					++keepTrying;
					if(keepTrying == services.length)
					{
						JOptionPane.showMessageDialog(null, "Sorry no selection found!");
					}
				}
			}

		}
		while(isMatch == false);
	}
}