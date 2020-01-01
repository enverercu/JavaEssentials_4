package Spring.Bean;


//In this example the result is: Karol even if we set this name only for firstManager object. 
//Its because Spring IoC container created one instance of object. 
//However when we change scope to @Scope("prototype") in Configuration class then result is: 
//null because Spring IoC container creates a new bean instance of the object when request for that bean is made.

//DAO class:
public class Manager {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

//Configuration
@Configuration
public class AppConfiguration {
    @Bean
    @Scope("singleton")
    public Manager getManager(){
        return new Manager();
    }
}

//MainApp
@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("Spring.Bean");
        context.refresh();

        Manager firstManager = context.getBean(Manager.class);
        firstManager.setName("Karol");

        Manager secondManager = context.getBean(Manager.class);
        System.out.println(secondManager.getName());
    }

}