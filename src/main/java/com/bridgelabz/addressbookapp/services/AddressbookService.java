package com.bridgelabz.addressbookapp.services;
import com.bridgelabz.addressbookapp.dto.AddressbookDTO;
import com.bridgelabz.addressbookapp.exceptions.AddressbookException;
import com.bridgelabz.addressbookapp.model.AddressbookData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressbookService implements IAddressbookService {

    List<AddressbookData> addressbookDataList = new ArrayList<>();

    @Override
    public List<AddressbookData> getAddressbookData() {
        return addressbookDataList;
    }

    @Override
    public AddressbookData getAddressbookDataById(int personId) {
        AddressbookData addressbookData = null;
        addressbookData = addressbookDataList.get(personId - 1);
        return addressbookData;
    }

    @Override
    public AddressbookData createAddressbookData(AddressbookDTO addressbookDTO) {
        AddressbookData addressbookData = null;
        addressbookData = new AddressbookData(addressbookDataList.size() + 1, addressbookDTO);
        addressbookDataList.add(addressbookData);
        return addressbookData;
    }

    @Override
    public AddressbookData updateAddressbookData(int personId, AddressbookDTO addressbookDTO) {
        return addressbookDataList.stream()
                .filter(addressbookData -> addressbookData.getPersonId()==personId)
                .findFirst()
                .orElseThrow(()->new AddressbookException("Person Not found"));
    }

    @Override
    public void deleteAddressbookData(int personId) {
        int i = 1;
        addressbookDataList.remove(personId - 1);
        for (AddressbookData addressbookData : addressbookDataList) {
            addressbookData.setPersonId(i++);
        }
    }
}