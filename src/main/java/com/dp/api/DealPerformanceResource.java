/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dp.api;

/**
 *
 * @author ZAMBRED
 */
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/v1/deal-performance")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DealPerformanceResource {
    private static final String API_KEY = "IMKw1BAltJdcbQqFt50oatUQw4wTs/j+rDmu8wtf";
    @POST
    @Path("/ingest")
    public Response ingest(@HeaderParam("X-Api-Key") String apiKey, @Valid IngestRequest req) {

        // 1) Validar API key
        if (apiKey == null || !API_KEY.equals(apiKey)) {
                return Response.status(Response.Status.UNAUTHORIZED)
                                           .entity(new Msg("unauthorized", "Invalid or missing API key"))
                                           .build();
        }

        // 2) Procesar la data
        int saved = new DealPerformanceDAO().bulkInsert(req.getSource(), req.getRows());

        // 3) Responder OK
        return Response.ok(new Msg("ok", "saved=" + saved)).build();
    }

    // Clase auxiliar para respuesta
    public static class Msg {
            public String status;
            public String detail;

            public Msg(String s, String d) {
                    this.status = s;
                    this.detail = d;
            }
    }
}
