package kr.co.shopwizard.web;

import kr.co.shopwizard.svc.MantncService;
import kr.co.shopwizard.web.dto.MantncResponseDto;
import kr.co.shopwizard.web.dto.MantncSaveRequestDto;
import kr.co.shopwizard.web.dto.MantncUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class MantncController {

    private final MantncService mantncService;

    @PostMapping("/mantnc")
    public Long save(@RequestBody MantncSaveRequestDto requestDto) {
        return mantncService.save(requestDto);
    }

    @PutMapping("/mantnc/{id}")
    public Long update(@PathVariable Long id, @RequestBody MantncUpdateRequestDto requestDto) {
        return mantncService.update(id, requestDto);
    }

    @DeleteMapping("/mantnc/{id}")
    public Long delete (@PathVariable Long id) {
        mantncService.delete(id);
        return id;
    }

    @GetMapping("/mantnc/{id}")
    public MantncResponseDto findById(@PathVariable Long id) {
        return mantncService.findById(id);
    }

}
