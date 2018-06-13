package voblaweb.photo.repository;

import org.springframework.data.repository.CrudRepository;
import voblaweb.photo.model.GoodType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoodTypeRepository extends JpaRepository<GoodType,Integer> {
}
