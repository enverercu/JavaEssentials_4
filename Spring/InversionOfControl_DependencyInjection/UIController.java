package Spring.InversionOfControl_DependencyInjection;

public class UIController {

	 	private INotificationService notificationService;

	 	//constructor injection
	    public UIController(INotificationService notificationService)
	    {
	    	this.notificationService = notificationService;
	    }

	    public void SendConfirmationMsg(String mobileNumber)
	    {
	    	notificationService.SendNotification(mobileNumber, "Your order has been shipped successfully!");
	    }
}
