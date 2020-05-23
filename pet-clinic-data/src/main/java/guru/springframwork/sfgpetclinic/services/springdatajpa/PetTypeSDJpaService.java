package guru.springframwork.sfgpetclinic.services.springdatajpa;

import guru.springframwork.sfgpetclinic.model.PetType;
import guru.springframwork.sfgpetclinic.repositories.PetTypeRepository;
import guru.springframwork.sfgpetclinic.services.PetTypeService;
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
public class PetTypeSDJpaService implements PetTypeService {

  private final PetTypeRepository repository;

  public PetTypeSDJpaService(PetTypeRepository repository) {
    this.repository = repository;
  }

  @Override
  public PetType findById(Long aLong) {
    return repository.findById(aLong).orElse(null);
  }

  @Override
  public PetType save(PetType petType) {
    return repository.save(petType);
  }

  @Override
  public Set<PetType> findAll() {
    Set<PetType> petTypes = new HashSet<>();
    repository.findAll().forEach(petTypes::add);
    return petTypes;
  }

  @Override
  public void delete(PetType object) {
    repository.delete(object);
  }

  @Override
  public void deleteById(Long aLong) {
    repository.deleteById(aLong);
  }

}
