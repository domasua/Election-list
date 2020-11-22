package com.example.taskIBM.controller;
import com.example.taskIBM.data.Data;
import com.example.taskIBM.data.ElectionData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


@RestController
public class Controller {

    private static final Logger log = LoggerFactory.getLogger(Controller.class);
    private static final String url = "https://www.vrk.lt/statiniai/puslapiai/rinkimai/rt.json";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/election")
    public List<Data> getElection(@RequestParam(defaultValue = "false") boolean sorted){
        log.info("received para sorted " + sorted);
        ElectionData electionData = restTemplate.getForObject(
                url, ElectionData.class);

        assert electionData != null;
        List<Data> sortedElectionList = electionData.getData().stream().
                sorted(Comparator.comparing(Data::getRink_data)).collect(Collectors.toList());

        return sortedElectionList;

    }

}
