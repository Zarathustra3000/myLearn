public class Loader {
    public static void main(String[] args)  {

       MyAccount myAccount = LoadStaffFromFile.loadStaffFromFile(args[0]);
       myAccount.printMyAccount();

       System.out.println("\n===========================\n");

       MyAccount myAccount1 = LoadStaffFromFileVersionTwo.loadStaffFromFileVersionTwo(args[0]);
       myAccount1.printMyAccount();

       System.out.println("\n===========================\n");

       MyAccount myAccount2 = LoadStaffFromFileVersionThree.loadStaffFromFileVersionThree(args[0]);
       myAccount2.printMyAccount();
    }

}
