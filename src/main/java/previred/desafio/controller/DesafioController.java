package previred.desafio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import previred.desafio.domain.Periodo;
import previred.desafio.domain.Response;
import previred.desafio.service.DesafioService;

@RestController
public class DesafioController {

    @Autowired
    private DesafioService service;

    private static String API_URL = "http://127.0.0.1:8080/periodos/api";

    @GetMapping(value = "ms-previred/desafio/test",  consumes = "application/json",produces = { "application/json" })
    public ResponseEntity<Response> getMe(@RequestBody Periodo body){

        Response response = service.getInfo(body);
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "ms-previred/desafio/get", produces = { "application/json" })
    public ResponseEntity<Response> getInfo(){

        RestTemplate restTemplate = new RestTemplate();
        Periodo periodo = restTemplate.getForObject(API_URL, Periodo.class);
        Response response = service.getInfo(periodo);
        return ResponseEntity.ok(response);
    }
}
