package ee.mrtnh.encrypter_demo.repository;

import ee.mrtnh.encrypter_demo.model.EncryptedData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class EncryptedDataRepositoryTest {

    @Autowired
    EncryptedDataRepository encryptedDataRepository;

    EncryptedData data = new EncryptedData("testData", "testUser");

    @BeforeEach
    void setUp() {
        encryptedDataRepository.save(data);
    }

    @Test
    void findDataByUserName() {
        EncryptedData foundEncryptedData = encryptedDataRepository.findDataByUserName(data.getUserName());
        assertThat(data.equals(foundEncryptedData));
    }

    @Test
    void findDataByEncryptedData() {
        EncryptedData foundEncryptedData = encryptedDataRepository.findDataByEncryptedData(data.getEncryptedData());
        assertThat(data.equals(foundEncryptedData));
    }
}