//Tasnim Hasan, CS 141, Spring 2017, Section A
//Programming Assignment #21. 06/06/2017
//
//This program will give an output of:This is the object that will maintain a particular building. It will have a particular letter designation a size and a array of Rooms based upon the size.
/**
  * This is the object that will maintain a particular building. It will have a particular letter designation a size and a array of Rooms based upon the size.
  * @author Tasnim Hasan
  */
public class Building 
{
   //Fields are private
   private Room[] list;
   private char buildingLetter;
   private int size;
   /**
     * This the constructor it sets the size and building letter, and take in the price per room. 
     * It will also create the array of rooms with the correct size.
     * @param intialBuildingLetter This is the intial building letter it will be inserted into the constructor and set.
     * @param intialSize This is the intial size it will be inserted into the full constructor and set.
     * @param intialPrice This is the intial price it will be inserted into the full constructor and set.
     */
   public Building(char intialBuildingLetter, int intialSize, double intialPrice)
   {
      buildingLetter = intialBuildingLetter;
      size = intialSize;
      list = new Room[size+1];
      for(int i = 1 ;i<size+1;i++)
      {
         list[i] = new Room(intialPrice, i, intialBuildingLetter);
      }
      double price = intialPrice;
   }
   /**
     * This is a toString() method and it will format it to Building (letter) has (size) rooms : (numberemptyroom) empty.
     * @return will return the string in the format of Building (letter) has (size) rooms : (numberemptyroom) empty.
     */
   public String toString()
   {
      return "Building " + ""+buildingLetter + " has " + size + " rooms: (" + ""+currentEmpty() + ") empty";
   }
   /**
     * This is a printCurrentStatus() method and it print out the current status of the building and all of its interior rooms. 
     * @return will return the building which is the variable that holds "Building " + buildingLetter as a String. 
     */
   public String printCurrentStatus()
   {
      String building = ("Building " + buildingLetter);
      System.out.println("Building " + buildingLetter);
      for(int i = 1 ;i<size+1;i++)
      {
         if(list[i].getOccupied()==false)
         {
            System.out.println(" Room "+buildingLetter +list[i]+" : is empty.");
         }
         else if(list[i].getOccupied()==true)
         {
            System.out.println(" Room "+buildingLetter+list[i]+" : is occupied.");
         }
      }
      return building;
   }
   /**
     * This is a getValue()method creates the current double price of all the units that are occupied.  
     * @return will return the current double price of all the units that are occupied. 
     */
   public double getValue()
   {
      double sum = 0;
      for(int i =1 ;i<size+1; i++)
      {
         if(list[i].getOccupied()==true)
         {
            sum += list[i].getCost();
         }
      }
      return sum;
   }
   /**
     * This is a listOfEmpty() method makes a string of all the currently empty rooms for this building. 
     * @return will return a string of all the currently empty rooms for this building.
     */
   public String listOfEmpty()
   {
      String empty = "";
      for(int i = 1; i< size+1; i++)
      {
         if(list[i].getOccupied()==false)
         {
            empty += (list[i].getRoomName() + " ");
         }
      }
      return empty;
   }
   /**
     * This is a listOfNonEmpty() method makes a string of all the currently nonempty  rooms for this building. 
     * @return will return a string of all the currently nonempty  rooms for this building.
     */
   public String listOfNonEmpty()
   {
      String nonEmpty = "";
      for(int i = 1; i< size+1; i++)
      {
         if(list[i].getOccupied()==true)
         {
            nonEmpty +=(list[i].getRoomName() + " ");
         }
      }
      return nonEmpty;
   }
   /**
     * This is a currentEmpty() method generates an integer number of the number of rooms currently empty. 
     * @return will return an integer number which equals the number of rooms currently empty. 
     */
   public int currentEmpty()
   {
      int num = 0;
      for(int i = 1; i< size+1; i++)
      {
         if(list[i].getOccupied()==false)
         {
            num++;
         }
      }
      return num;
   }
   /**
     * This is a  rentRoom() method it is used to check out a room. This method should find the first room in the building that is empty, and set it to occupied.   
     * @return will return the name of the room as a String that is to be given out. 
     */
   public String rentRoom()
   {
      for(int i =1 ; i< size+1; i++)
      {
         if(list[i].getOccupied()==false)
         {
            list[i].rentRoom();
            return list[i].getRoomName();
         }
      }
      return "error";
   }
   /**
     * This is a checkOut()method it is used to show that people have left a particular room. 
     * @param x x is the input value is the name of the room emptied as a string. 
     * @return will return true if the room is found otherwise it will return false. 
     */
   public boolean checkOut(String x)
   {
      boolean give = false;
      if(x.length() == 2 )
      {
         int rNumber = Integer.parseInt(""+x.charAt(1));
         char bName = x.charAt(0);
         if(buildingLetter == bName && rNumber < size+1 && rNumber > 0)
         {
            list[rNumber].emptyRoom();
            give = true;
         }
      }
      return give;
   }  
}