package KMA.KTLT.KTLT.Service;

import KMA.KTLT.KTLT.DTO.StudentDTO;
import KMA.KTLT.KTLT.Entity.Student;
import KMA.KTLT.KTLT.Repository.StudentRepository;
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
public class StudentService implements ServiceInterface{
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public ResponseEntity<?> getAll() {
        List<Student> students = studentRepository.ktltGetAllStudent();
        List<StudentDTO> studentDTOS = new ArrayList<>();
        for (Student s: students) {
            StudentDTO studentDTO = new StudentDTO(s.getId() , s.getName() , s.getSex() , s.getDateOfBrith());
            studentDTOS.add(studentDTO);
        }
        return ResponseEntity.ok().body(studentDTOS);
    }

    @Override
    public ResponseEntity<?> getById(int id) {
        Student s = studentRepository.ktltGetStudentById(id);
        return ResponseEntity.ok().body(new StudentDTO(s.getId() , s.getName() , s.getSex() , s.getDateOfBrith()));
    }

    @Override
    @Transactional
    public ResponseEntity<?> post(JsonNode jsonNode) {
        try {
            Student student = objectMapper.treeToValue(jsonNode , Student.class);
            String dateString = jsonNode.get("dateOfBirth").asText();
             studentRepository.ktltPostStudent(student.getName() , student.getSex() , dateString);
            return ResponseEntity.ok().body("Saved Successfully");
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    @Transactional
    public ResponseEntity<?> put(JsonNode jsonNode) {
        try {
            Student student = objectMapper.treeToValue(jsonNode , Student.class);
            String dateString = jsonNode.get("dateOfBirth").asText();
            Date date = Date.valueOf(dateString);
            studentRepository.ktltPutStudent(student.getId(),student.getName() , student.getSex() , date);
            return ResponseEntity.ok().body("Updated Successfully");
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }

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
        Boolean sex = jsonNode.has("sex") ? Boolean.parseBoolean(jsonNode.get("sex").asText()) : null;
        String dateString = jsonNode.has("dateOfBirth") ? jsonNode.get("dateOfBirth").asText() : null;

        Boolean isNameChanged = name != null ? true : false;
        Boolean isSexChanged = sex != null ? true : false;
        Boolean isDateChanged = dateString != null ? true : false;

        Student student = studentRepository.ktltGetStudentById(id);

        if(isDateChanged){
            Date date = Date.valueOf(dateString);
            student.setDateOfBrith(date);
        }
        if(isNameChanged){
            student.setName(name);
        }
        if(isSexChanged){
            student.setSex(sex);
        }
        System.out.println(student.toString());
        studentRepository.ktltPutStudent(student.getId(),student.getName() , student.getSex() , student.getDateOfBrith());





        return ResponseEntity.ok().body("Patched Successfully");
    }

    @Override
    @Transactional
    public ResponseEntity<?> delete(int id) {
        studentRepository.ktltDeleteStudent(id);
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
