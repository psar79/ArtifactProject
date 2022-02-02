package ArtifactProject.dao.entity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LetterRepository extends CrudRepository<Letter, Long> {

    Optional<Letter> findByPhoneNumber(String phoneNumber);

}
