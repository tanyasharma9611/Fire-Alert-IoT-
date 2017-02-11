float temp;
int tempPin = 1;
int temp2=0;
int ledPin=5;
int x=1;  

void setup()
{
Serial.begin(9600);
pinMode(ledPin,OUTPUT);
}
void loop()
{
temp=analogRead(tempPin);

if(x==1)
  digitalWrite(ledPin,HIGH);
else
  digitalWrite(ledPin,LOW);
  
temp2=(int)temp;

if(temp2>=70)
{
  Serial.println(temp2);
  x=0;
}
delay(600);
}
