public class AddFactory implements IFactory{
    @Override
    public Operation createOpertation() {
        return new OpertationAdd();
    }
}
