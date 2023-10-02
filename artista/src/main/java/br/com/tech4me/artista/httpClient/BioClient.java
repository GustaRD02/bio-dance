package br.com.tech4me.artista.httpClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.tech4me.artista.model.Bio;

@FeignClient("biodance")
public interface BioClient {

     @RequestMapping(method = RequestMethod.GET, value = "/bios/{id}")
    Bio findById(@PathVariable String id);

    @RequestMapping(method = RequestMethod.PUT, value = "/bios/{id}")
    void updateBio(@PathVariable String id, @RequestBody Bio bio);

}
