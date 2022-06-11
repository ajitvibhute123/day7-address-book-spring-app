package com.bridgelabz.addressbookapp.services;
import com.bridgelabz.addressbookapp.dto.AddressbookDTO;
import com.bridgelabz.addressbookapp.model.AddressbookData;

import java.util.List;

public interface IAddressbookService {
    List<AddressbookData> getAddressbookData();

    AddressbookData getAddressbookDataById(int personId);

    AddressbookData createAddressbookData(AddressbookDTO addressbookDTO);

    AddressbookData updateAddressbookData(int personId,AddressbookDTO addressbookDTO);

    void deleteAddressbookData(int personId);
}