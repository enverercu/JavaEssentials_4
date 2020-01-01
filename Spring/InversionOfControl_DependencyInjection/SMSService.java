package Spring.InversionOfControl_DependencyInjection;

public class SMSService implements INotificationService
{
    public void SendNotification(String mobileNumber, String body)
    {
        SendSMS(mobileNumber, body);
    }

    private void SendSMS(String mobileNumber, String body)
    {
        /*implementation for sending SMS using gateway*/
        System.out.println("Sending SMS");
    }
}
