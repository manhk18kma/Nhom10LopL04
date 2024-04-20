package KMA.KTLT.KTLT.Service;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.http.ResponseEntity;

public interface ServiceInterface {
    public ResponseEntity<?> getAll();
    public ResponseEntity<?> getById(int id);

    public ResponseEntity<?> post(JsonNode jsonNode);
    public ResponseEntity<?> put(JsonNode jsonNode);
    public ResponseEntity<?> patch(JsonNode jsonNode);
    public ResponseEntity<?> delete(int id);
    public ResponseEntity<?> head(JsonNode jsonNode);
    public ResponseEntity<?> option(JsonNode jsonNode);

}
