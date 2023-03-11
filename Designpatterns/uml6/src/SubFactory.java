public class SubFactory implements IFactory{
    public Operation createOpertation() {
        return new OpertationSub();
    }
}
