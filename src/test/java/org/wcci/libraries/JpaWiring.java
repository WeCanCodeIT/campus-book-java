package org.wcci.libraries;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class JpaWiring {
    @Autowired
    CampusRepository campusRepo;
    @Autowired
    BookRepository bookRepo;
    @Autowired
    TestEntityManager entityManager;

    @Test
    public void campusShouldHaveManyBooks_BooksShouldHaveOneCampus() {
        Campus testCampus = new Campus("Location", "Description", "Tech Stack");
        campusRepo.save(testCampus);

        Book testBook1 = new Book("Title", "Author", testCampus, "summary");
        Book testBook2 = new Book("Title2", "Author2", testCampus, "summary2");
        bookRepo.save(testBook1);
        bookRepo.save(testBook2);

        entityManager.flush();
        entityManager.clear();

        Campus retrievedCampus = campusRepo.findById(testCampus.getId()).get();

        assertThat(retrievedCampus.getBooks()).contains(testBook1, testBook2);

    }


}
