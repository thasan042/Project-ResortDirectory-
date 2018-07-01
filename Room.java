//Tasnim Hasan, CS 141, Spring 2017, Section A
//Programming Assignment #21. 06/06/2017
//
//This program will give an output of:The Room class is how we manage a single room
/**
  * This program will make the Room class and it is how we manage a single room.
  * @author Tasnim Hasan
  */
public class Room 
{
   //fields are private
   private double cost;
   private int roomNumber;
   boolean occupied;
   char building;
   /**
     * This the constructor it  set the room letter, the room number and the cost of the room into their respective fields.
     * Also will make sure the room is initially not occupied.
     * @param intialCost This is the intial cost it will be inserted into the constructor and set.
     * @param intialRoomNumber This is the intial room number it will be inserted into the full constructor and set.
     * @param intialBuilding This is the intial building it will be inserted into the full constructor and set.
     */
   public Room(double intialCost, int intialRoomNumber, char intialBuilding) 
   {
      cost = intialCost;
      roomNumber = intialRoomNumber;
      building = intialBuilding;
      occupied = false;
   }
   /**
     * This is a getRoomName() method and it will make a string from the building letter and the room number.
     * @return will return the string that the method created (building letter and the room number).
     */
   public String getRoomName()
   {
      return ""+building + ""+roomNumber;
   }
   /**
     * This is a toString() method and it will show the room number and the current status of the room in the format Room (roomname) : is (status).
     * @return will return the string in the format Room (roomname) : is (status).
     */
   public String toString() 
   {
      if(occupied)
      {
         return "Room " + getRoomName()+ " : is occupied";     
      }
      else
      {
         return "Room " + getRoomName()+ " : is empty";
      }
   }
   /**
     * This is a rentRoom() method and it will set the room to be occupied.
     */
   public void rentRoom()
   {
      occupied = true;
   }
   /**
     * This is a emptyRoom() method and it will set the room to be empty.
     */
   public void emptyRoom()
   {
      occupied = false;
   }
   /**
     * This is a getOccupied() method and it will return the occupied.
     * @return will return occupied.
     */
   public boolean getOccupied() 
   {
      return occupied;
   }
    /**
     * This is a getCost() method and it will return the cost.
     * @return will return cost.
     */
   public double getCost() 
   {
      return cost;
   }
}