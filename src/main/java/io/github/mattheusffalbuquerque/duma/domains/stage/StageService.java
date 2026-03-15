package io.github.mattheusffalbuquerque.duma.domains.stage;

import java.util.List;

import org.springframework.stereotype.Service;

import io.github.mattheusffalbuquerque.duma.domains.stage.dto.CreateStageRequest;
import io.github.mattheusffalbuquerque.duma.domains.stage.dto.StageResponse;
import lombok.RequiredArgsConstructor;
import io.github.mattheusffalbuquerque.duma.domains.stage.dto.UpdateStageRequest;

@Service
@RequiredArgsConstructor
public class StageService {

    private final StageRepository stageRepository;
    private final StageMapper stageMapper;


    public List<StageResponse> getAllStages() {
        return stageMapper.toResponseList(stageRepository.findAll());
    }
    
    public StageResponse getStageById(Long id) {

        Stage stage = stageRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Stage not found with id: " + id));

        return stageMapper.toResponse(stage);
    }

    public StageResponse createStage(CreateStageRequest request) {
        
        Stage stage = new Stage();
        
        stage.setName(request.name());
        stage.setSlug(request.slug());
        stage.setShortDescription(request.shortDescription());
        stage.setFullDescription(request.fullDescription());
        stage.setIconUrl(request.iconUrl());
        
        Stage savedStage = stageRepository.save(stage);
        
        return new StageResponse(
            savedStage.getId(),
            savedStage.getName(),
            savedStage.getSlug(),
            savedStage.getShortDescription(),
            savedStage.getIconUrl()
        );
    }

    public StageResponse updateStage(Long id, UpdateStageRequest request) {
        Stage existingStage = stageRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Stage not found with id: " + id));

        if (request.name() != null) {
            existingStage.setName(request.name());
        }
        if (request.slug() != null) {
            existingStage.setSlug(request.slug());
        }
        if (request.shortDescription() != null) {
            existingStage.setShortDescription(request.shortDescription());
        }
        if (request.fullDescription() != null) {
            existingStage.setFullDescription(request.fullDescription());
        }
        if (request.iconUrl() != null) {
            existingStage.setIconUrl(request.iconUrl());
        }
        if (request.isActive() != null) {
            existingStage.setIsActive(request.isActive());
        }

        Stage updatedStage = stageRepository.save(existingStage);

        return new StageResponse(
            updatedStage.getId(),
            updatedStage.getName(),
            updatedStage.getSlug(),
            updatedStage.getShortDescription(),
            updatedStage.getIconUrl()
        );
    }
    
    public Stage findBySlug(String slug) {
        return stageRepository.findBySlug(slug)
            .orElseThrow(() -> new RuntimeException("Stage not found with slug: " + slug));
    }

    public void deleteStage(Long id) {
        Stage existingStage = stageRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Stage not found with id: " + id));
        stageRepository.delete(existingStage);
    }
}
