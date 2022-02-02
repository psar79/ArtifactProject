package ArtifactProject.controller;

import ArtifactProject.api.findAll.response.LetterInfo;
import ArtifactProject.api.findAll.response.LetterResponse;
import ArtifactProject.api.getById.RequestById;

import ArtifactProject.api.getByPhoneNumber.LettersByPhoneNumberResponse;
import ArtifactProject.api.getByPhoneNumber.RequestByPhoneNumber;
import ArtifactProject.dao.entity.Letter;
import ArtifactProject.api.addLetter.request.LetterRequest;
import ArtifactProject.manager.LetterManager;
import ArtifactProject.mapper.LetterByPhoneNumberMapper;
import ArtifactProject.mapper.LetterInfoMapper;
import ArtifactProject.mapper.LetterRequestMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.*;
import java.util.stream.Collectors;

@RestController
public class LetterController {

    private final LetterManager letterManager;
    private final LetterRequestMapper letterRequestMapper;
    private final LetterInfoMapper letterInfoMapper;
    private final LetterByPhoneNumberMapper letterByPhoneNumberMapper;

    public LetterController(LetterManager letterManager, LetterRequestMapper letterRequestMapper, LetterInfoMapper letterInfoMapper, LetterByPhoneNumberMapper letterByPhoneNumberMapper) {
        this.letterManager = letterManager;
        this.letterRequestMapper = letterRequestMapper;
        this.letterInfoMapper = letterInfoMapper;
        this.letterByPhoneNumberMapper = letterByPhoneNumberMapper;
    }

    @PostMapping("/addLetter")
    public ResponseEntity<Void> addLetter(@RequestBody @Valid LetterRequest letterRequest) {
        if (Objects.isNull(letterRequest)) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        Letter letter = letterRequestMapper.mapToLetter(letterRequest);
        letterManager.add(letter);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/getAll")
    public ResponseEntity<LetterInfo> getAll(){

        Iterable<Letter> all = letterManager.findAll();

        List<Letter> result = new ArrayList<>();
//        all.forEach(letter -> result.add(letter))
        all.forEach(result::add);

        LetterInfo letterInfo = letterInfoMapper.mapToResponse(result);
        return ResponseEntity.status(HttpStatus.OK).body(letterInfo);
    }
    @GetMapping("/getById")
    public ResponseEntity<LetterResponse> getById (@RequestBody RequestById requestById){

        Optional<Letter> letterById = letterManager.findById(requestById.getId());

        if(letterById.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        LetterResponse letterResponse = letterInfoMapper.toLetterResponse(letterById.get());
        return ResponseEntity.ok().body(letterResponse);
    }

    @GetMapping("/getByPhoneNumber")
    public ResponseEntity<LettersByPhoneNumberResponse> getByPhoneNumber(@RequestBody RequestByPhoneNumber requestByPhoneNumber){

        Optional<Letter> byPhoneNumber = letterManager.findByPhoneNumber(requestByPhoneNumber.getPhoneNumber());

        if(!byPhoneNumber.isPresent()){
            ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        LettersByPhoneNumberResponse response = letterByPhoneNumberMapper.mapToLetterByPhoneNumberResponse(Collections.singletonList(byPhoneNumber.get()));

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }



}
