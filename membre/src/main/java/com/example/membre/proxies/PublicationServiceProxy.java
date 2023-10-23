package com.example.membre.proxies;

import com.example.membre.bean.PublicationBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "PUBLICATION-SERVICE")
public interface PublicationServiceProxy {
    @GetMapping("/publications/{id}")
    public PublicationBean findPublicationById(@PathVariable(name = "id") Long id);
}
