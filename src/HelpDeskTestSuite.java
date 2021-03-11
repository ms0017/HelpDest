import java.util.Arrays;

//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: HelpDeskSuite
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
public class HelpDeskTestSuite {

  /**
   * @return boolean value
   */
  public static boolean supportTicketCompareToTest() {
    // creates a new support ticket
    SupportTicket s1 = new SupportTicket("hello");
    // returning appropriate boolean
    if (s1.compareTo(s1) == 0) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * @return boolean value
   */
  public static boolean supportExceptionTicket() {
    // catching null pointer exception
    try {
      SupportTicket s1 = new SupportTicket(null);
      // exception caught or not and appropriate boolean returned
    } catch (NullPointerException e) {
      return true;
    }
    return false;
  }

  /**
   * @return boolean value
   */
  public static boolean helpExceptionDesk() {
    // catching exception
    try {
      // creating an instance of help desk
      HelpDesk h1 = new HelpDesk(5);
      // setting create ticke to null to expect an exception
      h1.createNewTicket(null);
      // exception caught or not and appropriate boolean returned
    } catch (NullPointerException e) {
      return true;
    }
    return false;
  }

  /**
   * @return boolean value
   */
  public static boolean checkNextExceptionTicket() {
    // catching exception
    try {
      // creating an instance of help desk
      HelpDesk h1 = new HelpDesk(0);
      h1.checkNextTicket();
      // exception caught or not and appropriate boolean returned
    } catch (IllegalStateException e) {
      return true;
    }
    return false;
  }

  /**
   * @return boolean value
   */
  public static boolean closeNextExceptionTicket() {
    // catching exception
    try {
      // creating an instance of help desk
      HelpDesk h1 = new HelpDesk(0);
      h1.closeNextTicket();
      // exception caught or not and appropriate boolean returned
    } catch (IllegalStateException e) {
      return true;
    }
    return false;
  }

  /**
   * @return boolean value
   */
  public static boolean testPropagateUp() {
    // creating an instance of help desk with capacity 10
    HelpDesk h1 = new HelpDesk(10);
    // passing in strings
    String[] s1 = {"Y", "X", "W", "A", "B", "C", "Z"};
    // pushing strings in
    for (int i = 0; i < s1.length; i++) {
      h1.array[i] = new SupportTicket(s1[i]);
    }
    h1.size = s1.length;
    // propagating
    h1.propagateUp(s1.length - 1);
    // expected value
    String[] expected = {"Z", "X", "Y", "A", "B", "C", "W"};
    // comparing and returning right boolean
    for (int i = 0; i < expected.length; i++) {
      if (!expected[i].equals(h1.array[i].toString()))
        return false;
    }
    return true;
  }

  /**
   * @return boolean value
   */
  public static boolean testPropagateDown() {
    // creating an instance of help desk with capacity 10
    HelpDesk h1 = new HelpDesk(10);
    // passing in strings
    String[] s1 = {"A", "W", "X", "D", "B", "C", "Z"};
    for (int i = 0; i < s1.length; i++) {
      // pushing strings in
      h1.array[i] = new SupportTicket(s1[i]);
    }
    h1.size = s1.length;
    // propagating down
    h1.propagateDown(0);
    // expected output
    String[] expected = {"X", "W", "Z", "D", "B", "C", "A"};
    for (int i = 0; i < expected.length; i++) {
      // returning right boolean
      if (!expected[i].equals(h1.array[i].toString()))
        return false;
    }
    return true;
  }

  /**
   * @return boolean value
   */
  public static boolean createNewExceptionTicketSize() {
    // catching exception
    try {
      HelpDesk h1 = new HelpDesk(0);
      // passing in a string
      h1.createNewTicket("hello");
      // catching exception and returning right boolean
    } catch (IndexOutOfBoundsException e) {
      return true;
    }
    return false;
  }



  public static void main(String[] args) {
    // calling support ticket tesr
    if (supportTicketCompareToTest()) {
      System.out.println("supportTicketCompareToTest passed");
    } else {
      System.out.println("supportTicketCompareToTest failed");
    }
    // calling support ticket exception test
    if (supportExceptionTicket()) {
      System.out.println("supportExceptionTicket passed");
    } else {
      System.out.println("supportExceptionTicket failed");
    }
    // calling help ecxeption test
    if (helpExceptionDesk()) {
      System.out.println("helpExceptionDesk passed");
    } else {
      System.out.println("helpExceptionDesk failed");
    }
    // calling check next exception ticket test
    if (checkNextExceptionTicket()) {
      System.out.println("checkNextExceptionTicket passed");
    } else {
      System.out.println("checkNextExceptionTicket failed");
    }
    // calling test propagate up
    if (testPropagateUp()) {
      System.out.println("testPropagateUp passed");
    } else {
      System.out.println("testPropagateUp failed");
    }
    // calling close next exception
    if (closeNextExceptionTicket()) {
      System.out.println("closeNextExceptionTicket passed");
    } else {
      System.out.println("closeNextExceptionTicket failed");
    }
    // calling test propagate down
    if (testPropagateDown()) {
      System.out.println("testPropagateDown passed");
    } else {
      System.out.println("testPropagateDown failed");
    }
    // calling create new exception ticket size
    if (createNewExceptionTicketSize()) {
      System.out.println("createNewExceptionTicketSize passed");
    } else {
      System.out.println("createNewExceptionTicketSize failed");
    }

  }

}
