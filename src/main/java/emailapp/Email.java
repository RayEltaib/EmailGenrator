package emailapp;

import java.util.Scanner;

public class Email {

    private final String firstName;
    private final String lastName;
    private final String email;
    private StringBuilder password;
    private final String department;
    private int mailBoxCapacity = 1500;
    private String alternateEmail;
    private final String companySuffix = "Karmakool";

    private String result = "";
    private final String selectDep = "Department Codes" +
            "\n1 for Sales" +
            "\n2 for Development" +
            "\n3 for Accounting" +
            "\n0 for none" +
            "\nEnter the department code:";
    private final String errorMessage = "Invalid selection please try again: \n"+ selectDep;



    //Constructor to receive the first name and last name
    public Email(String firstName, String lastName) {

        this.firstName = firstName;
        this.lastName = lastName;

        // Call a method to ask for the department - return department
        if(!setDepartment().equals("")){
            this.department = result;
        }else{
            this.department = setDepartmentAgain();
        }
        System.out.println("Department: " + this.department);

        // Generate email from first other attributes {firstName, .lastName, department, company, .com }
        this.email = this.firstName.toLowerCase().replace(" ", "") + "." +
                     this.lastName.toLowerCase().replace(" ", "") +
                     "@" + department + "." + companySuffix + ".com";
        System.out.println("Your email is: " + this.email);

        // Call a method to set default random password - return password
        this.password = randomPassword(10);
        System.out.println("Your password is: " + this.password);

        // Call a method to print all info
        System.out.println(showInfo());
    }

    //Method to ask for the department
    private String setDepartment() {

        System.out.println(selectDep);
        Scanner input = new Scanner(System.in);
        int depChoice = input.nextInt();

        switch (depChoice) {
                case 1:
                    result = "sales";
                    break;
                case 2:
                    result = "dev";
                    break;
                case 3:
                    result = "acc";
                    break;
                case 0:
                    result = "temp";
                    break;
        }

        return result;

    }

    //Second attempt method to ask for the department
    private String setDepartmentAgain() {

        System.out.println(errorMessage);
        Scanner input = new Scanner(System.in);
        int depChoice = input.nextInt();
        switch (depChoice) {
            case 1:
                result = "sales";
                break;
            case 2:result = "dev";
                break;
            case 3:
                result = "acc";
                break;
            case 0:
                result = "temp";
                break;
        }
        return result;
    }



    // Method to generate secure random password
    private StringBuilder randomPassword(int length) {
        String passwordSet = "!\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^`abcdefghijklmnopqrstuvwxyz{|}~";
        StringBuilder password = new StringBuilder();
        for (int i=0;i<length;i++) {
            int rand = (int)(Math.random() * passwordSet.length());
            password.append(passwordSet.charAt(rand));
        }
        return password;
    }

    // Set the mailbox capacity
    public void setMailBoxCapacity(int mailBoxCapacity) {
        this.mailBoxCapacity = mailBoxCapacity;
    }

    // Set the alternate email
    public void setAlternateEmail(String alternateEmail) { this.alternateEmail = alternateEmail; }

    // Method to change the password
    public void setPassword(StringBuilder password) {
        this.password = password;
    }

    public int getMailBoxCapacity() { return mailBoxCapacity; }
    public String getAlternateEmail() { return alternateEmail; }
    public StringBuilder getPassword() { return password; }

    public String showInfo(){
        return "Display Name: " + this.firstName + " " + this.lastName +
                          "\nCompany Email: " + this.email +
                          "\nMailbox Capacity: " + mailBoxCapacity + "mb";

    }
}
