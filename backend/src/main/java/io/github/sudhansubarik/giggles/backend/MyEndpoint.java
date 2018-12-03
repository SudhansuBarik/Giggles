/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package io.github.sudhansubarik.giggles.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import javax.inject.Named;

import io.github.sudhansubarik.javajoker.Joker;

/**
 * An endpoint class we are exposing
 */
@Api(
        name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.giggles.sudhansubarik.github.io",
                ownerName = "backend.giggles.sudhansubarik.github.io",
                packagePath = ""
        )
)
public class MyEndpoint {

    @ApiMethod(name = "tellJoke")
    public MyBean tellJoke(){
        MyBean response = new MyBean();
        Joker joker = new Joker();
        response.setData(joker.tellJoke());
        return response;
    }
}
