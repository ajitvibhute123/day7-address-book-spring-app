package com.bridgelabz.addressbookapp.model;
import com.bridgelabz.addressbookapp.dto.AddressbookDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="contact_details")
public  @Data @NoArgsConstructor class AddressbookData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "person_Id")
    private int personId;
    private String name;
    private String phoneNumber;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String email;


    public AddressbookData(AddressbookDTO addressbookDTO) {
        this.updateAddressBookdata(addressbookDTO);

    }
    public void updateAddressBookdata(AddressbookDTO addressbookDTO) {
        this.name = addressbookDTO.name;
        this.phoneNumber = addressbookDTO.phoneNumber;
        this.address = addressbookDTO.address;
        this.city = addressbookDTO.city;
        this.state = addressbookDTO.state;
        this.zip = addressbookDTO.zip;
        this.email = addressbookDTO.email;
    }
}