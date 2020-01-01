package Spring.InversionOfControl_DependencyInjection;

public class EmailService implements INotificationService
{
    public void SendNotification(String mobileNumber, String body)
    {
        SendEmail(mobileNumber, body);
    }

    private void SendEmail(String mobileNumber, String body)
    {
        /*implementation for sending SMS using gateway*/
        System.out.println("Sending Email");
    }
}
