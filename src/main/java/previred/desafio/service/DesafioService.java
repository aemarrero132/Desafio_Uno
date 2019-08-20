package previred.desafio.service;

import org.springframework.stereotype.Service;
import previred.desafio.domain.Periodo;
import previred.desafio.domain.Response;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class DesafioService {

    public Response getInfo(Periodo body) {
        List<String> fechasRecibidas = new ArrayList<>();
        List<LocalDate> fechasFaltantes = new ArrayList<>();
        Response response = new Response();

        if(body != null) {
            LocalDate fechaCreacion = body.getFechaCreacion();
            LocalDate fechaFinal = body.getFechaFin();

            for (LocalDate d : body.getFechas()) {
                fechasRecibidas.add(d.toString());
            }

            while(!fechaCreacion.isAfter(fechaFinal)) {

                if(!fechasRecibidas.contains(fechaCreacion.toString())) {
                    fechasFaltantes.add(fechaCreacion);
                }
                fechaCreacion = fechaCreacion.plusMonths(1);
            }
            response.setId(body.getId());
            response.setFechaCreacion(body.getFechaCreacion());
            response.setFechaFin(body.getFechaFin());
            response.setFechas(body.getFechas());
            response.setFechasFaltantes(fechasFaltantes);
        }
        return response;
    }
}
