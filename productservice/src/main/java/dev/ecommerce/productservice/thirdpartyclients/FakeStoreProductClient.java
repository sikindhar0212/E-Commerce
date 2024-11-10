package dev.ecommerce.productservice.thirdpartyclients;

import dev.ecommerce.productservice.dtos.FakeStoreProductDto;
import dev.ecommerce.productservice.dtos.GenericProductDto;
import dev.ecommerce.productservice.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component
public class FakeStoreProductClient {
    private RestTemplateBuilder restTemplateBuilder;

    private String productUrl;
    private String productRequestUrl;

    @Autowired
    public FakeStoreProductClient(RestTemplateBuilder restTemplateBuilder,
                                  @Value("${fakestoreapi.baseUrl}") String fakeStoreApiBaseUrl,
                                  @Value("${fakestore.api.product}") String fakeStoreProductPath){
        this.restTemplateBuilder = restTemplateBuilder;
        this.productUrl = fakeStoreApiBaseUrl + fakeStoreProductPath + "/{id}";
        this.productRequestUrl = fakeStoreApiBaseUrl + fakeStoreProductPath;
    }


    public FakeStoreProductDto getProductById(long id) {

        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> response = restTemplate.getForEntity(productUrl,
                FakeStoreProductDto.class,id);

        FakeStoreProductDto fakeStoreProductDto = response.getBody();

        return fakeStoreProductDto;
    }

    public FakeStoreProductDto[] getAllProducts(){

        RestTemplate restTemplate = new RestTemplateBuilder().build();
        ResponseEntity<FakeStoreProductDto[]> response = restTemplate
                .getForEntity(productRequestUrl,FakeStoreProductDto[].class);
        FakeStoreProductDto[] fakeStoreProductDtos = response.getBody();

        return fakeStoreProductDtos;
    }

    public FakeStoreProductDto createProduct(GenericProductDto product){

        RestTemplate restTemplate = new RestTemplateBuilder().build();
        ResponseEntity<FakeStoreProductDto> response = restTemplate
                .postForEntity(productRequestUrl,product,FakeStoreProductDto.class);
        FakeStoreProductDto fakeStoreProductDto = response.getBody();

        return fakeStoreProductDto;
    }

    public FakeStoreProductDto deleteProduct(Long id){

        RestTemplate restTemplate =  new RestTemplateBuilder().build();
        ResponseEntity<FakeStoreProductDto> response = restTemplate
                .exchange(productUrl,
                        HttpMethod.DELETE,null,FakeStoreProductDto.class,id);
        FakeStoreProductDto fakeStoreProductDto = response.getBody();

        return fakeStoreProductDto;

    }


    public FakeStoreProductDto updateProductById(Long id,GenericProductDto genericProductDto) {

        RestTemplate restTemplate = new RestTemplateBuilder().build();
        HttpEntity<GenericProductDto> entity = new HttpEntity<>(genericProductDto, null);
        ResponseEntity<FakeStoreProductDto> response = restTemplate.
                exchange(productUrl,
                        HttpMethod.PUT,entity,
                        FakeStoreProductDto.class,id);

        FakeStoreProductDto fakeStoreProductDto = response.getBody();

        return fakeStoreProductDto;
    }

}
