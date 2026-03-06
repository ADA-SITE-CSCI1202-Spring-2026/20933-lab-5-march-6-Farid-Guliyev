interface EvalInterface {
    double toValue();
    String toString();
}

// Operand class
class Operand implements EvalInterface {
    private double value;
    private String label;

    public Operand(String label, double value) {
        this.label = label;
        this.value = value;
    }

    @Override
    public double toValue() {
        return value;
    }

    @Override
    public String toString() {
        return label;
    }
}

// Abstract BinaryOperation
abstract class BinaryOperation implements EvalInterface {
    protected EvalInterface op1, op2;
    protected String label;

    public BinaryOperation(String label, EvalInterface op1, EvalInterface op2) {
        this.label = label;
        this.op1 = op1;
        this.op2 = op2;
    }

    protected abstract double calculate(EvalInterface op1, EvalInterface op2);

    @Override
    public double toValue() {
        return calculate(op1, op2);
    }

    @Override
    public String toString() {
        return "(" + op1.toString() + " " + label + " " + op2.toString() + ")";
    }
}

// Concrete Binary Operations
class Sum extends BinaryOperation {
    public Sum(EvalInterface op1, EvalInterface op2) {
        super("+", op1, op2);
    }

    @Override
    protected double calculate(EvalInterface op1, EvalInterface op2) {
        return op1.toValue() + op2.toValue();
    }
}

class Subtr extends BinaryOperation {
    public Subtr(EvalInterface op1, EvalInterface op2) {
        super("-", op1, op2);
    }

    @Override
    protected double calculate(EvalInterface op1, EvalInterface op2) {
        return op1.toValue() - op2.toValue();
    }
}

class Mult extends BinaryOperation {
    public Mult(EvalInterface op1, EvalInterface op2) {
        super("*", op1, op2);
    }

    @Override
    protected double calculate(EvalInterface op1, EvalInterface op2) {
        return op1.toValue() * op2.toValue();
    }
}

class Div extends BinaryOperation {
    public Div(EvalInterface op1, EvalInterface op2) {
        super("/", op1, op2);
    }

    @Override
    protected double calculate(EvalInterface op1, EvalInterface op2) {
        return op1.toValue() / op2.toValue();
    }
}

// Abstract UnaryOperation
abstract class UnaryOperation implements EvalInterface {
    protected EvalInterface op;
    protected String label;

    public UnaryOperation(String label, EvalInterface op) {
        this.label = label;
        this.op = op;
    }

    protected abstract double calculate(EvalInterface op);

    @Override
    public double toValue() {
        return calculate(op);
    }

    @Override
    public String toString() {
        return label + "(" + op.toString() + ")";
    }
}

// Concrete Unary Operations
class SquareRoot extends UnaryOperation {
    public SquareRoot(EvalInterface op) {
        super("√", op);
    }

    @Override
    protected double calculate(EvalInterface op) {
        return Math.sqrt(op.toValue());
    }
}

class Factorial extends UnaryOperation {
    public Factorial(EvalInterface op) {
        super("!", op);
    }

    @Override
    protected double calculate(EvalInterface op) {
        int n = (int) op.toValue();
        int result = 1;
        for (int i = 1; i <= n; i++) result *= i;
        return result;
    }
}

// Test class
public class TestArithmeticOperations {
    public static void main(String[] args) {
        Operand x = new Operand("x", 5);
        Operand y = new Operand("y", 15);
        Operand z = new Operand("z", 3);

        // Binary operations
        Sum s = new Sum(x, y);
        Subtr sub = new Subtr(y, z);
        Mult mult = new Mult(x, z);
        Div div = new Div(y, x);

        System.out.println(s.toString() + " = " + s.toValue());
        System.out.println(sub.toString() + " = " + sub.toValue());
        System.out.println(mult.toString() + " = " + mult.toValue());
        System.out.println(div.toString() + " = " + div.toValue());

        // Nested binary operations
        Sum nested = new Sum(new Sum(x, y), z);
        System.out.println(nested.toString() + " = " + nested.toValue());

        // Unary operations
        SquareRoot sqrtOp = new SquareRoot(y);
        Factorial factOp = new Factorial(z);

        System.out.println(sqrtOp.toString() + " = " + sqrtOp.toValue());
        System.out.println(factOp.toString() + " = " + factOp.toValue());
    }
}