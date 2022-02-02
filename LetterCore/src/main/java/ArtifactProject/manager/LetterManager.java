package ArtifactProject.manager;

import ArtifactProject.dao.entity.Letter;
import ArtifactProject.dao.entity.LetterRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LetterManager {

    private final LetterRepository letterRepository;

    public LetterManager(LetterRepository letterRepository) {
        this.letterRepository = letterRepository;
    }

    public Letter add(Letter letter){
        return letterRepository.save(letter);
    }

    public Iterable<Letter> findAll(){
        return letterRepository.findAll();
    }

    public Optional<Letter> findById(Long id){
        return letterRepository.findById(id);
    }

    public void deleteById(Long id){
        letterRepository.deleteById(id);
    }

    public Optional<Letter> findByPhoneNumber(String phoneNumber){
        return letterRepository.findByPhoneNumber(phoneNumber);
    }



}
