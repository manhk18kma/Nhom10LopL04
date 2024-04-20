package KMA.KTLT.KTLT.Controller;

import KMA.KTLT.KTLT.Service.SubjectService;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/subject")
public class SubjectController {
    @Autowired
    private SubjectService subjectService;

    @GetMapping("/getById")
    public ResponseEntity<?> getById(@RequestParam int id){
        return subjectService.getById(id);
    }
    @GetMapping("/getAll")
    public ResponseEntity<?> getAll(){
        return subjectService.getAll();
    }
    @PostMapping("/post")
    public ResponseEntity<?> post(@RequestBody JsonNode jsonNode) { return subjectService.post(jsonNode);}
    @PutMapping("/put")
    public ResponseEntity<?> put(@RequestBody JsonNode jsonNode){
        return subjectService.put(jsonNode);
    }
    @PatchMapping("/patch")
    public ResponseEntity<?> patch(@RequestBody JsonNode jsonNode){return  subjectService.patch(jsonNode);}
    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestParam int id){
        return subjectService.delete(id);
    }
}
