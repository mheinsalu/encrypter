package ee.mrtnh.encrypter_demo.controllers;

import ee.mrtnh.encrypter_demo.model.DataPacket;
import ee.mrtnh.encrypter_demo.model.EncryptedData;
import ee.mrtnh.encrypter_demo.services.EncrypterDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class EncrypterController {

    private static final Logger logger = LoggerFactory.getLogger(EncrypterController.class);

    private static final String HOME_VIEW = "encrypterDemoUi";

    @Resource
    private EncrypterDataService encrypterDataService;

    @RequestMapping(value = "/demoHome", method = RequestMethod.GET)
    public String showHome() {
        logger.info("Loading home page");
        return HOME_VIEW;
    }

    @RequestMapping(value = "/demoHome/decrypt", method = RequestMethod.POST)
    @ResponseBody
    // The @ResponseBody annotation tells a controller that the object returned is automatically serialized into JSON and passed back into the HttpResponse object.
    public String decryptDataUsingJson(@RequestBody DataPacket dataPacket) {
        logger.info("Called decryptDataUsingJson");
        return encrypterDataService.decryptData(dataPacket);
    }

    @RequestMapping(value = "/demoHome/encrypt", method = RequestMethod.POST)
    @ResponseBody
    public List<EncryptedData> encryptDataUsingJson(@RequestBody DataPacket dataPacket) {
        // @RequestBody see https://www.baeldung.com/spring-thymeleaf-request-parameters
        logger.info("Called encryptDataUsingJson");
        encrypterDataService.encryptData(dataPacket);
        List<EncryptedData> list = encrypterDataService.getAllData();
        return encrypterDataService.getAllData();
    }

    @RequestMapping(value = "/demoHome/getAll", method = RequestMethod.POST)
    @ResponseBody
    public List<EncryptedData> getAllDataRowsUsingJson() {
        logger.info("Called getAllDataRowsUsingJson");
        return encrypterDataService.getAllData(); // Returns JSON array e.g.  [ {"data": "sfgsg, "user": "sdgsdg", "password": "sadgsfg"} ]
    }

}
