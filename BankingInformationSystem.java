import javax.swing.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;

public class BankingInformationSystem {

    static String name;
    static String address;
    static String phone;
    static String password;

    static int accountNumber;
    static double balance;

    static int transactionCount = 0;

    static LocalDateTime loginTime;

    static ArrayList<String> statement = new ArrayList<>();

    public static void main(String[] args) {

        loginTime = LocalDateTime.now();

        JOptionPane.showMessageDialog(null,
                "WELCOME TO BANKING INFORMATION SYSTEM");

        registerUser();

        while (true) {

            String choice = JOptionPane.showInputDialog(

                    "========= BANK MENU =========\n\n"

                            + "1. Account Details\n"

                            + "2. Update Account\n"

                            + "3. Deposit\n"

                            + "4. Withdraw\n"

                            + "5. Fund Transfer\n"

                            + "6. Account Statement\n"

                            + "7. Change Password\n"

                            + "8. Dashboard\n"

                            + "9. Logout\n\n"

                            + "Enter Choice");

            if (choice == null)
                break;

            switch (choice) {

                case "1":

                    accountDetails();

                    break;

                case "2":

                    updateAccount();

                    break;

                case "3":

                    deposit();

                    break;

                case "4":

                    withdraw();

                    break;

                case "5":

                    fundTransfer();

                    break;

                case "6":

                    accountStatement();

                    break;

                case "7":

                    changePassword();

                    break;

                case "8":

                    dashboard();

                    break;

                case "9":

                    logout();

                    break;

                default:

                    JOptionPane.showMessageDialog(null,
                            "Invalid Choice");

            }

        }

    }

    static void registerUser() {

        name = JOptionPane.showInputDialog("Enter Name");

        address = JOptionPane.showInputDialog("Enter Address");

        phone = JOptionPane.showInputDialog("Enter Phone Number");

        password = JOptionPane.showInputDialog("Create Password");

        balance = Double.parseDouble(

                JOptionPane.showInputDialog(

                        "Initial Deposit Amount"));

        Random random = new Random();

        accountNumber = 100000 + random.nextInt(900000);

        statement.add("Account Created : ₹" + balance);

        JOptionPane.showMessageDialog(null,

                "Registration Successful\n\n"

                        + "Account Number : "

                        + accountNumber);

    }

    static void accountDetails() {

        String details =

                "Name : " + name +

                        "\nAccount Number : " + accountNumber +

                        "\nAddress : " + address +

                        "\nPhone : " + phone +

                        "\nBalance : ₹" + balance;

        JOptionPane.showMessageDialog(null, details);

    }

    static void updateAccount() {

        name = JOptionPane.showInputDialog(

                "Update Name", name);

        address = JOptionPane.showInputDialog(

                "Update Address", address);

        phone = JOptionPane.showInputDialog(

                "Update Phone", phone);

        JOptionPane.showMessageDialog(null,

                "Account Updated Successfully");

    }

    static void deposit() {

        try {

            double amount = Double.parseDouble(

                    JOptionPane.showInputDialog(

                            "Enter Deposit Amount"));

            if (amount <= 0) {

                JOptionPane.showMessageDialog(null,

                        "Invalid Amount");

                return;

            }

            balance += amount;

            transactionCount++;

            statement.add("Deposit : ₹" + amount);

            JOptionPane.showMessageDialog(null,

                    "Deposit Successful\n"

                            + "Balance : ₹" + balance);

        }

        catch (Exception e) {

            JOptionPane.showMessageDialog(null,

                    "Enter Valid Amount");

        }

    }

    static void withdraw() {

        try {

            double amount = Double.parseDouble(

                    JOptionPane.showInputDialog(

                            "Enter Withdraw Amount"));

            if (amount > balance) {

                JOptionPane.showMessageDialog(null,

                        "Insufficient Balance");

                return;

            }

            balance -= amount;

            transactionCount++;

            statement.add("Withdraw : ₹" + amount);

            JOptionPane.showMessageDialog(null,

                    "Withdraw Successful\n"

                            + "Balance : ₹" + balance);

        }

        catch (Exception e) {

            JOptionPane.showMessageDialog(null,

                    "Enter Valid Amount");

        }

    }

    static void fundTransfer() {

        try {

            String receiver = JOptionPane.showInputDialog(

                    "Enter Receiver Account Number");

            double amount = Double.parseDouble(

                    JOptionPane.showInputDialog(

                            "Enter Transfer Amount"));

            if (amount > balance) {

                JOptionPane.showMessageDialog(null,

                        "Insufficient Balance");

                return;

            }

            balance -= amount;

            transactionCount++;

            statement.add("Transfer To "

                    + receiver

                    + " : ₹"

                    + amount);

            JOptionPane.showMessageDialog(null,

                    "Transfer Successful");

        }

        catch (Exception e) {

            JOptionPane.showMessageDialog(null,

                    "Invalid Input");

        }

    }

    static void accountStatement() {

        String data = "";

        for (String s : statement) {

            data += s + "\n";

        }

        data += "\n\nCurrent Balance : ₹"

                + balance;

        JOptionPane.showMessageDialog(null,

                data);

    }

    static void changePassword() {

        String oldPassword = JOptionPane.showInputDialog(

                "Enter Old Password");

        if (oldPassword.equals(password)) {

            password = JOptionPane.showInputDialog(

                    "Enter New Password");

            JOptionPane.showMessageDialog(null,

                    "Password Updated");

        }

        else {

            JOptionPane.showMessageDialog(null,

                    "Wrong Password");

        }

    }

    static void dashboard() {

        String data =

                "===== DASHBOARD =====\n\n"

                        + "Name : " + name

                        + "\nAccount Number : "

                        + accountNumber

                        + "\nBalance : ₹"

                        + balance

                        + "\nTransactions : "

                        + transactionCount

                        + "\nLogin Time : "

                        + loginTime;

        JOptionPane.showMessageDialog(null,

                data);

    }

    static void logout() {

        JOptionPane.showMessageDialog(null,

                "Logout Successful\n"

                        + "Thank You");

        System.exit(0);

    }

}