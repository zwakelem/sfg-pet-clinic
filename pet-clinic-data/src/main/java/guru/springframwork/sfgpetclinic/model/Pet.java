package guru.springframwork.sfgpetclinic.model;

public class Pet extends BaseEntity {

  private PetType name;

  public PetType getName() {
    return name;
  }

  public void setName(PetType name) {
    this.name = name;
  }
}
