package Design.xMVC.FrontController;

//USER --> CONTROLLER(CREATES)-->DISPATCHER(CREATES) --> VIEW --> CONTROLLER(RETURNS) --> USER

//A view represents and displays information to the client. The view retrieves information from a model
class TeacherView{
	public void display(){
		System.out.println("Teacher View");
	}
}

//A dispatcher is responsible for view management and navigation, 
//managing the choice of the "next view to present" to the user
class Dispatcher{
	private TeacherView teacherView;
	
	public Dispatcher(){
		teacherView = new TeacherView();
	}
	
	//PRESENT NEXT VIEW
	public void dispatch(String request){
		if(request.equalsIgnoreCase("Teacher")) 
        { 
			teacherView.display(); 
        } 
	}
	
}
//The controller is the initial contact point for handling all requests in the system
//CALLS DISPATCHER
class FrontController{
	
	private Dispatcher dispatcher;
	
	public FrontController(){
		dispatcher = new Dispatcher();
	}
	
	public void dispatchRequest(String request){
		
		dispatcher.dispatch(request);
		
	}
}

public class AAFrontController {

	public static void main(String[] args) {
		
		FrontController frontController = new FrontController(); 
        frontController.dispatchRequest("Teacher"); 
	}

}
