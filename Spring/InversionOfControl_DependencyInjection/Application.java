package Spring.InversionOfControl_DependencyInjection;

public class Application {

	public static void main(String[] args) {
		
		INotificationService notificationService = new SMSService(); // dependency

        UIController uIController = new UIController(notificationService);
        uIController.SendConfirmationMsg("96279544480");


	}

}
