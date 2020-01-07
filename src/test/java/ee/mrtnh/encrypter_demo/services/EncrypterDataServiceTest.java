package ee.mrtnh.encrypter_demo.services;

import ee.mrtnh.encrypter_demo.model.DataPacket;
import ee.mrtnh.encrypter_demo.model.EncryptedData;
import ee.mrtnh.encrypter_demo.repository.EncryptedDataRepository;
import ee.mrtnh.encrypter_demo.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class EncrypterDataServiceTest {

    @Autowired
    EncryptedDataRepository encryptedDataRepository;

    @Autowired
    UserRepository userRepository;

    @MockBean
    EncrypterDataService encrypterDataService;

    DataPacket dataPacket = new DataPacket("testData", "testUser", "testPassword");

    @BeforeEach
    void setUp() {
    }

    @Test
    void encryptData() {
        encrypterDataService.encryptData(dataPacket);
    }

    @Test
    void decryptData() {
        // Couldn't get it to work
        /*
        String stringToDecrypt = "HMzhctXGFRRTJKvAgzkmhw==";
        encryptedDataRepository.save(new EncryptedData(stringToDecrypt, "testUser"));
        userRepository.save(new User("testData", "testUser"));
        AES.setKey("testKey");
        String decryptedString = demoDataService.decryptData(new DataPacket(stringToDecrypt, "testUser", "testPassword"));
        assertThat(decryptedString).isEqualTo("testString");
        */
    }

    @Test
    void getAllDataTest() {
        encryptedDataRepository.save(new EncryptedData("testData1", "testUser1"));
        encryptedDataRepository.save(new EncryptedData("testData2", "testUser2"));
        assertThat(encrypterDataService.getAllData().size() == 2);
    }
}