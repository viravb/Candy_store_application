package com.techelevator.view;

import com.techelevator.Cart;
import com.techelevator.Change;
import com.techelevator.items.CandyStoreItem;

import java.util.Map;
import java.util.Scanner;

/*
 * This is the only class that should have any usage of System.out or System.in
 *
 * Usage of System.in or System.out should not appear ANYWHERE else in your code outside of this class.
 *
 * Work to get input from the user or display output to the user should be done in this class, however, it
 * should include no "work" that is the job of the candy store.
 */
public class Menu {

	private static final Scanner in = new Scanner(System.in);

	public void showWelcomeMessage() {
		System.out.println("***************************");
		System.out.println("**     Silver Shamrock   **");
		System.out.println("**      Candy Company    **");
		System.out.println("***************************");
		System.out.println();
	}

	public void showMainMenu() {
		System.out.println("(1) Show Inventory");
		System.out.println("(2) Make Sale");
		System.out.println("(3) Quit");
	}

	public String getMenuSelection() {
		System.out.println("Select your option: ");
		String mainMenuSelectionByUser = in.nextLine();
		return  mainMenuSelectionByUser;
	}

	public void displayInvalidSelection(){
		System.out.println("Please enter a valid selection");
	}

	public void displayInventoryToUser(Map<String, CandyStoreItem> inventoryMap,
									   Map<String, Integer> inventoryWithQuantity){
		System.out.println("Id      Name                Wrapper  Qty      Price");
		for ( CandyStoreItem candy : inventoryMap.values()) {
			System.out.printf("%-8s%-20s%-9s%-9s$%-4.2f \n",
					candy.getSku() , candy.getName() , candy.isHasWrapper(),
					displayQuantity(inventoryWithQuantity.get(candy.getSku())) , candy.getPrice() );
		}

	}

	private String displayQuantity(Integer num){
		if(num>0){
			return Integer.toString(num);
		}else{
			return "SOLD OUT";
		}

	}

	public void displaySubMenu (double balance){
		System.out.println("(1) Take Money");
		System.out.println("(2) Select Products");
		System.out.println("(3) Complete Sale");
		System.out.printf("Current Customer Balance: $%-4.2f\n", balance);
	}

	public void displayDesiredAmountToDeposit(){
		System.out.println("How much do you want to deposit?: ");
	}

	public double getAmountToDeposit(){
		double amountToDeposit = 0.00;
		String amountFromCustomer = in.nextLine();
		amountToDeposit = Double.parseDouble(amountFromCustomer);
		return amountToDeposit;
	}

	public void displaySkuSelection(){
		System.out.println("Please enter the SKU of desired candy you would like to purchase: ");
	}

	public String getPurchaseSkuSelection(){
		String selection =  in.nextLine();
		return selection.toUpperCase();
	}



	public void displayQuantitySelection(){
		System.out.println("Please enter the quantity of desired candy you would like to purchase: ");
	}



	public void showExceptionMessage(Exception e){
		System.out.println(e.getMessage());
	}

	public void showNumberFormatException(){
		System.out.println("Please enter a valid number");
	}

	public void displayReceipt(Cart finalCart, Map<String,CandyStoreItem> inventoryWProperties, double totalCost, double totalChange, Change change){
		System.out.println("QTY    ITEM NAME          PRODUCT TYPE          PER   TOTAL ");
		for(String sku: finalCart.getCurrentCart().keySet()){
			double lineItemTotal = (inventoryWProperties.get(sku).getPrice() * finalCart.getCurrentCart().get(sku));
			System.out.printf("%-4d%-18s%-25s $%5.2f $%5.2f\n", finalCart.getCurrentCart().get(sku),
					inventoryWProperties.get(sku).getName() ,inventoryWProperties.get(sku).getProductType() ,
					inventoryWProperties.get(sku).getPrice() ,lineItemTotal);
		}
		System.out.printf("\nTotal: $%5.2f\n",totalCost);
		System.out.printf("Change: $%5.2f\n", totalChange);
		if(change.getTwenties() > 0) {
			System.out.print("(" + change.getTwenties() + ")" + "Twenties, ");
		}
		if( change.getTens() >0 ) {
			System.out.print("(" + change.getTens() + ")" + "Tens, ");
		}
		if(change.getFives() > 0) {
			System.out.print("(" + change.getFives() + ")" + "Fives, ");
		}
		if(change.getOnes() > 0 ) {
			System.out.print("(" + change.getOnes() + ")" + "Ones, ");
		}
		if( change.getQuarters() > 0) {
			System.out.print("(" + change.getQuarters() + ")" + "Quarters, ");
		}
		if(change.getDimes() > 0){
		System.out.print("("+ change.getDimes()+ ")" + "Dimes, ");
		}
		if (change.getNickels() > 0) {
			System.out.print("(" + change.getNickels() + ")" + "nickels");
		}
		System.out.println(" ");

	}

}