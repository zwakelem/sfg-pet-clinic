package guru.springframwork.sfgpetclinic.services.springdatajpa;

import guru.springframwork.sfgpetclinic.model.Visit;
import guru.springframwork.sfgpetclinic.repositories.VisitRepository;
import guru.springframwork.sfgpetclinic.services.VisitService;
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
public class VisitSDJpaService implements VisitService {

  private final VisitRepository repository;

  public VisitSDJpaService(VisitRepository repository) {
    this.repository = repository;
  }

  @Override
  public Visit findById(Long aLong) {
    return repository.findById(aLong).orElse(null);
  }

  @Override
  public Visit save(Visit visit) {
    return repository.save(visit);
  }

  @Override
  public Set<Visit> findAll() {
    Set<Visit> visits = new HashSet<>();
    repository.findAll().forEach(visits::add);
    return visits;
  }

  @Override
  public void delete(Visit object) {
    repository.delete(object);
  }

  @Override
  public void deleteById(Long aLong) {
    repository.deleteById(aLong);
  }
}
