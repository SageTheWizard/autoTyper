import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;

public class autoTyper
{
   public static void main(String[] args)
   {
      String text;
	  char goAgain;
      int timeOfSpam;
      int delayTime;
          
      Scanner keyboard = new Scanner(System.in);
      
	  do 
	  {
	  	System.out.println("Jacob's really bad autotyper - CMD Edition!\n");
      	System.out.print("Input text you wish to be spammed: ");
      	text = keyboard.nextLine();
      	System.out.print("Enter number of times the text will be spammed: ");
      	timeOfSpam = keyboard.nextInt();
      	keyboard.nextLine();
      	System.out.print("Enter Delay between each spam message (in ms): ");
      	delayTime = keyboard.nextInt();
      	keyboard.nextLine();
      
        System.out.println("Spam will begin upon pressing enter!");
      	keyboard.nextLine();
      
      	beginSpam(text, timeOfSpam, delayTime);
		System.out.print("Would you like to go again?(Y/N): ");
	    do 
		{	
			goAgain = ((keyboard.nextLine()).toUpperCase()).charAt(0);
			if ((goAgain != 'Y') & (goAgain != 'N'));
				System.out.print("Please Enter Y(es) or N(o): "); 
		}while ((goAgain != 'Y') & (goAgain != 'N'));
      } while (goAgain == 'Y');
	  System.exit(0);
    }
    
    private static void beginSpam(String spamText, int timeOfSpam, int delayTime)
    {
      try
      {
         Robot spamBoi = new Robot();
         int keycode;
         System.out.println("Get Ready.. Spamming will start in 5 seconds!");
         spamBoi.delay(5000);
         
         for (int i = 0; i < timeOfSpam; i++)
         {
            for (int j = 0; j < spamText.length(); j++)
            {
               keycode = KeyEvent.getExtendedKeyCodeForChar(spamText.charAt(j));
               if ((Character.isLetter(spamText.charAt(j)) && (Character.isUpperCase(spamText.charAt(j)))))
                  spamBoi.keyPress(KeyEvent.VK_SHIFT);
               spamBoi.keyPress(keycode);
               spamBoi.keyRelease(KeyEvent.VK_SHIFT);
               spamBoi.keyRelease(keycode);
            }
            spamBoi.keyPress(KeyEvent.VK_ENTER);
            spamBoi.keyRelease(KeyEvent.VK_ENTER);
            spamBoi.delay(delayTime);
         }
      }
      catch(Exception e)
      {
         System.out.println("Something broke I'm sorry");
      }
    }
}  
         
       
      
      
      
