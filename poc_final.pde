import processing.serial.*;
Serial port;

void setup()  
{

   /* This part must be altered to fit your local settings. The number in brackets after "Serial.list()" is where you declare what COM port your Arduino is connected to.
      If you get error messages, try a different number starting from 0 (e.g. 0, 1, 2, 3...) . */
    port = new Serial(this, "/dev/ttyACM0", 9600);  // Open the port that the Arduino board is connected to, at 9600 baud
}
 
 
 void draw() 
 {
  while (port.available() > 0) 
  {
    String inBuffer = port.readString();
    if (inBuffer != null) 
    {
      String s[]={"1"};
      println("stoping...");
      saveStrings("/var/www/html/output.txt",s);
      
      delay(100);
      s[0]="0";
      saveStrings("/var/www/html/output.txt",s);
    }
    
     
    
  }
  
  
}
 
 