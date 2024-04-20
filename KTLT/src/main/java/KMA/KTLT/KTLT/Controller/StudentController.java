package KMA.KTLT.KTLT.Controller;

import com.fasterxml.jackson.databind.JsonNode;
import KMA.KTLT.KTLT.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @GetMapping("/getById")
    public ResponseEntity<?> getById(@RequestParam int id){
        return studentService.getById(id);
    }
    @GetMapping("/getAll")
    public ResponseEntity<?> getAll(){
        return studentService.getAll();
    }
    @PostMapping("/post")
    public ResponseEntity<?> post(@RequestBody JsonNode jsonNode) { return studentService.post(jsonNode);}
    @PutMapping("/put")
    public ResponseEntity<?> put(@RequestBody JsonNode jsonNode){
        return studentService.put(jsonNode);
    }
    @PatchMapping("/patch")
    public ResponseEntity<?> patch(@RequestBody JsonNode jsonNode){return  studentService.patch(jsonNode);}
    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestParam int id){
        return studentService.delete(id);
    }

}
