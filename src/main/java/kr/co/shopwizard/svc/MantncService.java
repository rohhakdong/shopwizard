package kr.co.shopwizard.svc;

import kr.co.shopwizard.dom.Mantnc;
import kr.co.shopwizard.dom.MantncRepository;
import kr.co.shopwizard.web.dto.MantncListResponseDto;
import kr.co.shopwizard.web.dto.MantncResponseDto;
import kr.co.shopwizard.web.dto.MantncSaveRequestDto;
import kr.co.shopwizard.web.dto.MantncUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class MantncService {
    private final MantncRepository mantncRepository;

    @Transactional
    public Long save(MantncSaveRequestDto requestDto) {
        return mantncRepository.save(requestDto.toEntity()).getMantncNo();
    }

    @Transactional
    public Long update(Long id, MantncUpdateRequestDto requestDto) {
        Mantnc mantnc = mantncRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("id " + id + "에 해당하는 게시글이 없습니다."));
        mantnc.update(requestDto.getTitle(), requestDto.getContent());
        return id;
    }

    @Transactional
    public void delete (Long id) {
        Mantnc mantnc = mantncRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("id " + id + "에 해당하는 게시글이 없습니다."));
        mantncRepository.deleteById(id);
    }

    public MantncResponseDto findById(Long id) {
        Mantnc mantnc = mantncRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("id " + id + "에 해당하는 게시글이 없습니다."));
        return new MantncResponseDto(mantnc);
    }

    @Transactional(readOnly = true)
    public List<MantncListResponseDto> findAll() {
        return mantncRepository.findAll().stream().map(MantncListResponseDto::new).collect(Collectors.toList());
    }
}
