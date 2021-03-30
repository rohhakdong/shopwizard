package kr.co.shopwizard.dom;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
public class MantncRepositoryTests {
    @Autowired
    MantncRepository mantncRepository;

    @Test
    public void testClass() {
        System.out.println(mantncRepository.getClass().getName());
    }

    @Test
    public void testInsertDummies() {
        IntStream.rangeClosed(1,100).forEach(i -> {
            Mantnc mantnc = Mantnc.builder().reciptCntnts("Sample..." + i).build();
            mantncRepository.save(mantnc);
        });
    }

    @Test
    public void testSelect1() {
        Long mantncNo = 100L;
        Optional<Mantnc> result = mantncRepository.findById(mantncNo);
        System.out.println("====================");
        if (result.isPresent()) {
            Mantnc mantnc = result.get();
            System.out.println(mantnc);
        }
    }

    @Transactional
    @Test
    public void testSelect2() {
        Long mantncNo = 100L;
        Mantnc mantnc = mantncRepository.getOne(mantncNo);
        System.out.println("====================");
        System.out.println(mantnc);
    }

    @Test
    public void testUpdate() {
        Mantnc mantnc = Mantnc.builder().mantncNo(100L).reciptCntnts("update text").build();
        System.out.println(mantncRepository.save(mantnc));
    }

    @Test
    public void testDelete() {
        Long mantncNo = 100L;
        mantncRepository.deleteById(mantncNo);
    }

    @Test
    public void testPage() {
        Sort sort = Sort.by("mantncNo").descending();
        Pageable pageable = PageRequest.of(0,10, sort);
        Page<Mantnc> result = mantncRepository.findAll(pageable);
        System.out.println(result);
        System.out.println("--------------------");
        System.out.println("Total Pages: " + result.getTotalPages());
        System.out.println("Total count: " + result.getTotalElements());
        System.out.println("Page Number: " + result.getNumber());
        System.out.println("Page Size: " + result.getSize());
        System.out.println("Next Page: " + result.hasNext());
        System.out.println("First Page: " + result.isFirst());
        System.out.println("--------------------");
        for (Mantnc mantnc:result.getContent()) {
            System.out.println(mantnc);
        }
    }
}
