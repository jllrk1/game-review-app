package edu.htc.gamedata.services;

import edu.htc.gamedata.entities.Reviewer;
import edu.htc.gamedata.repositories.ReviewerRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReviewerController {

    private ReviewerRepository reviewerRepository;

    private Logger log = Logger.getLogger(ReviewerController.class);

    @Autowired
    public void setReviewerRepository(ReviewerRepository repository) {
        this.reviewerRepository = repository;
    }

    @RequestMapping("/search/reviewer")
    public Reviewer findReviewer(@RequestParam(value = "username") String userName) {
        Reviewer reviewer = reviewerRepository.findOne(userName);
        return reviewer;
    }

    @RequestMapping("/search/reviewerByName")
    public List<Reviewer> findByName(@RequestParam(value = "name") String name) {
        List<Reviewer> reviewers = reviewerRepository.findByNameIgnoreCase(name);
        return reviewers;
    }
    @RequestMapping("/search/reviewerByAge")
    public List<Reviewer> findByAge(@RequestParam(value = "age") int age) {
        List<Reviewer> reviewers = reviewerRepository.findByAge(age);
        return reviewers;
    }
    @RequestMapping("/search/reviewerByGender")
    public List<Reviewer>findByGenderIgnoreCase(@RequestParam(value = "gender") String gender) {
        List<Reviewer> reviewers = reviewerRepository.findByGenderIgnoreCase(gender);
        return reviewers;
    }

}
