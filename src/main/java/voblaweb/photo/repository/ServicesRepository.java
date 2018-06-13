package voblaweb.photo.repository;

import org.springframework.data.repository.CrudRepository;
import voblaweb.photo.model.Services;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicesRepository extends JpaRepository<Services,Integer> {
}
