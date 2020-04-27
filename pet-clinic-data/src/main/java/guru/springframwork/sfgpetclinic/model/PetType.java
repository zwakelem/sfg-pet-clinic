package guru.springframwork.sfgpetclinic.model;

import java.time.LocalDate;

public class PetType extends BaseEntity {

  private String name;
  private Owner owner;
  private LocalDate birthdate;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Owner getOwner() {
    return owner;
  }

  public void setOwner(Owner owner) {
    this.owner = owner;
  }

  public LocalDate getBirthdate() {
    return birthdate;
  }

  public void setBirthdate(LocalDate birthdate) {
    this.birthdate = birthdate;
  }
}
