package KMA.KTLT.KTLT.Service;

import KMA.KTLT.KTLT.DTO.StudentDTO;
import KMA.KTLT.KTLT.DTO.SubjectDTO;
import KMA.KTLT.KTLT.Entity.Student;
import KMA.KTLT.KTLT.Entity.Subject;
import KMA.KTLT.KTLT.Repository.SubjectRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
public class SubjectService implements ServiceInterface{

    @Autowired
    private SubjectRepository subjectRepository;
    @Autowired
    private ObjectMapper objectMapper;
    @Override
    public ResponseEntity<?> getAll() {
        List<Subject> subjects = subjectRepository.ktltGetAllSubject();
        List<SubjectDTO> subjectDTOS = new ArrayList<>();
        for (Subject s: subjects) {
            SubjectDTO studentDTO = new SubjectDTO(s.getId() , s.getName() , s.getCredit() );
            subjectDTOS.add(studentDTO);
        }
        return ResponseEntity.ok().body(subjectDTOS);
    }

    @Override
    public ResponseEntity<?> getById(int id) {
        Subject subject = subjectRepository.ktltGetSubjectById(id);
        return ResponseEntity.ok().body(new SubjectDTO(subject.getId() , subject.getName() , subject.getCredit()));
    }

    @Override
    @Transactional
    public ResponseEntity<?> post(JsonNode jsonNode) {
        try {
            Subject subject = objectMapper.treeToValue(jsonNode , Subject.class);
            subjectRepository.ktltPostSubject(subject.getName() , subject.getCredit());
            return ResponseEntity.ok().body("Saved subject successfully");
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    @Transactional
    public ResponseEntity<?> put(JsonNode jsonNode) {
        try {
            Subject subject = objectMapper.treeToValue(jsonNode , Subject.class);
            subjectRepository.ktltPutSubject(subject.getId(),subject.getName() , subject.getCredit());
            return ResponseEntity.ok().body("Put Successfully");
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }    }

    @Override
    @Transactional
    public ResponseEntity<?> patch(JsonNode jsonNode) {
        int id;
        if (jsonNode.has("id")) {
            id = Integer.parseInt(jsonNode.get("id").asText());
        } else {
            return ResponseEntity.badRequest().body("ID is missing");
        }
        String name = jsonNode.has("name") ? jsonNode.get("name").asText() : null;
        Boolean isNameChanged = name != null ? true : false;

        String credit = jsonNode.has("credit") ? jsonNode.get("credit").asText() : null;
        Boolean isCreditChanged = credit != null;


        Subject subject = subjectRepository.ktltGetSubjectById(id);

        if(isNameChanged){
            subject.setName(name);
        }
        if(isCreditChanged){
            subject.setCredit(Integer.parseInt(credit));
        }
        subjectRepository.ktltPutSubject(subject.getId(),subject.getName() , subject.getCredit());
        return ResponseEntity.ok().body("Patched Successfully");    }

    @Transactional
    @Override
    public ResponseEntity<?> delete(int id) {
        subjectRepository.ktltDeleteSubject(id);
        return ResponseEntity.ok().body("Deleted Successfully");
    }

    @Override
    public ResponseEntity<?> head(JsonNode jsonNode) {
        return null;
    }

    @Override
    public ResponseEntity<?> option(JsonNode jsonNode) {
        return null;
    }
}
