package dev.ecommerce.productservice.services;

import dev.ecommerce.productservice.dtos.FakeStoreProductDto;
import dev.ecommerce.productservice.dtos.GenericProductDto;
import dev.ecommerce.productservice.exceptions.NotFoundException;
import dev.ecommerce.productservice.thirdpartyclients.FakeStoreProductClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Primary
@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService {

    private FakeStoreProductClient fakeStoreProductClient;
    @Autowired
    public FakeStoreProductService(FakeStoreProductClient fakeStoreProductClient){
        this.fakeStoreProductClient = fakeStoreProductClient;
    }

    public GenericProductDto fakeStoreProductDtoToGenericProductDto(FakeStoreProductDto fakeStoreProductDto){
        GenericProductDto genericProductDto = new GenericProductDto();
        genericProductDto.setId(fakeStoreProductDto.getId());
        genericProductDto.setDescription(fakeStoreProductDto.getDescription());
        genericProductDto.setTitle(fakeStoreProductDto.getTitle());
        genericProductDto.setPrice(fakeStoreProductDto.getPrice());
        genericProductDto.setImage(fakeStoreProductDto.getImage());
        genericProductDto.setCategory(fakeStoreProductDto.getCategory());

        return genericProductDto;
    }
    @Override
    public GenericProductDto getProductById(long id) throws NotFoundException {

        FakeStoreProductDto fakeStoreProductDto = fakeStoreProductClient.getProductById(id);

        if(fakeStoreProductDto == null){
            throw new NotFoundException("Product with id: "+id+" not found");
        }
        return fakeStoreProductDtoToGenericProductDto(fakeStoreProductDto);
    }

    public List<GenericProductDto> getAllProducts(){

        FakeStoreProductDto[] fakeStoreProductDtos = fakeStoreProductClient.getAllProducts();
        List<GenericProductDto> genericProductDtos = new ArrayList<GenericProductDto>();

        for(FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtos){
            genericProductDtos.add(fakeStoreProductDtoToGenericProductDto(fakeStoreProductDto));
        }
        return genericProductDtos;
    }

    public GenericProductDto createProduct(GenericProductDto product){

        FakeStoreProductDto fakeStoreProductDto = fakeStoreProductClient.createProduct(product);

        return fakeStoreProductDtoToGenericProductDto(fakeStoreProductDto);
    }

    public GenericProductDto deleteProduct(Long id) throws NotFoundException {

        FakeStoreProductDto fakeStoreProductDto = fakeStoreProductClient.deleteProduct(id);

        if(fakeStoreProductDto == null){
            throw new NotFoundException("Product with id: "+id+" not found");
        }
        return fakeStoreProductDtoToGenericProductDto(fakeStoreProductDto);

    }


    public GenericProductDto updateProductById(Long id,GenericProductDto genericProductDto) throws NotFoundException{

        FakeStoreProductDto fakeStoreProductDto = fakeStoreProductClient.updateProductById(id,genericProductDto);

        if(fakeStoreProductDto == null){
            throw new NotFoundException("Product with id: "+id+" not found");
        }

        return fakeStoreProductDtoToGenericProductDto(fakeStoreProductDto);
    }
}
