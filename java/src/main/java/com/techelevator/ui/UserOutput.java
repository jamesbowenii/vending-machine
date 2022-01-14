package com.techelevator.ui;

import com.techelevator.models.VendingMachineItem;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;


/**
 * Responsibilities: This class should handle formatting and displaying ALL
 * messages to the user
 * 
 * Dependencies: None
 */
public class UserOutput
{

    public static void displayMessage(String message)
    {
        System.out.println();
        System.out.println(message);
        System.out.println();
    }

    public static void displayHomeScreen()
    {
        System.out.println();
        System.out.println("***************************************************");
        System.out.println("                      Home");
        System.out.println("***************************************************");
        System.out.println();
    }

    public static void displayList(List<VendingMachineItem> vendingMachineItemList) {
        for (VendingMachineItem item : vendingMachineItemList) {
            if (item.getStockAmount() > 0) {
                System.out.printf("%-10s %-20s %2s %1.2f %8s %10s\n", item.getPosition(),
                        item.getProductName(), "$", item.getPrice(), item.getStockAmount(), "Available");

            } else {
                System.out.printf("%-10s %-20s %2s %1.2f %15s\n", item.getPosition(),
                        item.getProductName(), "$", item.getPrice(), "SOLD OUT");
            }
        }
    }

    public static BigDecimal getChange(BigDecimal currentMoney) {

        BigDecimal zero = new BigDecimal(0);
        if (currentMoney.compareTo(zero) == 1) {

            int quarterCounter = 0;
            for (BigDecimal i = new BigDecimal("0.25"); i.compareTo(currentMoney) <= 0;
                 currentMoney = currentMoney.subtract(i)) {
                quarterCounter += 1;
            }
            int dimeCounter = 0;
            for (BigDecimal j = new BigDecimal("0.10"); j.compareTo(currentMoney) <= 0;
                 currentMoney = currentMoney.subtract(j)) {
                dimeCounter += 1;
            }
            int nickelCounter = 0;
            for (BigDecimal k = new BigDecimal("0.05"); k.compareTo(currentMoney) <= 0;
                 currentMoney = currentMoney.subtract(k)) {
                nickelCounter += 1;
            }

            String yourChange = "Your change is " + quarterCounter + " quarters, " + dimeCounter +
                    " dimes, and " + nickelCounter + " nickels";
            System.out.println(yourChange);
        } else {
            System.out.println("You have no change. Thank you.");
        }

        return currentMoney;

    }

    public static String getLocalDateTime(){
       DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
       LocalDate localDate = LocalDate.now();
       String dateString = dateFormatter.format(localDate);


       DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh:mm:ss a");
        LocalTime localTime = LocalTime.now();
        String timeString = timeFormatter.format(localTime);

        return dateString + " " + timeString;
    }

    public static String getSalesDateTime(){
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MMddyyyy");
        LocalDate localDate = LocalDate.now();
        String dateString = dateFormatter.format(localDate);


        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hhmmssa");
        LocalTime localTime = LocalTime.now();
        String timeString = timeFormatter.format(localTime);

        return dateString + timeString;

    }

}
