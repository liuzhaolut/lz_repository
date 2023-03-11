package 建造者模式;

public class PersonDirector {
    private PersonBuilder	pb;
    public PersonDirector(PersonBuilder pb)
    {
        this.pb = pb;
    }

    public void createPerson()
    {
       pb.builderhead();
       pb.builderbody();
       pb.builderlhand();
       pb.builderrhand();
       pb.builderlleg();
       pb.builderrleg();
    }
}
