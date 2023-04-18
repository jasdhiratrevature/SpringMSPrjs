package com.revature.service;


import com.revature.dao.AllergyDao;
import com.revature.dao.AllergyDaoException;
import com.revature.dto.AllergyDTO;
import com.revature.model.Allergy;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class AllergyService {

    private final AllergyDao allergyDao;

    public List<AllergyDTO> getAllAllergies() throws AllergyServiceException {
        List<Allergy> allergies;
        try {
            allergies = allergyDao.listAllAllergies();
            log.info("Allergies are retrieved.");
        } catch (AllergyDaoException exception) {
            log.error(exception.getMessage());
            throw new AllergyServiceException("Allergy details retrieval failed.", exception);
        }
        return allergies.stream().map(this::mapToAllergyDTO).toList();
    }

    private AllergyDTO mapToAllergyDTO(Allergy allergy) {
        return AllergyDTO.builder().id(allergy.getId()).name
                        (allergy.getName()).description(allergy.getDescription()).symptoms(allergy.getSymptoms())
                .build();
    }


    public Allergy getAllergyById(int id) throws AllergyServiceException {
        Allergy allergy = null;
        try {
            Optional<Allergy> retrievedAllergy = allergyDao.listAllergyById(id);
            if (retrievedAllergy.isPresent()) {
                allergy = retrievedAllergy.get();
                log.info("Allergy of id {} is retrieved", allergy.getId());
            }
        } catch (AllergyDaoException exception) {
            log.info("Allergy of id {} retrieval failed.", id);
            log.error(exception.getMessage());
            throw new AllergyServiceException(String.format("Allergy of id {} retrieval failed.", id), exception);
        }
        return allergy;
    }
}
