package com.nxu.apis;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "cart-service")
public interface CartApi {

}