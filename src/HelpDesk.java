//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: HelpDesk
// Files:
// Course: CS 300, spring, and 2019
//
// Author: Sheriff Issaka
// Email: issaka@wisc.edu
// Lecturer's Name: Gary Dahl
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name: (name of your pair programming partner)
// Partner Email: (email address of your programming partner)
// Partner Lecturer's Name: (name of your partner's lecturer)
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// ___ Write-up states that pair programming is allowed for this assignment.
// ___ We have both read and understand the course Pair Programming Policy.
// ___ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully
// acknowledge and credit those sources of help here. Instructors and TAs do
// not need to be credited here, but tutors, friends, relatives, room mates,
// strangers, and others do. If you received no outside help from either type
// of source, then please explicitly indicate NONE.
//
// Persons: NONE
// Online Sources: NONE
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////
/**
 * @author Sheriff
 *
 */
public class HelpDesk implements HelpDeskInterface {
  // zero-indexed max-heap
  protected SupportTicket[] array;
  // instance of size of array
  protected int size;

  /**
   * @param capacity sets size of array/ heap
   */
  public HelpDesk(int capacity) {
    // setting capacity of array/ heap
    array = new SupportTicket[capacity];
    // size is empty so zero
    this.size = 0;
  }


  /**
   * @param index
   * @return int value Given an index into the heap array, this method returns that index's parent
   *         index.
   */
  protected static int parentOf(int index) {
    // finding and returning the parent
    return (index - 1) / 2;

  }

  /**
   * @param index
   * @return left child Given an index into the heap array, this method returns that index's left
   *         child index.
   * 
   */
  protected static int leftChildOf(int index) {
    // finding and returning the left child
    return (index * 2) + 1;

  }

  /**
   * @param index
   * @return right child Given an index into the heap array, this method returns that index's right
   *         child index.
   */
  protected static int rightChildOf(int index) {
    // finding and returning the right child given an index
    return (index * 2) + 2;

  }

  /**
   * @param indexA
   * @param indexB Given two indexes into the heap array, this method swaps the SupportTickets at
   *               those indexes.
   */
  protected void swap(int indexA, int indexB) {
    SupportTicket tempo;
    // holding temporary value
    tempo = array[indexA];
    // swapping value
    array[indexA] = array[indexB];
    // reassigning
    array[indexB] = tempo;
  }

  /**
   * @param index Given an index into the heap array, this method recursively swaps any
   *              SupportTickets necessary to enforce the heap's order property between this index
   *              and the heap's root.
   */
  protected void propagateUp(int index) {
    // comparing to find length
    if (index > 0 && array[index].compareTo(array[parentOf(index)]) > 0) {
      // swapping
      swap(index, parentOf(index));
      // making a recursive call
      propagateUp(parentOf(index));
    }
  }

  /**
   * @param index Given an index into the heap array, this method recursively swaps any
   *              SupportTickets necessary to enforce the heap's order property between this index
   *              and it's children. propagating down
   */
  protected void propagateDown(int index) {
    // holding a specific index
    int bigChildIndex = index;
    // making sure left child isn't the last value in the tree
    if (leftChildOf(index) < size) {
      // making sure right child exists
      if (rightChildOf(index) > size) {
        swap(bigChildIndex, leftChildOf(index));
        // assigning big child index with left child index
        bigChildIndex = leftChildOf(index);
      } else {
        // determining the bigger child and assign big child index with its index
        if (array[leftChildOf(index)].compareTo(array[rightChildOf(index)]) > 0) {
          // big child index either takes the left value
          bigChildIndex = leftChildOf(index);
        } else {
          // or the right value
          bigChildIndex = rightChildOf(index);
        }

      }
      // comparing the index with the element at the big child index and deciding to swap or not
      // if it's less than the big child, then
      if (array[index].compareTo(array[bigChildIndex]) < 0) {
        // swap index with big child
        swap(index, bigChildIndex);
        // and make another recursive call
        propagateDown(bigChildIndex);
      }

    }

  }


  /**
   * Creates and adds a new SupportTicket to this HelpDesk.
   * 
   * @param message names the client and describes their need for support.
   * @throws NullPointerException      when the String message argument is null.
   * @throws IndexOutOfBoundsException when called on HelpDesk with a full array
   */
  @Override
  public void createNewTicket(String message) {
    if (message == null) {
      // throwing an exceptions if it's null
      throw new NullPointerException();
    } else if (array.length == size) {
      // if it's full throw an exception
      throw new IndexOutOfBoundsException();
    } else {
      // creating a new support ticket
      SupportTicket s1 = new SupportTicket(message);
      array[size++] = s1;
      // propagating up
      propagateUp(size - 1);
    }
  }

  /**
   * Returns the message within this HelpDesk that has the highest priority. This method does not
   * change the state of this HelpDesk.
   * 
   * @return the message within the highest priority SupportTicket.
   * @throws IllegalStateException when called on a HelpDesk with zero SupportTickets.
   */
  @Override
  public String checkNextTicket() {
    if (size == 0) {
      // throwing ecxeption is size is zero
      throw new IllegalStateException();
    } else {
      // returnig the string reperserntation
      return array[0].toString();
    }
  }

  /**
   * Returns and removes the message within this HelpDesk that has the highest priority.
   * 
   * @return the message within the highest priority SupportTicket (prior to its removal).
   * @throws IllegalStateException when called on a HelpDesk with zero SupportTickets.
   */
  @Override
  public String closeNextTicket() {
    int strL = 0;
    String copyMess = "";
    if (array.length == 0) {
      // throwing exception if length is null
      throw new IllegalStateException();
    } else {
      // copying messages
      for (int i = 0; i < size; i++) {
        strL = array[0].toString().length();
        copyMess = array[0].toString();
        if (array[i].toString().length() > strL) {
          strL = array[i].toString().length();
          copyMess = array[i].toString();
        }
      }
      // returning messages
      return copyMess;
    }
  }
}
