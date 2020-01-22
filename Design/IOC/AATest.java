package Design.IOC;

interface INotification{
	void sendNotification(String message);
}
class SMS implements INotification{
	@Override
	public void sendNotification(String message){
		System.out.println("SMS message : " + message);
	}
}
class EMAIL implements INotification{
	@Override
	public void sendNotification(String message){
		System.out.println("Email message : " + message);
	}
}
class NotificationService{
	private INotification notification;
	public NotificationService(INotification notification){
		this.notification = notification;
	}
	public void sendNotification(String message){
		this.notification.sendNotification(message);
	}
}
public class AATest {

	public static void main(String[] args) {
		
		INotification sms = new SMS();
		NotificationService service = new NotificationService(sms);
		service.sendNotification("### new message ###");
		
		service = new NotificationService(new EMAIL()); //client decides the control. inversion of control.
		service.sendNotification("<HTM>");

	}

}
