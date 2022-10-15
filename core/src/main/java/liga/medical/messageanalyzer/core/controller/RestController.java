package liga.medical.messageanalyzer.core.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/rest")
public class RestController {

    @PostMapping("/person")
    ResponseEntity<String> saveInfo(@RequestBody String info) {
        String uid = UUID.randomUUID().toString();
        String answer = String.format("Сохранение информации о личности [%s]. Идентификатор: [%s].", info, uid);
        return ResponseEntity.ok(answer);
    }

    @GetMapping("/person/{uid}")
    ResponseEntity<String> getInfoById(@PathVariable("uid") String uid) {
        if (StringUtils.hasText(uid)) {
            String answer = String.format("Получение личности по идентификатору [%s]", uid);
            return ResponseEntity.ok(answer);
        } else {
            String answer = "На вход поступил пустой параметр";
            return ResponseEntity.ok(answer);
        }
    }

    @PutMapping("/person/{uid}")
    ResponseEntity<String> updateInfoById(@PathVariable("uid") String uid, @RequestBody String info) {
        String answer = String.format("Обновление информации о личности [%s]. Идентификатор: [%s].", info, uid);
        return ResponseEntity.ok(answer);
    }

    @DeleteMapping("/person/{uid}")
    ResponseEntity<String> updateInfoById(@PathVariable("uid") String uid) {
        String answer = String.format("Удаление информации о личности. Идентификатор: [%s].", uid);
        return ResponseEntity.ok(answer);
    }
}
