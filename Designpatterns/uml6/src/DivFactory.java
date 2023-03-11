public class DivFactory implements IFactory{
    public Operation createOpertation() {
        return new OpertationDiv();
    }
}
