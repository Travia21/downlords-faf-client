package com.faforever.client.tutorial;

import com.faforever.client.remote.FafService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
@Service
public class TutorialServiceImpl implements TutorialService {
  private final FafService fafService;

  @Inject
  public TutorialServiceImpl(FafService fafService) {
    this.fafService = fafService;
  }

  @Override
  public CompletableFuture<List<TutorialCategory>> getTutorialCategories() {
    return fafService.getTutorialCategories();
  }
}
