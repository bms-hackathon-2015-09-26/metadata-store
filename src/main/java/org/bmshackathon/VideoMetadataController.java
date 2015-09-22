package org.bmshackathon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class VideoMetadataController {
    private  VideoMetadataRepository videoMetadataRepository;

    @Autowired
    public VideoMetadataController(VideoMetadataRepository videoMetadataRepository) {
        this.videoMetadataRepository = videoMetadataRepository;
    }

    @RequestMapping(value = "/videos/{videoUuid}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<VideoMetadata> findOne(@PathVariable Long videoUuid) {
        return videoMetadataRepository.findOne(videoUuid)
                .map(videoMetadata -> new ResponseEntity<>(videoMetadata, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

//    nie umiem :<
//    public HttpEntity<VideoMetadata> findAll() {
//        Iterable<VideoMetadata> all = videoMetadataRepository.findAll();
//    }

}