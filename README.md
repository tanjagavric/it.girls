## Payten Hackathon Vol2 - IT girls

Application developed for Point of Sale Andorid device. It can easily be adapted for self-service checkouts.

Technology used: Java, RoomDatabase

Development environment: Android Studio.

### About Application

<img src="img/logo.png" align="right" width="120" height="120"/>

This is a humanitarian application whose primary usage is to connect customers and humanitarian organisations. Our application starts at the PoS device, after completing the payment transaction. 

At the beginning, customer is asked whether they would like to donate money for charity or not. There are suggested charities, as well as an option to choose from the drop down menu, where all charities from the database are listed.

If they opt for "No(NE)" their shopping is over. 
On the other hand, if they proceed with donation they have an option to choose between suggested amounts or to type in their own amount. 

After pressing "Pay(Plati)" button they can pay. PoS device will immediately print a desgined receipt with QR code that leads to the website page of the charity that money is being donated to. In this way customers are able to track work of that charity and the impact that their donation has.

![app and receipt](/img/app_and_receipt.png) 
![app and website](/img/app_and_website.png) 

### Technical Details

The following diagram displays the sequence of events:
![transaction description](/img/transaction_description.png) 

