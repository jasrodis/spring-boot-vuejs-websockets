
package org.jasrodis.example.controller;

import org.jasrodis.example.model.ModelInfoHolder;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Websocket controller is broadcasting every {fixedDelay = 1000} ms the data through websockets 

 * @author jasrodis
 */
@Controller
public class WebSocketController {

	private ObjectMapper mapper;
	private ModelInfoHolder modelInfoHolder;
	private SimpMessagingTemplate messageTemplate;

	public WebSocketController(ObjectMapper mapper, SimpMessagingTemplate messageTemplate, ModelInfoHolder modelInfoHolder) {
		this.mapper = mapper;
		this.messageTemplate = messageTemplate;
		this.modelInfoHolder = modelInfoHolder;
	}

	@Scheduled(fixedDelay = 1000)
	public void sendWebSocketUpdate() throws JsonProcessingException {
		modelInfoHolder.changeValues();
		this.messageTemplate.convertAndSend("/info/values",
				mapper.writeValueAsString(modelInfoHolder.getModelInfoList()));
	}

}
