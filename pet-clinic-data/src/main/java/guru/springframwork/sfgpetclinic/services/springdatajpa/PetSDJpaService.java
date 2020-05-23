package guru.springframwork.sfgpetclinic.services.springdatajpa;

import guru.springframwork.sfgpetclinic.model.Pet;
import guru.springframwork.sfgpetclinic.repositories.PetRepository;
import guru.springframwork.sfgpetclinic.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by zwakele
 * on 2020/05/23
 **/
@Service
@Profile("springdatajpa")
public class PetSDJpaService implements PetService {

  private final PetRepository repository;

  public PetSDJpaService(PetRepository repository) {
    this.repository = repository;
  }

  @Override
  public Pet findById(Long aLong) {
    return repository.findById(aLong).orElse(null);
  }

  @Override
  public Pet save(Pet pet) {
    return repository.save(pet);
  }

  @Override
  public Set<Pet> findAll() {
    Set<Pet> pets = new HashSet<>();
    repository.findAll().forEach(pets::add);
    return pets;
  }

  @Override
  public void delete(Pet object) {
    repository.delete(object);
  }

  @Override
  public void deleteById(Long aLong) {
    repository.deleteById(aLong);
  }
}
