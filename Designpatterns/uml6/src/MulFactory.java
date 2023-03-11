public class MulFactory implements IFactory{
    public Operation createOpertation() {
        return new OpertationMul();
    }
}
