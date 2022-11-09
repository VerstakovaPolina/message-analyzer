package liga.medical.messageanalyzer.core.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import liga.medical.messageanalyzer.core.api.RabbitSenderService;
import liga.medical.messageanalyzer.core.config.RabbitConfig;
import liga.medical.messageanalyzer.core.model.RabbitMessageDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rabbit")
public class RabbitController {

    private final RabbitSenderService rabbitSenderService;

    public RabbitController(RabbitSenderService rabbitSenderService) {
        this.rabbitSenderService = rabbitSenderService;
    }

    @PostMapping("/send")
    public String sendMessage(@RequestBody RabbitMessageDto messageDto) throws JsonProcessingException {
        return rabbitSenderService.sendMessage(messageDto, RabbitConfig.COMMON_MONITORING_QUEUE);

    }
}
