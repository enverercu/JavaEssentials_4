package Design.Strategy;

interface Strategy {
    public int doOperation(int num1, int num2);
}

class Context {
    private Strategy strategy;//INTERFACE INJECTION

    public Context(Strategy strategy){ //CONSTRUCTOR INJECTION
        this.strategy = strategy;
    }

    public int executeStrategy(int num1, int num2){
        return strategy.doOperation(num1, num2);
    }
}

class OperationAdd implements Strategy{
    @Override
    public int doOperation(int num1, int num2) {
        return num1 + num2;
    }
}

class OperationSubstract implements Strategy{
    @Override
    public int doOperation(int num1, int num2) {
        return num1 - num2;
    }
}

public class StrategyPatternDemo {
    public static void main(String[] args) {
    	
        Context context = new Context(new OperationAdd());
        System.out.println("10 + 5 = " + context.executeStrategy(10, 5));

        context = new Context(new OperationSubstract());
        System.out.println("10 - 5 = " + context.executeStrategy(10, 5));

    }
}
