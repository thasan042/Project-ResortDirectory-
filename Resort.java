public class Resort {

   private Building[] resortList;
  
   public Resort(int size)
   {
       resortList = new Building[size];
   }
  
   public void setBuilding(int buildingNumber, char buildingName, int size, double price)
   {
       if(buildingNumber >=0 && buildingNumber < resortList.length)
           resortList[buildingNumber] = new Building(buildingName, size, price);
   }
  
   public void rentRoom(char let)
   {
       int num = let - 'A';
       if (num >= 0 && num < resortList.length)
   {
   String x;
   x = resortList[num].rentRoom();
   if (!x.equals("error")) System.out.printf("Room %s was rented out.%n",x);
   else System.out.println("Sorry, no rooms in that building available.");
     
   }
   else System.out.println("Sorry, no building of that letter found.");
   }
  
   public void checkout(String roomName)
   {
       boolean removed = false;
   for (int i = 0; i < resortList.length ; i ++)
   {
   if (resortList[i].checkOut(roomName))
   {
   removed = true;
   }
   }
  
   if (removed) System.out.printf("Room %s was cleared. %n",roomName);
   else System.out.printf("No Room with that name was found.%n");
   }
  
   public void printResortSmallStatus()
   {
       System.out.println("************************************");
   System.out.println("** Quick Status of the Resort");
   for (int i = 0; i < resortList.length ; i ++)
   {
   System.out.println("** " + resortList[i]);
   }
   System.out.println("************************************");
   System.out.print("** ");
   printOccupiedRooms();
   System.out.printf("** The current value of the resort is $%5.2f.%n",getValue(resortList));
   System.out.printf("** There are %4d empty rooms.%n",getEmpty(resortList));
   System.out.println("************************************");
   }
  
   public void printResortLargeStatus()
   {
       System.out.println("**********Expanded Status of the Resort*******");
   for (int i = 0; i < resortList.length ; i ++)
   {
   resortList[i].printCurrentStatus();
   }
   System.out.println("#####");
   System.out.println("#####");
   }
  
   public void printOccupiedRooms()
   {
   System.out.print("The currently occupied rooms are : ");
   for (int i = 0; i < resortList.length ; i ++)
   {
   System.out.print(resortList[i].listOfNonEmpty() );
   }   
   System.out.println();
   }
   public static double getValue(Building[] resortList)
   {
   double val = 0;
   for (int i = 0; i < resortList.length ; i ++)
   {
   val += resortList[i].getValue();
   }
   return val;
   }
  
   public static int getEmpty(Building[] resortList)
   {
   int val = 0;
   for (int i = 0; i < resortList.length ; i ++)
   {
   val += resortList[i].currentEmpty();
   }
   return val;
   }
}