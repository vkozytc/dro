package voblaweb.photo.repository;

import org.springframework.data.repository.CrudRepository;
import voblaweb.photo.model.TypeOfSupplies;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeOfSuppliesRepository extends JpaRepository<TypeOfSupplies,Integer> {
}
