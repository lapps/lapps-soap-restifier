package edu.cmu.cs.lti.oaqa.services;

import edu.cmu.cs.lti.oaqa.resources.LappsRestifierResource;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.Collections;
import java.util.Set;

/**
 * @author Di Wang
 * @email diwang@cs.cmu.edu
 */
@ApplicationPath("soap")
public class LappsSoapRestifier extends Application {

    private Set<Object> singletons = Collections.<Object>singleton(new LappsRestifierResource());

    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }
}
