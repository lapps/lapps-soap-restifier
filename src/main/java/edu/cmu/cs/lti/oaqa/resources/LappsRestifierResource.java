package edu.cmu.cs.lti.oaqa.resources;

import org.lappsgrid.client.ServiceClient;

import java.io.InputStream;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import javax.xml.rpc.ServiceException;

/**
 * @author Di Wang
 * @email diwang@cs.cmu.edu
 */
@Path("/")
public class LappsRestifierResource {

    private static final String TEXT = "text/json";

    @Path("getMetadata")
    @GET
    @Produces(TEXT)
    public Response getMetadataFromLappsSoap(@QueryParam("endpoint") String endpoint) {
        String outputStr;
        try {
            ServiceClient client = new ServiceClient(endpoint, "tester", "tester");
            outputStr = "\n Metadata: \n" + client.getMetadata() + "\n";
        } catch (ServiceException e) {
            return Response.serverError().build();
        }
        return Response.ok(outputStr.getBytes()).build();
    }

    @Path("execute")
    @POST
    @Consumes(TEXT)
    @Produces(TEXT)
    public Response executeFromLappsSoap(@QueryParam("endpoint") String endpoint, final InputStream input) {
        String outputStr;
        try {
            String inputStr = convertStreamToString(input);
            ServiceClient client = new ServiceClient(endpoint, "tester", "tester");
            outputStr = "\n Metadata: \n" + client.execute(inputStr) + "\n";
        } catch (ServiceException e) {
            return Response.serverError().build();
        }
        return Response.ok(outputStr.getBytes()).build();
    }

    static String convertStreamToString(java.io.InputStream is) {
        java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }
}
