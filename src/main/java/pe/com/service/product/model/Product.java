package pe.com.service.product.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;


@Data
@Document(collection = "product")
public class Product {
	
    @Id
    private String id;
    private String nameProduct;
    private String typeProduct;
    private String numberCard;
    private String account;
    private String ccv;
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date createDate;
    private String idClient;

}
