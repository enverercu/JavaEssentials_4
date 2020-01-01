package Spring.InversionOfControl_DependencyInjection;

public interface INotificationService {

	void SendNotification(String phoneNumber, String body);
}
